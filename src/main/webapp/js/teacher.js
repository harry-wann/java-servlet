window.onload = function() {
	let url = "ws://localhost:8080/HarryWeb/mycenter";
	let webSocket = new WebSocket(url);
	
	
	let clear = document.getElementById("clear");
	let myDrawer = document.getElementById("myDrawer");
	
	let ctx = myDrawer.getContext("2d");
	ctx.fillStyle = "black";
	ctx.lineWidth = 4;
	let isDrag = false;
	let isConnected = false;
	
	// -----------------------------------------
	webSocket.onopen = function(session) {
		isConnected = true;
		let data = {
			isTeacher: true
		};
		webSocket.send(JSON.stringify(data));
	}
	
	webSocket.onclose = function(session) {
		isConnected = false;
	}
	
	// -----------------------------------------
	
	myDrawer.onmousedown = function(e) {
		isDrag = true;
		let x = e.offsetX, y = e.offsetY;
		
		ctx.beginPath();
		ctx.moveTo(x, y);
		
		let data = {
			isNewLine: true,
			isClear: false,
			x: x,
			y: y
		};
		webSocket.send(JSON.stringify(data));
	}
	
	myDrawer.onmouseup = function(e) {
		isDrag = false;
	}
	
	myDrawer.onmouseleave = function(e) {
		isDrag = false;
	}
	
	myDrawer.onmousemove = function(e) {
		if (isDrag) {
			let x = e.offsetX, y = e.offsetY;
			ctx.lineTo(x, y);
			ctx.stroke();
			
			let data = {
				isNewLine: false,
				isClear: false,
				x: x,
				y: y
			};
			webSocket.send(JSON.stringify(data));
		}
	}
	
	clear.addEventListener("click", function() {
		ctx.clearRect(0, 0, myDrawer.width, myDrawer.height);
		
		let data = {
			isClear: true
		};
		webSocket.send(JSON.stringify(data));
	})
}