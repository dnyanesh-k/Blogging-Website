package com.example.demo.custome_exceptions;

import lombok.experimental.SuperBuilder;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String msg) {
	super(msg);
	}
}
