package com.example.demo.exception_handler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.custome_exceptions.ResourceNotFoundException;


@RestControllerAdvice
public class GolbalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentsNotValidException(MethodArgumentNotValidException e){
		 
          List<FieldError> errors=e.getFieldErrors();
                              
                Map<String,String> map = errors.stream()
                                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
                                
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResourceNotFoundException handleResourceNotFoundException(ResourceNotFoundException e){
		               return new ResourceNotFoundException(e.getMessage());
	}
	
	@ExceptionHandler(RuntimeException.class)
	//@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> handleAnyException(RuntimeException e) {
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	
}
