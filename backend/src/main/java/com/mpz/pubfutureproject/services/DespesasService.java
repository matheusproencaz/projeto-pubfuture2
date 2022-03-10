package com.mpz.pubfutureproject.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mpz.pubfutureproject.entities.Despesas;
import com.mpz.pubfutureproject.repositories.DespesasRepository;
import com.mpz.pubfutureproject.services.exceptions.DatabaseException;
import com.mpz.pubfutureproject.services.exceptions.ResourceNotFoundException;

@Service
public class DespesasService {

	@Autowired
	private DespesasRepository repository;
	
//	@Autowired
//	private ContasRepository contasRepository;
	
	public List<Despesas> findAll(){
		return repository.findAll();
	}

	public Despesas findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
//	public List<Despesas> findByConta(Long id){
//		Optional<Contas> conta = contasRepository.findById(id);
//		if(conta == null) {
//			throw new ResourceNotFoundException(id);
//		}
//		List<Despesas> list = repository.findByConta(conta);
//		return list;
//	}
	
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
	
	public Despesas update(Despesas obj) {
		try {
			Optional<Despesas> newObj = repository.findById(obj.getIdDespesas());
			updateData(newObj.orElseThrow(), obj);
			return repository.save(newObj.orElseThrow());
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(obj.getIdDespesas());
		}
	}

	private void updateData(Despesas entity, Despesas obj) {
		entity.setValor(obj.getValor());
		entity.setDataPagamento(obj.getDataPagamento());
		entity.setDataPagEsperado(obj.getDataPagEsperado());
		entity.setTipoDespesa(obj.getTipoDespesa());
	}
}














