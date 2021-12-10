package org.generation.segurancareal.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_postagem")

public class Postagem {
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private long id;
	
	@NotBlank (message = "Insira Titulo")
	@Size (min=5,max=100)
	private String titulo;
	
	@NotBlank (message = "Insira Texto")
	@Size (min=5,max=2000)
	private String texto;
	
	@NotBlank (message = "Insira Data")
	@Size (min=2,max=20)
	private String data;
	
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties("Postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("Postagem")
	private Usuario usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
