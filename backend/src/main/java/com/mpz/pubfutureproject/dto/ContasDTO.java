package com.mpz.pubfutureproject.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mpz.pubfutureproject.entities.Contas;
import com.mpz.pubfutureproject.entities.enums.InstituicaoFinanceira;
import com.mpz.pubfutureproject.entities.enums.TipoConta;

public class ContasDTO {

	private Long idConta;
	private String nomeUsuario;
	private String senha;
	private Double saldo;
	
	private TipoConta tipoConta;
	private InstituicaoFinanceira instituicaoFin;
	
	private List<DespesasDTO> despesas = new ArrayList<>();
	private List<ReceitasDTO> receitas = new ArrayList<>();
	
	public ContasDTO() {
	}
	
	public ContasDTO(Contas conta) {
		super();
		idConta = conta.getIdConta();
		nomeUsuario = conta.getNomeUsuario();
		senha = conta.getSenha();
		saldo = conta.getSaldo();
		tipoConta = conta.getTipoConta();
		instituicaoFin = conta.getInstituicaoFin();
		despesas = conta.getDespesas().stream().map(x -> new DespesasDTO(x)).collect(Collectors.toList());
		receitas = conta.getReceitas().stream().map(x -> new ReceitasDTO(x)).collect(Collectors.toList());
	}	
	
	public ContasDTO(Long idConta, String nomeUsuario, String senha, Double saldo, TipoConta tipoConta,
			InstituicaoFinanceira instituicaoFin, List<DespesasDTO> despesas, List<ReceitasDTO> receitas) {
		super();
		this.idConta = idConta;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.instituicaoFin = instituicaoFin;
		this.despesas = despesas;
		this.receitas = receitas;
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
		return tipoConta;
	}
	
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public InstituicaoFinanceira getInstituicaoFin() {
		return instituicaoFin;
	}
	
	public void setInstituicaoFin(InstituicaoFinanceira instituicaoFin) {
		this.instituicaoFin = instituicaoFin;
	}
	
	public List<DespesasDTO> getDespesas() {
		return despesas;
	}

	public List<ReceitasDTO> getReceitas() {
		return receitas;
	}
}
