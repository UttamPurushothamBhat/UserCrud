package com.uttam.project.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserCrudException {
	
	private final String message;
	private final HttpStatus status;
	
	

}
