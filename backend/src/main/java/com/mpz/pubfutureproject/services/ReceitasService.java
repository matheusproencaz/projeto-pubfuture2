package com.mpz.pubfutureproject.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mpz.pubfutureproject.entities.Receitas;
import com.mpz.pubfutureproject.services.exceptions.DatabaseException;
import com.mpz.pubfutureproject.services.exceptions.ResourceNotFoundException;
import com.mpz.pubfutureproject.repositories.ReceitasRepository;

@Service
public class ReceitasService {

	@Autowired
	private ReceitasRepository repository;
	
	public List<Receitas> findAll(){
		return repository.findAll();
	}

	public Receitas findById(Long id) {
		Optional<Receitas> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Receitas insert(Receitas obj) {
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
	
	public Receitas update(Long id, Receitas obj) {
		try {
			@SuppressWarnings("deprecation")
			Receitas entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Receitas entity, Receitas obj) {
		entity.setValor(obj.getValor());
		entity.setDataRecebimento(obj.getDataRecebimento());
		entity.setDataRecEsperado(obj.getDataRecEsperado());
		entity.setDescricao(obj.getDescricao());
		entity.setTipoReceita(obj.getTipoReceita());
	}
}