window.onload = function() {
	
	const URL = "ws://localhost:8080/HarryWeb/myserver";
	
	let start = document.getElementById('start');
	let chatDiv = document.getElementById('chatDiv');
	let msg = document.getElementById('msg');
	let send = document.getElementById('send');
	let log = document.getElementById('log');
	
	let websocket;
	
	start.style.display = "block";
	chatDiv.style.display = "none";
	
	start.addEventListener("click", function() {
		connect(URL);
	})
	
	send.addEventListener("click", function() {
		let msgObj = {
			message: msg.value
		}
		websocket.send(JSON.stringify(msgObj));
	})
	
	function connect(url) {
		console.log("connect");	
		websocket = new WebSocket(url);
		websocket.onopen = function() {
			console.log("onopen");
			start.style.display = "none";
			chatDiv.style.display = "block";
		}
		websocket.onmessage = function(ev) {
			console.log(ev);
			let msgObj = JSON.parse(ev.data);
			console.log(msgObj);
			log.innerHTML += (msgObj.message + "<br/>");
		}
		websocket.onclose = function(socket, ev) {
			console.log("onclose");
		}
		websocket.onerror = function() {
			console.log("onerror");	
		}
	}
}