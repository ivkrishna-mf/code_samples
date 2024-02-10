package com.ione.exception.handlers;

import java.net.URI;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import com.ione.exceptions.NoFruitsFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	//this response will be presented. By default problem detail will be used for latest version of spring boot for the exceptions.
	@org.springframework.web.bind.annotation.ExceptionHandler(NoFruitsFoundException.class)
	public ResponseEntity<String> handleNoFruitsFoundException(NoFruitsFoundException ex, WebRequest request){
		
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NO_CONTENT);
	}
	
	//this PD will be used for response
	public ProblemDetail handleException(Exception ex, WebRequest request) {
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		
		problemDetail.setTitle("error");
		problemDetail.setType(URI.create(""));
		
		return problemDetail;
		
	}
	//This will provide only exception message and http status code
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity handleDataIntegrityException(DataIntegrityViolationException ex) {
		return  new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		
		
	}

}
