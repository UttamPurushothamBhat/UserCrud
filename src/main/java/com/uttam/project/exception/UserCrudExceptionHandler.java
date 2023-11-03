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
}
