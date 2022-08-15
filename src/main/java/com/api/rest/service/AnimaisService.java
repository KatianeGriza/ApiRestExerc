package com.api.rest.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.entidades.Animais;
import com.api.rest.repository.AnimaisRepository;

@Service
public class AnimaisService {
	@Autowired
	AnimaisRepository repo;
	
	public Animais salvar(Animais animais) {
		return repo.save(animais);
	}
	public List<Animais> ConsultarAnimais(){
		List<Animais> animais = (List<Animais>) repo.findAll();
		return animais;
	}
	public Animais consultarAnimaisPorId(Long idanimais) {
		Optional<Animais> opanimais = repo.findById(idanimais);
		Animais ct = opanimais.orElseThrow(() -> new EntityNotFoundException("Animal não encontrado"));
		return ct;
	}
	public void excluirAnimais(Long idanimais) {
		Animais ct = consultarAnimaisPorId(idanimais);
		repo.delete(ct);
	}
	public Animais alterarAnimais(Long idanimais, Animais animais) {
		Animais ct = consultarAnimaisPorId(idanimais);
		ct.setEspecie(animais.getEspecie());
		ct.setNome(animais.getNome());
		ct.setHabitat(animais.getHabitat());
		return repo.save(ct);
	}

}
