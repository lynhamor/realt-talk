<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ChatHaven</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css">
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1.5.0/dist/sockjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/stompjs@2.3.3/lib/stomp.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.min.js"></script>
</head>

<body>
	<div class="container text-center">
		<h1>ChatHaven</h1>
		<div id="chat-register" class="form-group">
			<div class="input-wrapper">
				<input type="text" id="registerInput" class="form-control" placeholder="Enter your username">
				<button class="btn btn-primary" onclick="register()">Register</button>
			</div>
		</div>
		<div id="chat-message" class="form-group">
			<div class="input-wrapper">
				<input type="text" id="messageInput" class="form-control" placeholder="Type a message">
				<button class="btn btn-primary" onclick="sendMessage()">Send</button>
			</div>
		</div>
		<div id="message-container" class="form-group">
			<h2>Messages:</h2>
			<ul id="messages" class="list-unstyled"></ul>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/assets/js/chat/chat-app.js"></script>
</html>
