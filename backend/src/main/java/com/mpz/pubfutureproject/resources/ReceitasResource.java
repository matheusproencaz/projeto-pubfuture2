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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mpz.pubfutureproject.entities.Receitas;
import com.mpz.pubfutureproject.services.ReceitasService;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitasResource {

	@Autowired
	private ReceitasService service;
	
	@GetMapping
	public ResponseEntity<List<Receitas>> findAll(){
		List<Receitas> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Receitas> findById(@PathVariable Long id){
		Receitas obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Receitas> insert(@RequestBody Receitas obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdReceita()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Receitas> delete(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Receitas> update(@PathVariable Long id, @RequestBody Receitas obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
