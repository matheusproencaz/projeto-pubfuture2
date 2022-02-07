package com.mpz.pubfutureproject.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mpz.pubfutureproject.entities.enums.InstituicaoFinanceira;
import com.mpz.pubfutureproject.entities.enums.TipoConta;

@Entity
@Table(name = "tb_contas")
public class Contas implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConta;
	private String nomeUsuario;
	private String senha;
	private Double saldo;
	
	private Integer tipoConta;
	private Integer instituicaoFin;
	
	@JsonIgnore
	@OneToMany(mappedBy = "conta",cascade = CascadeType.ALL)
	private Set<Receitas> receitas = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "conta",cascade = CascadeType.ALL)
	private Set<Despesas> despesas = new HashSet<>();
	
	public Contas() {
	}

	public Contas(Long idConta, String nomeUsuario, String senha, Double saldo, TipoConta tipoConta,
			InstituicaoFinanceira instituicaoFin) {
		this.idConta = idConta;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.saldo = saldo;
		setTipoConta(tipoConta);
		setInstituicaoFin(instituicaoFin);
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public TipoConta getTipoConta() {
		return TipoConta.valueOf(tipoConta);
	}

	public void setTipoConta(TipoConta tipoConta) {
		if(tipoConta != null) {
			this.tipoConta = tipoConta.getCode();
		}
	}

	public InstituicaoFinanceira getInstituicaoFin() {
		return InstituicaoFinanceira.valueOf(instituicaoFin);
	}

	public void setInstituicaoFin(InstituicaoFinanceira instituicaoFin) {
		if(instituicaoFin != null) {
			this.instituicaoFin = instituicaoFin.getCode();
		}
	}
	
	public Set<Receitas> getReceitas() {
		return receitas;
	}

	public Set<Despesas> getDespesas() {
		return despesas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idConta, nomeUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contas other = (Contas) obj;
		return Objects.equals(idConta, other.idConta) && Objects.equals(nomeUsuario, other.nomeUsuario);
	}
}
