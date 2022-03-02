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

import com.mpz.pubfutureproject.entities.Contas;
import com.mpz.pubfutureproject.services.ContasService;

@RestController
public class ContasResource {

	@Autowired
	private ContasService service;
	
	@GetMapping(value = "/contas")
	public ResponseEntity<List<Contas>> findAll(){
		List<Contas> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/conta/{nomeUsuario}")
	public ResponseEntity<Contas> findByNomeUsuario(@PathVariable String nomeUsuario){
		Contas obj = service.findByNomeUsuario(nomeUsuario); 
		return ResponseEntity.ok().body(obj); 
	}
	
	@GetMapping(value = "/contas/{id}")
	public ResponseEntity<Contas> findById(@PathVariable Long id){
		Contas obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value = "/contas")
	public ResponseEntity<Contas> insert(@RequestBody Contas obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConta()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/contas/{id}")
	public ResponseEntity<Contas> delete(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/contas/{id}")
	public ResponseEntity<Contas> update(@PathVariable Long id, @RequestBody Contas obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
