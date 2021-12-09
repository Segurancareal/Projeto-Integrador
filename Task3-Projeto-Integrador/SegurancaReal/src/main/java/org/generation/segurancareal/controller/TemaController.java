package org.generation.segurancareal.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.segurancareal.model.Tema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {
	
	private TemaRepository repository;
	
	//Get mapping ALL
	@GetMapping
	public ResponseEntity<List<Tema>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//Get mapping para encontrar a ID do tema
	@GetMapping 
	public ResponseEntity<List<Tema>> getById(@Valid @PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Get mapping para encontrar a Descricao do tema
	@GetMapping
	public ResponseEntity<List<Tema>> getByDescricao(@Valid @PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Tema>> getByHashtag(@Valid @PathVariable String hashtag){
		return ResponseEntity.ok(repository.findAllByHashtagContainingIgnoreCase(hashtag));
	}
	
	@GetMapping
	public ResponseEntity<List<Tema>> getByAssunto(@Valid @PathVariable String assunto) {
		return ResponseEntity.ok(repository.findAllByAssuntoContainingIgnoreCase(assunto));
	}
	
	@PostMapping
	public ResponseEntity<Tema> post (@Valid @RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(tema));
		
	}
	
	@PutMapping
	public ResponseEntity<Tema> put (@Valid @RequestBody Tema tema ){
		return ResponseEntity.ok(repository.save(tema));
		
	}
	@DeleteMapping("/{id}")
	public void delete(@Valid @PathVariable long id) {
		repository.deleteById(id);
	}
	
	

}
