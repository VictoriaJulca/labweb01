package com.ivjo.ms.proyectos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorMessage>resourceNotFoundException(EntityNotFoundException ex, WebRequest request){
		ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(IllegalOperationException.class)
	public ResponseEntity<ErrorMessage>illegalOperationException(IllegalOperationException ex, WebRequest request){
		ErrorMessage message=new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage>globalExceptionHandler(Exception ex, WebRequest request){
		ErrorMessage message=new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
