package com.mpz.pubfutureproject.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mpz.pubfutureproject.entities.Receitas;
import com.mpz.pubfutureproject.repositories.ReceitasRepository;
import com.mpz.pubfutureproject.services.exceptions.DatabaseException;
import com.mpz.pubfutureproject.services.exceptions.ResourceNotFoundException;

@Service
public class ReceitasService {

	@Autowired
	private ReceitasRepository repository;
	
	public List<Receitas> findAll(){
		return repository.findAll(); 
	}

	public Receitas findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
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
	
	public Receitas update(Receitas obj) {
		try {
			Optional<Receitas> newObj = repository.findById(obj.getIdReceita());
			updateData(newObj.orElseThrow(), obj);
			return repository.save(newObj.orElseThrow());
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(obj.getIdReceita());
		}
	}

	private void updateData(Receitas newObj, Receitas obj) {
		newObj.setValor(obj.getValor());
		newObj.setDataRecebimento(obj.getDataRecebimento());
		newObj.setDataRecEsperado(obj.getDataRecEsperado());
		newObj.setDescricao(obj.getDescricao());
		newObj.setTipoReceita(obj.getTipoReceita());
	}
}