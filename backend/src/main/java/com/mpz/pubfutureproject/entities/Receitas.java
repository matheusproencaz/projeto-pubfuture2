package com.mpz.pubfutureproject.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mpz.pubfutureproject.entities.enums.TipoReceita;

@Entity
@Table(name = "tb_receitas")
public class Receitas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReceita;
	private Double valor;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataRecebimento;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataRecEsperado;
	private String descricao;
	private Integer tipoReceita;
	
	//private Integer status;
	
	@ManyToOne
	private Contas conta;
	
	public Receitas() {
	}
	
	public Receitas(Long idReceita, Double valor, Instant dataRecebimento, Instant dataRecEsperado, String descricao,
			TipoReceita tipoReceita) {
		super();
		this.idReceita = idReceita;
		this.valor = valor;
		this.dataRecebimento = dataRecebimento;
		this.dataRecEsperado = dataRecEsperado;
		this.descricao = descricao;
		setTipoReceita(tipoReceita);
	}
	
	public Receitas(Long idReceita, Double valor, Instant dataRecebimento, Instant dataRecEsperado, String descricao,
			TipoReceita tipoReceita, Contas conta) {
		super();
		this.idReceita = idReceita;
		this.valor = valor;
		this.dataRecebimento = dataRecebimento;
		this.dataRecEsperado = dataRecEsperado;
		this.descricao = descricao;
		setTipoReceita(tipoReceita);
		this.conta = conta;
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

	public Instant getDataRecEsperado() {
		return dataRecEsperado;
	}

	public void setDataRecEsperado(Instant dataRecEsperado) {
		this.dataRecEsperado = dataRecEsperado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoReceita getTipoReceita() {
		return TipoReceita.valueOf(tipoReceita);
	}

	public void setTipoReceita(TipoReceita tipoReceita) {
		if(tipoReceita != null) {
			this.tipoReceita = tipoReceita.getCode();
		}
	}

//	public Status getStatus() {
//		return Status.valueOf(status);
//	}
//
//	public void setStatus(Status status) {
//		if(status != null) {
//			this.status = status.getCode();
//		}
//	}

	public Contas getConta() {
		return conta;
	}

	public void setConta(Contas conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idReceita);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receitas other = (Receitas) obj;
		return Objects.equals(idReceita, other.idReceita);
	}
}