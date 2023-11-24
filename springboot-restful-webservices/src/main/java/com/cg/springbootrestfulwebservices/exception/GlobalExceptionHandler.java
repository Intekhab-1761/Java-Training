package com.cg.springbootrestfulwebservices.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

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
	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		
//		Map<String,String> errors = new HashMap<>();
//		List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
//		errorList.forEach(error ->{
//			String fieldName = ((FieldError) error).getField();
//			String message = error.getDefaultMessage();
//			errors.put(fieldName,message);
//		});
//		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//	}
}
