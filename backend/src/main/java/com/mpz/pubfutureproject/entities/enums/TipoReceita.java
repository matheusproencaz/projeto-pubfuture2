package com.mpz.pubfutureproject.entities.enums;

public enum TipoReceita {

	Salário(1),
	Presente(2),
	Prêmio(3),
	Outros(4);
	
	private int code;
	
	private TipoReceita(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TipoReceita valueOf(int code) {
		for(TipoReceita value : TipoReceita.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido do Tipo Receita!");
	}
	
}