package com.mpz.pubfutureproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpz.pubfutureproject.entities.Despesas;

@Repository
public interface DespesasRepository extends JpaRepository<Despesas, Long>{
}