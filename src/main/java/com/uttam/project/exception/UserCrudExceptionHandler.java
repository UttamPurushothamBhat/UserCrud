package com.uttam.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class UserCrudExceptionHandler {

	@ExceptionHandler(value = {UserNotFoundException.class, AccountNotFoundException.class})
	public ResponseEntity<Object> handleNotFoundException(RuntimeException runtimeException){
		UserCrudException userCrudException =UserCrudException.builder()
				.message(runtimeException.getMessage())
				.status(HttpStatus.NOT_FOUND)
				.build();
		
		return new ResponseEntity<>(userCrudException, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value = {ValidationException.class})
	public ResponseEntity<Object> handleValidationException(ValidationException validationException){
		UserCrudException userCrudException =UserCrudException.builder()
				.message(validationException.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.build();
		
		return new ResponseEntity<>(userCrudException, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value = {RuntimeException.class})
	public ResponseEntity<Object> handleRuntimeException(RuntimeException runtimeException){
		UserCrudException userCrudException =UserCrudException.builder()
				.message(runtimeException.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.build();
		
		return new ResponseEntity<>(userCrudException, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
