var socket = io.connect('http://localhost:3000', { 'forceNew': true });

function addMessage(e) {
	var mensaje = {
    normales: document.getElementById('normales').value,
    infantiles: document.getElementById('infantiles').value,
    llevar: document.getElementById('llevar').value,
    bebidas: document.getElementById('bebidas').value
  };
	console.log(mensaje)
  socket.emit('nuevo-pedido', mensaje);
  return false;
}
