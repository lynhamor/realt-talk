package com.ws.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {

	private String content;

	private String sender;

	public Message(String content) {
		super();
		this.content = content;
	}

}
