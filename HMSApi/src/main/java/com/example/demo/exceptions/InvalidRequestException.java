package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidRequestException extends Exception {
	
	
	 public InvalidRequestException() {
	        super();
	    }

	    public InvalidRequestException(BindingResult bindingResult) {
	        super();
	    }

	    public InvalidRequestException(String message, Throwable cause) {
	        super(message, cause);
	    }

}
