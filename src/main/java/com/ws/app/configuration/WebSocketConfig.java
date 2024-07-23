package com.ws.app.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.ws.app.util.UrlConstants;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	private static final Logger LOG = LoggerFactory.getLogger(WebSocketConfig.class);

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		try {
			registry.addEndpoint(UrlConstants.STOMP_ENDPOINT).withSockJS();

			LOG.info("registerStompEndpoints..");
		} catch (Exception e) {
			LOG.error("Error Encountered: {}", e.getMessage());
		}
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		try {
			registry.enableSimpleBroker(UrlConstants.REGISTRY_ENDPOINT);
			registry.setApplicationDestinationPrefixes(UrlConstants.APPLICATION_PREFIX);
			
			LOG.info("configureMessageBroker..");
		} catch (Exception e) {
			LOG.error("Error Encountered: {}", e.getMessage());
		}
	}
}
