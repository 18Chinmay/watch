package com.wowcher.watch.exceptions;

import java.net.http.HttpHeaders;

import javax.persistence.EntityNotFoundException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class WatchRestExcepionalHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	       String error = "Invalid Input, Please enter time in HH:MM format";
	       return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	   }

	   private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }  
	   
	   @ExceptionHandler(EntityNotFoundException.class)
	   protected ResponseEntity<Object> handleEntityNotFound(
	           EntityNotFoundException ex) {
	       ApiError apiError = new ApiError();
	       apiError.setMessage(ex.getMessage());
	       return buildResponseEntity(apiError);
	   }

}
