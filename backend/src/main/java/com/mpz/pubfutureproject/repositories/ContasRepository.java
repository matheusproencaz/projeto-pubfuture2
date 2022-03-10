package com.mpz.pubfutureproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mpz.pubfutureproject.entities.Contas;

@Repository
public interface ContasRepository extends JpaRepository<Contas, Long>{
	
	Contas findByNomeUsuario(String nomeUsuario);
	
	@Query("SELECT obj FROM Contas obj JOIN FETCH obj.despesas JOIN FETCH obj.receitas")
	List<Contas> findContasDespesasReceitas();
}