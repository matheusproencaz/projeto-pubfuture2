package com.mpz.pubfutureproject.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mpz.pubfutureproject.entities.Despesas;
import com.mpz.pubfutureproject.services.exceptions.DatabaseException;
import com.mpz.pubfutureproject.services.exceptions.ResourceNotFoundException;
import com.mpz.pubfutureproject.repositories.DespesasRepository;

@Service
public class DespesasService {

	@Autowired
	private DespesasRepository repository;
	
	public List<Despesas> findAll(){
		return repository.findAll();
	}

	public Despesas findById(Long id) {
		Optional<Despesas> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Despesas insert(Despesas obj) {
		return repository.save(obj);
	}
	
	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
		throw new DatabaseException(e.getMessage());
		}
	}
	
	public Despesas update(Long id, Despesas obj) {
		try {
			@SuppressWarnings("deprecation")
			Despesas entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Despesas entity, Despesas obj) {
		entity.setValor(obj.getValor());
		entity.setDataPagamento(obj.getDataPagamento());
		entity.setDataPagEsperado(obj.getDataPagEsperado());
		entity.setTipoDespesa(obj.getTipoDespesa());
	}
}