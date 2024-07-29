package com.ws.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Service;

import com.ws.app.model.Message;
import com.ws.app.service.WebSocketService;

@Service
public class WebSocketServiceImpl implements WebSocketService {

	private static final Logger LOG = LoggerFactory.getLogger(WebSocketServiceImpl.class);

	@Override
	public Message register(Message message, SimpMessageHeaderAccessor accessor) {
		LOG.trace("register..");
		accessor.getSessionAttributes().put("username", message.getSender());
		LOG.trace("register done ... {}", message.toString());

		return message;
	}

	@Override
	public Message send(Message message) throws InterruptedException {
		LOG.trace("send message ..");
		Thread.sleep(1000);
		Message sender = new Message(message.getContent(), message.getSender());
		LOG.trace("send message .. {}", sender.toString());

		return sender;
	}

}
