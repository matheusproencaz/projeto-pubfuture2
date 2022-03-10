package com.mpz.pubfutureproject.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mpz.pubfutureproject.dto.ContasDTO;
import com.mpz.pubfutureproject.dto.SenhaDTO;
import com.mpz.pubfutureproject.entities.Contas;
import com.mpz.pubfutureproject.repositories.ContasRepository;
import com.mpz.pubfutureproject.services.exceptions.DatabaseException;
import com.mpz.pubfutureproject.services.exceptions.ResourceNotFoundException;
import com.mpz.pubfutureproject.services.exceptions.ResourcesAlreadyExistsException;
import com.mpz.pubfutureproject.services.exceptions.WrongPasswordException;

@Service
public class ContasService {

	@Autowired
	private ContasRepository repository;

	@Transactional(readOnly = true)
	public List<ContasDTO> findAll() {
		List<Contas> list = repository.findContasDespesasReceitas();
		return list.stream().map(x -> new ContasDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ContasDTO findById(Long id) {
		Optional<Contas> obj = repository.findById(id);
		return new ContasDTO(obj.orElseThrow(() -> new ResourceNotFoundException(id)));
	}

	@Transactional(readOnly = true)
	public ContasDTO findByNomeUsuario(String nomeUsuario) {
		Contas obj = repository.findByNomeUsuario(nomeUsuario);
		if (obj == null) {
			throw new ResourceNotFoundException(nomeUsuario);
		}
		return new ContasDTO(obj);
	}

	@Transactional
	public Contas insert(Contas obj) {
		try {
			return repository.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new ResourcesAlreadyExistsException();
		}
	}

	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Contas update(Contas obj) {
		try {
			Optional<Contas> newObj = repository.findById(obj.getIdConta());
			updateData(newObj.orElseThrow(), obj);
			return repository.save(newObj.orElseThrow());
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(obj.getIdConta());
		}
	}

	public Contas updateSenha(Long id, SenhaDTO senha) {
		try {
			Optional<Contas> conta = repository.findById(id);
			if (conta.orElseThrow().getSenha().equals(senha.getSenhaAntiga())) {
				conta.orElseThrow().setSenha(senha.getSenhaNova());
				return repository.save(conta.orElseThrow());
			} else {
				throw new WrongPasswordException(""+senha.getSenhaAntiga()+" "+conta.orElseThrow().getSenha());
			}
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Contas newObj, Contas obj) {
		newObj.setNomeUsuario(obj.getNomeUsuario());
		newObj.setSaldo(obj.getSaldo());
		newObj.setTipoConta(obj.getTipoConta());
		newObj.setInstituicaoFin(obj.getInstituicaoFin());
	}

	public Contas fromDTO(ContasDTO objDTO) {
		return new Contas(
				objDTO.getIdConta(), 
				objDTO.getNomeUsuario(), 
				objDTO.getSenha(), 
				objDTO.getSaldo(),
				objDTO.getTipoConta(), 
				objDTO.getInstituicaoFin());
	}
}