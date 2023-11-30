package com.electricity.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


/**
 * The `GlobalExceptionHandler` class is responsible for handling exceptions that may occur within the application.
 * It defines methods for handling specific exception types and returning error details as `MyErrorDetails` objects.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
     * Handles exceptions of type `NotFoundException` by returning error details.
     *
     * @param e   The `NotFoundException` exception.
     * @param req The current WebRequest.
     * @return A ResponseEntity containing error details and a status code.
     */
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyErrorDetails> batteryNotFound(NotFoundException e, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}
	
	/**
     * Handles generic exceptions (of type `Exception`) by returning error details.
     *
     * @param e   The generic exception.
     * @param req The current WebRequest.
     * @return A ResponseEntity containing error details and a status code.
     */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(Exception e, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		
	}
}
