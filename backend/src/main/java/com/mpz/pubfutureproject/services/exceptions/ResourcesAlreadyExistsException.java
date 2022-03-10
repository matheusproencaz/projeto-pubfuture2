package com.mpz.pubfutureproject.services.exceptions;

public class ResourcesAlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourcesAlreadyExistsException() {
		super("Resource Alredy Exists!");
	}
}
