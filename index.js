var express = require('express')
var app = express()

app.use(express.static('public'));

var server = require('http').Server(app)
var io = require('socket.io')(server)
var pedidos = new Array()
server.listen(3000, function() {
	console.log('Servidor corriendo en http://localhost:3000');
});
var cocinaNameSpace = io.of('/cocinaspace');
var parilla = io.of('/parilla');
cocinaNameSpace.on('connection', function(socket){
  console.log('escapcio de cocina conectado');
});
io.on('connection', function(socket) {
  console.log('un cliente se a conectado')
  socket.emit('bien venido')
	socket.on('nuevo-pedido', function(data) {
		pedidos.push(data);
		console.log(data)
		enviarACocina(pedidos)
	});
})
function enviarACocina(pedidos)
{
			cocinaNameSpace.emit('messages', pedidos);
}
