var socket = io.connect('http://localhost:3000/cocinaspace', { 'forceNew': true });

function render(data) {
	var html = data.map(function(elem, index){
			console.log(elem)
			if (elem.llevar == undefined) {
				return(`<div class="card"  style="width: 18rem;">
							<div class="card-body">
	        		 <strong>Normales:</strong>  <em>${elem.normales}</em>
	              <strong>Infantiles:</strong>  <em>${elem.infantiles}</em>
	        </div>
					</div>
		 </div>`)
			}
    	return(`<div class="card"  style="width: 18rem;">
						<div class="card-body">
              <strong>Llevar:</strong>  <em>${elem.llevar}</em>
        </div>
				</div>
	 </div>`)
    }).join(" ");

    document.getElementById('platos').innerHTML = html;
}

socket.on('messages', function(data) {
	render(data);
});
