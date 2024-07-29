package com.ws.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.ws.app.model.Message;
import com.ws.app.service.WebSocketService;
import com.ws.app.util.UrlConstants;

@Controller
public class AppController {

	@Autowired
	private WebSocketService service;
	
	@MessageMapping(UrlConstants.REGISTER)
	@SendTo(UrlConstants.DESTINATION)
	public Message register(Message message, SimpMessageHeaderAccessor accessor) {
		return service.register(message, accessor);
	}

	@MessageMapping(UrlConstants.CHAT)
	@SendTo(UrlConstants.DESTINATION)
	public Message send(Message message) throws InterruptedException {
		return service.send(message);
	}
}
