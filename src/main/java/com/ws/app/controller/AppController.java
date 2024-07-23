package com.ws.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.ws.app.model.Message;
import com.ws.app.util.UrlConstants;

@Controller
public class AppController {

	private static final Logger LOG = LoggerFactory.getLogger(AppController.class);
	
	@MessageMapping(UrlConstants.REGISTER)
	@SendTo(UrlConstants.DESTINATION)
	public Message register(Message message, SimpMessageHeaderAccessor accessor) {
		LOG.trace("register..");
		accessor.getSessionAttributes().put("username", message.getSender());
		LOG.trace("register done ... {}", message.toString());
		
		return message;
	}

	@MessageMapping(UrlConstants.CHAT)
	@SendTo(UrlConstants.DESTINATION)
	public Message send(Message message) throws InterruptedException {
		LOG.trace("send message ..");
		Thread.sleep(1000); 
		Message sender = new Message(message.getContent(), message.getSender());
		LOG.trace("send message .. {}",sender.toString());
		
		return sender;
	}
}
