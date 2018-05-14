var socket = io.connect('http://localhost:3000', { 'forceNew': true });

function addMessage(e) {
	var mensaje = {
    normales: document.getElementById('username').normales,
    infantiles: document.getElementById('texto').infantiles,
    llevar: document.getElementById('texto').llevar,
    bebidas: document.getElementById('texto').bebidas
  };

  socket.emit('nuevo-pedido', mensaje);
  return false;
}
