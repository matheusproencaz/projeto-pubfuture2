package com.mpz.pubfutureproject.services.exceptions;

public class WrongPasswordException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public WrongPasswordException(String msg) {
		super("Wrong password! "+msg);
	}
}
