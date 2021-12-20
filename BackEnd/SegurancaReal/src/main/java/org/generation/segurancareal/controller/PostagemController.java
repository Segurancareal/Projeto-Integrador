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

@RestController //informa p/ o Spring q a classe é um controlador
@RequestMapping("/postagens") // URI pela qual a classe será acessada
@CrossOrigin(origins = "*", allowedHeaders = "*") // a classe vai aceitar requisições de qlqr origem
public class PostagemController { 
	
	@Autowired // garante que os serviços da interface seja acessado a patir do controller
    private PostagemRepository repository;

    // retornar todas as postagens
    @GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
    // procurar uma postagem pelo id
    @GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}


	// procurar uma postagem pelo texto
    @GetMapping("/texto/{texto}")
	public ResponseEntity<List<Postagem>> getByTexto(@PathVariable String texto){
		return ResponseEntity.ok(repository.findAllByTextoContainingIgnoreCase(texto));
	}
	

	// procurar uma postagem pelo titulo
    @GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

    // inserir um novo dado 
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
}
