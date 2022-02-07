package com.mpz.pubfutureproject.entities.enums;

public enum TipoConta {

	Salário(1),
	Corrente(2),
	Carteira(3),
	Poupança(4);
	
	private int code;
	
	private TipoConta(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TipoConta valueOf(int code) {
		for(TipoConta value : TipoConta.values()) {
			if(value.getCode()  == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código Inválido do Tipo Conta!");
	}
}