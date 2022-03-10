package com.mpz.pubfutureproject.entities.enums;

public enum Status {

	PAID(1),
	WAITING(2),
	DELAYED(3);
	
	private int code;
	
	private Status(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static Status valueOf(int code) {
		for(Status value : Status.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de StatusDespesa Inválido.");
	}
}