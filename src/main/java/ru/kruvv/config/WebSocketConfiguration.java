/**
 * 
 */
package ru.kruvv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author viktor
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer {

	/*
	 * This method connects the final address to which we will listen and transmit
	 * messages. .withSockJS () - says that the SockJS library will be used which is
	 * a wrapper for standard web sockets and provides their more convenient use.
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat-messaging").withSockJS();
	}

	/* This method specify the prefixes and addresses of our web socket endpoint */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/chat");
		config.setApplicationDestinationPrefixes("/app");
	}

}
