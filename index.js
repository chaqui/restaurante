var express = require('express')
var app = express()
app.get('/',function(request,response)
{
  response.send('hola mundo')

})

var server = require('http').Server(app)
var io = require('socket.io')(server)

server.listen(3000, function() {
	console.log('Servidor corriendo en http://localhost:3000');
});
