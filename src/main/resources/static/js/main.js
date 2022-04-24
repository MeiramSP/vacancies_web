var stompClient = null;
window.onload = connect();
	
function connect() {
    var socket = new SockJS('/our-websocket');
    stompClient = Stomp.over(socket);
    
    stompClient.connect({}, function(frame) {    
        stompClient.subscribe('/user/topic/private-notify', function(greeting){		
            alert('Сіз жұмысқа ұсыныс алдыңыз! Хабарландыру бөліміне өтіңіз');
        });
    });
}