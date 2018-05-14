var socket = io.connect('http://localhost:3000', { 'forceNew': true });

function render(data) {
	var html = data.map(function(elem, index){

    	return(`<div>
        		 <strong>Normales:</strong>  <em>${elem.normales}</em>
              <strong>Infantiles:</strong>  <em>${elem.infantiles}</em>
              <strong>Llevar:</strong>  <em>${elem.llevar}</em>
        </div>`)
    }).join(" ");

    document.getElementById('messages').innerHTML = html;
}

socket.on('messages', function(data) {
	render(data);
});
