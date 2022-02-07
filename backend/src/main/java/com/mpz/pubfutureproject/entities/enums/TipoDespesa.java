package com.mpz.pubfutureproject.entities.enums;

public enum TipoDespesa {

	Alimentação(1),
	Educação(2),
	Lazer(3),
	Moradia(4),
	Roupas(5),
	Transporte(6),
	Outros(7);
	
	private int code;
	
	private TipoDespesa(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TipoDespesa valueOf(int code) {
		for(TipoDespesa value: TipoDespesa.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido do Tipo Receita!");
	}
	
	
	
}
