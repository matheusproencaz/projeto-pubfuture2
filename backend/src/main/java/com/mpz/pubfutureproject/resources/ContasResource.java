package com.mpz.pubfutureproject.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mpz.pubfutureproject.dto.ContasDTO;
import com.mpz.pubfutureproject.dto.SenhaDTO;
import com.mpz.pubfutureproject.entities.Contas;
import com.mpz.pubfutureproject.services.ContasService;

@RestController
public class ContasResource {

	@Autowired
	private ContasService service;
	
	@GetMapping(value = "/contas")
	public ResponseEntity<List<ContasDTO>> findAll(){
		List<ContasDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/conta/{nomeUsuario}")
	public ResponseEntity<ContasDTO> findByNomeUsuario(@PathVariable String nomeUsuario){
		ContasDTO obj = service.findByNomeUsuario(nomeUsuario); 
		return ResponseEntity.ok().body(obj); 
	}
	
	@GetMapping(value = "/contas/{id}")
	public ResponseEntity<ContasDTO> findById(@PathVariable Long id){
		ContasDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value = "/contas")
	public ResponseEntity<Void> insert(@RequestBody ContasDTO objDTO){
		Contas obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConta()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/contas/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/contas/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ContasDTO objDTO){
		Contas obj = service.fromDTO(objDTO);
		obj.setIdConta(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	// Fazer método para verificar se a senha antiga é igual(talvez fazer isso no frontend) e fazer verificação da senha antiga.
	@PutMapping(value="/contas/senha/{id}")
	public ResponseEntity<Void> updateSenha(@PathVariable Long id, @RequestBody SenhaDTO senha){
		service.updateSenha(id, senha);
		return ResponseEntity.ok().build();
	}
}
