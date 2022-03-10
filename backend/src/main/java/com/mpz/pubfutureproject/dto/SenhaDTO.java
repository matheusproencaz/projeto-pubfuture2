package com.mpz.pubfutureproject.dto;

public class SenhaDTO {

	String senhaAntiga;
	String senhaNova;
	
	public SenhaDTO() {
	}
	
	public SenhaDTO(String senhaAntiga, String senhaNova) {
		this.senhaAntiga = senhaAntiga;
		this.senhaNova = senhaNova;
	}
	
	public String getSenhaAntiga() {
		return senhaAntiga;
	}

	public void setSenhaAntiga(String senhaAntiga) {
		this.senhaAntiga = senhaAntiga;
	}

	public String getSenhaNova() {
		return senhaNova;
	}

	public void setSenhaNova(String senhaNova) {
		this.senhaNova = senhaNova;
	}
}