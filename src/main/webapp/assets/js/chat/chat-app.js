let stompClient = null;
let userName = null;

function register() {
    const socket = new SockJS('/ws-chat');
    stompClient = Stomp.over(socket);

    userName = $('#registerInput').val();
    console.log('registerInput: ' + userName);

    stompClient.connect({}, function() {
        onConnected(userName);
    }, onError);

    $('#registerInput').val('');

    $('#chat-message').show();
    $('#chat-register').hide();
}

function onConnected(username) {
    stompClient.subscribe('/topic/messages', onMessageReceived);
    
    var register = {
        content: '',
        sender: username
    };
    stompClient.send("/app/register", {}, JSON.stringify(register));
}

function sendMessage() {
    const messageInput = $('#messageInput').val();
    console.log('sendMessage: ' + messageInput);
    var chatMessage = {
        content: messageInput,
        sender: userName
    };
    
    stompClient.send("/app/chat", {}, JSON.stringify(chatMessage));
    $('#messageInput').val('');
    showMessage(userName + ": " + messageInput, true);
}

function showMessage(message, isSent) {
    console.log('showMessage: ' + message);
    const messageClass = isSent ? 'sent' : 'received';
    $('#messages').append('<li class="message ' + messageClass + '">' + message + '</li>');
}

function onMessageReceived(message) {
    const messageContent = JSON.parse(message.body);
    if (messageContent.sender && !messageContent.content) {
        showMessage(messageContent.sender + " has joined.", false);
    } else if (messageContent.content && messageContent.sender !== userName) {
        showMessage(messageContent.sender + ": " + messageContent.content, false);
    }
    
    
}

function onError(error) {
    console.error('Error: ' + error);
}

$(document).ready(function() {
    $('#chat-message').hide();
});