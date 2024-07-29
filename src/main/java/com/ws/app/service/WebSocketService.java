package com.ws.app.service;

import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import com.ws.app.model.Message;

public interface WebSocketService {

	Message register(Message message, SimpMessageHeaderAccessor accessor);
	
	Message send(Message message) throws InterruptedException;
}
