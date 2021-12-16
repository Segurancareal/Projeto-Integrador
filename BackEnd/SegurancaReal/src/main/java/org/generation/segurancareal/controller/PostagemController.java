package org.generation.segurancareal.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.segurancareal.model.Postagem;

import org.generation.segurancareal.repository.PostagemRepository;

import org.springframework.beans.factory.annotation.Autowired;

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

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*") 
public class PostagemController { 
	
	@Autowired
    private PostagemRepository repository;

<<<<<<< HEAD:Task3-Projeto-Integrador/SegurancaReal/src/main/java/org/generation/segurancareal/controller/PostagemController.java
=======
    // retornar todas as postagens
>>>>>>> 585ca2f0f3cfe00d8794006f64d16737b9a749ed:BackEnd/SegurancaReal/src/main/java/org/generation/segurancareal/controller/PostagemController.java
    @GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
<<<<<<< HEAD:Task3-Projeto-Integrador/SegurancaReal/src/main/java/org/generation/segurancareal/controller/PostagemController.java
=======
    // procurar uma postagem pelo id
>>>>>>> 585ca2f0f3cfe00d8794006f64d16737b9a749ed:BackEnd/SegurancaReal/src/main/java/org/generation/segurancareal/controller/PostagemController.java
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

<<<<<<< HEAD:Task3-Projeto-Integrador/SegurancaReal/src/main/java/org/generation/segurancareal/controller/PostagemController.java
=======
	// procurar uma postagem pelo texto
>>>>>>> 585ca2f0f3cfe00d8794006f64d16737b9a749ed:BackEnd/SegurancaReal/src/main/java/org/generation/segurancareal/controller/PostagemController.java
	@GetMapping("/texto/{texto}")
	public ResponseEntity<List<Postagem>> getByTexto(@PathVariable String texto){
		return ResponseEntity.ok(repository.findAllByTextoContainingIgnoreCase(texto));
	}
	
<<<<<<< HEAD:Task3-Projeto-Integrador/SegurancaReal/src/main/java/org/generation/segurancareal/controller/PostagemController.java
=======
	// procurar uma postagem pelo titulo
>>>>>>> 585ca2f0f3cfe00d8794006f64d16737b9a749ed:BackEnd/SegurancaReal/src/main/java/org/generation/segurancareal/controller/PostagemController.java
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
<<<<<<< HEAD:Task3-Projeto-Integrador/SegurancaReal/src/main/java/org/generation/segurancareal/controller/PostagemController.java
=======
	// procurar uma postagem pela data
>>>>>>> 585ca2f0f3cfe00d8794006f64d16737b9a749ed:BackEnd/SegurancaReal/src/main/java/org/generation/segurancareal/controller/PostagemController.java
	@GetMapping("/data/{data}")
		public ResponseEntity<List<Postagem>> getByData(@PathVariable String data){
			return ResponseEntity.ok(repository.findAllByDataContainingIgnoreCase(data));
	}
		
	//Procurar uma postagem pela foto
	@GetMapping("/foto/{foto}")
		public ResponseEntity<List<Postagem>> getByFoto(@PathVariable String foto){
			return ResponseEntity.ok(repository.findAllByFotoContainingIgnoreCase(foto));
	}
	
<<<<<<< HEAD:Task3-Projeto-Integrador/SegurancaReal/src/main/java/org/generation/segurancareal/controller/PostagemController.java
=======
    // inserir um novo dado 
>>>>>>> 585ca2f0f3cfe00d8794006f64d16737b9a749ed:BackEnd/SegurancaReal/src/main/java/org/generation/segurancareal/controller/PostagemController.java
	@PostMapping
	public ResponseEntity<Postagem> post (@Valid @RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(postagem));
	}

	@PutMapping
	public ResponseEntity<Postagem> putPostagem(@Valid @RequestBody Postagem postagem) {
					
		return repository.findById(postagem.getId())
				.map(resposta -> {
					return ResponseEntity.ok().body(repository.save(postagem));
				})
				.orElse(ResponseEntity.notFound().build());

	}
    
    // deletar um dado pelo id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostagem(@PathVariable long id) {
		
		return repository.findById(id)
				.map(resposta -> {
					repository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
<<<<<<< HEAD:Task3-Projeto-Integrador/SegurancaReal/src/main/java/org/generation/segurancareal/controller/PostagemController.java
}
 
=======

}
>>>>>>> 585ca2f0f3cfe00d8794006f64d16737b9a749ed:BackEnd/SegurancaReal/src/main/java/org/generation/segurancareal/controller/PostagemController.java
