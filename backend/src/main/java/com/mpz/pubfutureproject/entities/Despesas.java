package com.mpz.pubfutureproject.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mpz.pubfutureproject.entities.enums.TipoDespesa;

@Entity
@Table(name = "tb_despesas")
public class Despesas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDespesas;
	private Double valor;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataPagamento;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataPagEsperado;
	private TipoDespesa tipoDespesa;
	
	private String nomeUsuario;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "conta")
	private Contas conta;
	
	public Despesas() {
	}

	public Despesas(Long idDespesas, Double valor, Instant dataPagamento, Instant dataPagEsperado,
			TipoDespesa tipoDespesa, Contas conta) {
		this.idDespesas = idDespesas;
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.dataPagEsperado = dataPagEsperado;
		this.tipoDespesa = tipoDespesa;
		this.conta = conta;
		this.nomeUsuario = conta.getNomeUsuario();
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

	public Contas getConta() {
		return conta;
	}

	public void setConta(Contas conta) {
		this.conta = conta;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDespesas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Despesas other = (Despesas) obj;
		return Objects.equals(idDespesas, other.idDespesas);
	}
}