package com.mpz.pubfutureproject.entities.enums;

public enum InstituicaoFinanceira {

	Viacredi(1),
	Sicredi(2),
	Nunbank(3),
	BancoInter(4),
	Itaú(5),
	BancoDoBrasil(6);
	
	private int code;
	
	private InstituicaoFinanceira(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static InstituicaoFinanceira valueOf(int code) {
		for(InstituicaoFinanceira value : InstituicaoFinanceira.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código Inválido da Instituição Financeira!");
	}
}