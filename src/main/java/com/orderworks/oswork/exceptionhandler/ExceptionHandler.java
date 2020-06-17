package com.orderworks.oswork.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		
		var problema = new Problems();
		problema.setStatus(status.value());
		problema.setTitle("Um ou mais campos estão incorretos no preenchimento, tente novamente");
		problema.setDateTime(LocalDateTime.now());
		var fields = new ArrayList<Fields>();
		for (ObjectError error: ex.getBindingResult().getAllErrors()) {
			String name = (((FieldError) error).getField());
			String message = error.getDefaultMessage();
			fields.add(new Fields(name, message));
		}
		problema.setFields(fields);
		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}
}
