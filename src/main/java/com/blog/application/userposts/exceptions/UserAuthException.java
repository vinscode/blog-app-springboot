package com.blog.application.userposts.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserAuthException extends RuntimeException{
	
	public UserAuthException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
