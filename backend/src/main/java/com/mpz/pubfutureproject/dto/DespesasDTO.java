package com.mpz.pubfutureproject.dto;

import java.time.Instant;

import com.mpz.pubfutureproject.entities.Despesas;
import com.mpz.pubfutureproject.entities.enums.TipoDespesa;

public class DespesasDTO {

	private Long idDespesas;
	private Double valor;
	private Instant dataPagamento;
	private Instant dataPagEsperado;
	private TipoDespesa tipoDespesa;
	
	public DespesasDTO(Despesas despesa) {
		idDespesas = despesa.getIdDespesas();
		valor = despesa.getValor();
		dataPagamento = despesa.getDataPagamento();
		dataPagEsperado = despesa.getDataPagEsperado();
		tipoDespesa = despesa.getTipoDespesa();
	}
		
	public DespesasDTO(Long idDespesas, Double valor, Instant dataPagamento, Instant dataPagEsperado,
			TipoDespesa tipoDespesa) {
		super();
		this.idDespesas = idDespesas;
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.dataPagEsperado = dataPagEsperado;
		this.tipoDespesa = tipoDespesa;
	}

	public Long getIdDespesas() {
		return idDespesas;
	}

	public void setIdDespesas(Long idDespesas) {
		this.idDespesas = idDespesas;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Instant getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Instant dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Instant getDataPagEsperado() {
		return dataPagEsperado;
	}

	public void setDataPagEsperado(Instant dataPagEsperado) {
		this.dataPagEsperado = dataPagEsperado;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
}