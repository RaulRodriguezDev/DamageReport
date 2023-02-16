package com.hpel.hpelfinaljava.exceptions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomHandlerExceptions extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		String errorsMessages = "";
		
		List<FieldError> errors = new ArrayList<>();
		
		errors = ex.getFieldErrors();
		
		ListIterator<FieldError> iterator = errors.listIterator();
		
		while(iterator.hasNext()) {
			errorsMessages += "[ " + iterator.next().getDefaultMessage()+ "] ";
		}

		ErrorDetails errorDetails = new ErrorDetails(ex.getErrorCount(),status.getReasonPhrase(),
				errorsMessages,LocalDate.now());
		
		
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}

}
