/**
 * 
 */
package ru.kruvv.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import ru.kruvv.domain.Message;

/**
 * @author viktor
 *
 */
@Controller
public class ChatController {

	@MessageMapping("/message")
	@SendTo("/chat/messages")
	public Message getMessages(Message message) {
		System.out.println(message);
		return message;
	}
}
