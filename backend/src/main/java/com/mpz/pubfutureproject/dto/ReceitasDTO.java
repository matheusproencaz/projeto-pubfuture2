package com.mpz.pubfutureproject.dto;

import java.time.Instant;

import com.mpz.pubfutureproject.entities.Receitas;
import com.mpz.pubfutureproject.entities.enums.TipoReceita;

public class ReceitasDTO {

	private Long idReceita;
	private Double valor;
	private Instant dataRecebimento;
	private Instant dataReceEsperado;
	private String descricao;
	private TipoReceita tipoReceita;

	public ReceitasDTO(Receitas receita) {
		super();
		idReceita = receita.getIdReceita();
		valor = receita.getValor();
		dataRecebimento = receita.getDataRecebimento();
		dataReceEsperado = receita.getDataRecEsperado();
		descricao = receita.getDescricao();
		tipoReceita = receita.getTipoReceita();
	}

	public ReceitasDTO(Long idReceita, Double valor, Instant dataRecebimento, Instant dataReceEsperado,
			String descricao, TipoReceita tipoReceita) {
		super();
		this.idReceita = idReceita;
		this.valor = valor;
		this.dataRecebimento = dataRecebimento;
		this.dataReceEsperado = dataReceEsperado;
		this.descricao = descricao;
		this.tipoReceita = tipoReceita;
	}

	public Long getIdReceita() {
		return idReceita;
	}

	public void setIdReceita(Long idReceita) {
		this.idReceita = idReceita;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Instant getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Instant dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public Instant getDataReceEsperado() {
		return dataReceEsperado;
	}

	public void setDataReceEsperado(Instant dataReceEsperado) {
		this.dataReceEsperado = dataReceEsperado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}
}
