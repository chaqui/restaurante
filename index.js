var express = require('express')
var app = express()

app.use(express.static('public'));

var server = require('http').Server(app)
var io = require('socket.io')(server)
var pedidos = new Array()
server.listen(3000, function() {
	console.log('Servidor corriendo en http://localhost:3000');
});

io.on('connection', function(socket) {
  console.log('un cliente se a conectado')
  socket.emit('bien venido')
	socket.on('nuevo-pedido', function(data) {
		pedidos.push(data);
		console.log(data)
		io.sockets.emit('messages', pedidos);
	});
})
