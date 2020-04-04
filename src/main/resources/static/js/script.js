/*После того, как создали stompClient — вызывается метод connect 
 * в котором клиент подписывается на урл /chat/messages. Таким образом он будет 
 * слушать все, что придет по этому адресу без перезагрузки страницы. 
 * С информацией, которая придет от сервера можно делать все что угодно. 
 * В данном случае я ее распарсиваю var data = JSON.parse(response.body); 
 * и передаю в метод draw(«left», data.message);.
 * */
function connect() {
	var socket = new SockJS('/chat-messaging');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		console.log("connected: " + frame);
		stompClient.subscribe('/chat/messages', function(response) {
			var data = JSON.parse(response.body);
			draw("left", data.message);
		});
	});
}

/*Метод draw выполняет функцию красивого наполнения странички информацией.*/
function draw(side, text) {
	console.log("drawing...");
    var $message;
    $message = $($('.message_template').clone().html());
    $message.addClass(side).find('.text').html(text);
    $('.messages').append($message);
    return setTimeout(function () {
        return $message.addClass('appeared');
    }, 0);

}
function disconnect(){
	stompClient.disconnect();
}

/*Этот метод отправляет сообщение по адресу /app/message*/
function sendMessage(){
	stompClient.send("/app/message", {}, JSON.stringify({'message': $("#message_input_value").val()}));

}