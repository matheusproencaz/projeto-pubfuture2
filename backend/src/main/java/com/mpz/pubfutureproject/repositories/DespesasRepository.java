package com.mpz.pubfutureproject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpz.pubfutureproject.entities.Contas;
import com.mpz.pubfutureproject.entities.Despesas;

public interface DespesasRepository extends JpaRepository<Despesas, Long>{
	
	List<Despesas> findByConta(Optional<Contas> conta);
}