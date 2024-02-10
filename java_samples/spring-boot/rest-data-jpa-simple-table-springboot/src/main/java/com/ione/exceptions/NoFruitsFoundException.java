package com.ione.exceptions;

import lombok.Getter;

@Getter
public class NoFruitsFoundException extends RuntimeException{

	private String message;
	private static final long serialVersionUID = -2579667245263498805L;
	
	
	public NoFruitsFoundException(String message) {
		super(message);
		this.message = message;
	}

}
