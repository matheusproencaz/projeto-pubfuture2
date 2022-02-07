package com.mpz.pubfutureproject.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mpz.pubfutureproject.entities.Contas;
import com.mpz.pubfutureproject.repositories.ContasRepository;
import com.mpz.pubfutureproject.services.exceptions.DatabaseException;
import com.mpz.pubfutureproject.services.exceptions.ResourceNotFoundException;

@Service
public class ContasService {

	@Autowired
	private ContasRepository repository;
	
	public List<Contas> findAll(){
		return repository.findAll();
	}

	public Contas findById(Long id) {
		Optional<Contas> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Contas insert(Contas obj) {
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
	
	public Contas update(Long id, Contas obj) {
		try {
			@SuppressWarnings("deprecation")
			Contas entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Contas updateSenha(Long id, Contas obj) {
		try {
			@SuppressWarnings("deprecation")
			Contas entity = repository.getOne(id);
			updateDataSenha(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Contas entity, Contas obj) {
		entity.setNomeUsuario(obj.getNomeUsuario());
		entity.setSaldo(obj.getSaldo());
		entity.setTipoConta(obj.getTipoConta());
		entity.setInstituicaoFin(obj.getInstituicaoFin());
	}
	
	private void updateDataSenha(Contas entity, Contas obj) {
		entity.setNomeUsuario(obj.getSenha());
	}
}