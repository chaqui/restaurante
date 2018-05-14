var socket = io.connect('http://localhost:3000', { 'forceNew': true });

function addMessage(e) {
	var mensaje = {
    llevar: document.getElementById('llevar').value,

  };

  socket.emit('nuevo-pedido', mensaje);
  return false;
}
