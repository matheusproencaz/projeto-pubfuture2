package com.mpz.pubfutureproject.test;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mpz.pubfutureproject.entities.Contas;
import com.mpz.pubfutureproject.entities.Despesas;
import com.mpz.pubfutureproject.entities.Receitas;
import com.mpz.pubfutureproject.entities.enums.InstituicaoFinanceira;
import com.mpz.pubfutureproject.entities.enums.TipoConta;
import com.mpz.pubfutureproject.entities.enums.TipoDespesa;
import com.mpz.pubfutureproject.entities.enums.TipoReceita;
import com.mpz.pubfutureproject.repositories.ContasRepository;
import com.mpz.pubfutureproject.repositories.DespesasRepository;
import com.mpz.pubfutureproject.repositories.ReceitasRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	//Injeção de dependência desacoplada.
	
	@Autowired
	private ContasRepository contasRepository;
	
	@Autowired
	private DespesasRepository despRepository;
	
	@Autowired
	private ReceitasRepository recRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Contas c1 = new Contas(null, "Matheus Proença", "1234567", 1000.50, TipoConta.Carteira, InstituicaoFinanceira.BancoDoBrasil);
		Contas c2 = new Contas(null, "Robson Curbani", "1234567", 5000.33, TipoConta.Salário, InstituicaoFinanceira.Itaú);
		Contas c3 = new Contas(null, "Richard Tribess", "1234567", 500.58, TipoConta.Poupança, InstituicaoFinanceira.Nunbank);
		Contas c4 = new Contas(null, "Paula Faria", "1234567", 30000.00, TipoConta.Carteira, InstituicaoFinanceira.BancoInter);		
		
		Despesas des1 = new Despesas(null, 30.00, Instant.parse("2022-01-20T19:53:07Z"), Instant.parse("2022-01-20T20:40:00Z"), TipoDespesa.Alimentação, c1);
		Despesas des2 = new Despesas(null, 200.00, Instant.parse("2022-01-20T19:53:07Z"), Instant.parse("2022-01-20T20:40:00Z"), TipoDespesa.Outros, c1);
		Despesas des3 = new Despesas(null, 500.00, Instant.parse("2022-01-20T19:53:07Z"), Instant.parse("2022-01-20T20:40:00Z"), TipoDespesa.Moradia, c2);
		Despesas des4 = new Despesas(null, 945.00, Instant.parse("2022-01-20T19:53:07Z"), Instant.parse("2022-01-20T20:40:00Z"), TipoDespesa.Outros, c3);
		Despesas des5 = new Despesas(null, 2000.00, Instant.parse("2022-01-20T19:53:07Z"), Instant.parse("2022-01-20T20:40:00Z"), TipoDespesa.Roupas, c4);
		
		Receitas rec1 = new Receitas(null, 3000.0, Instant.parse("2022-01-20T19:53:07Z"), Instant.parse("2022-01-20T20:40:00Z"), "Teste de descrição bem grande já que eu não sei o que digitar.", TipoReceita.Salário, c1);
		Receitas rec2 = new Receitas(null, 1500.0, Instant.parse("2022-01-20T19:53:07Z"), Instant.parse("2022-01-20T20:40:00Z"), "Teste de descrição bem grande já que eu não sei o que digitar.", TipoReceita.Prêmio, c2);
		Receitas rec3 = new Receitas(null, 4000.0, Instant.parse("2022-01-20T19:53:07Z"), Instant.parse("2022-01-20T20:40:00Z"), "Teste de descrição bem grande já que eu não sei o que digitar.", TipoReceita.Salário, c3);
		Receitas rec4 = new Receitas(null, 20000.0, Instant.parse("2022-01-20T19:53:07Z"), Instant.parse("2022-01-20T20:40:00Z"), "Teste de descrição bem grande já que eu não sei o que digitar.", TipoReceita.Outros, c4);
				
		contasRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
		despRepository.saveAll(Arrays.asList(des1,des2,des3,des4,des5));
		recRepository.saveAll(Arrays.asList(rec1,rec2,rec3,rec4));
	}
}
