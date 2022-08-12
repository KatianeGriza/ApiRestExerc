package com.api.rest.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 80)
	private String nome;
	@Column(length = 80)
	private String especie;
	@Column(length = 50)
	private String habitat;

	public Animais(String nome, String especie, String habitat) {
		this.nome = nome;
		this.especie = especie;
		this.habitat = habitat;
	}

	public Animais() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

}
