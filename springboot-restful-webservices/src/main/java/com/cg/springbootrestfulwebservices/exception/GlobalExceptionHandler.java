package com.cg.springbootrestfulwebservices.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
		ErrorDetails errordetails = new ErrorDetails(
		LocalDateTime.now(),
		exception.getMessage(),
		webRequest.getDescription(false),
		"USER_NOT_FOUND"
		);
		
		return new ResponseEntity<ErrorDetails>(errordetails, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(EmailAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handleEmailAlreadyExistException(EmailAlreadyExistException exception, WebRequest webRequest){
		ErrorDetails errordetails = new ErrorDetails(
		LocalDateTime.now(),
		exception.getMessage(),
		webRequest.getDescription(false),
		"USER_EMAIL_ALREADY_EXIST"
		);
		
		return new ResponseEntity<ErrorDetails>(errordetails, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest){
		ErrorDetails errordetails = new ErrorDetails(
		LocalDateTime.now(),
		exception.getMessage(),
		webRequest.getDescription(false),
		"INTERNAL_SERVER_ERROR"
		);
		
		return new ResponseEntity<ErrorDetails>(errordetails, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
