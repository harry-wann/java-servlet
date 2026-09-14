window.onload = function() {
	let url = "ws://localhost:8080/HarryWeb/mycenter";
	let webSocket = new WebSocket(url);
	
	let myDrawer = document.getElementById("myDrawer");
	
	let ctx = myDrawer.getContext("2d");
	ctx.fillStyle = "black";
	ctx.lineWidth = 4;
	let isConnected = false;
	
	// -----------------------------------------
	webSocket.onopen = function() {
		isConnected = true;
	}

	webSocket.onclose = function() {
		isConnected = false;
	}
	
	webSocket.onmessage = function(event) {
		if (!isConnected) {
			return;
		}
		
		let data = JSON.parse(event.data);
		
		if (data.isClear) {
			clear();
		} else {
			let isNewLine = data.isNewLine;
			let x = data.x;
			let y = data.y;
			
			if (isNewLine) {
				newLine(x, y);
			} else {
				drawLine(x, y);
			}	
		}
	}
	
	function clear() {
		ctx.clearRect(0, 0, myDrawer.width, myDrawer.height);
	}
	
	function newLine(x, y) {
		ctx.beginPath();
		ctx.moveTo(x, y);
	}
	
	function drawLine(x, y) {
		ctx.lineTo(x, y);
		ctx.stroke();
	}
}