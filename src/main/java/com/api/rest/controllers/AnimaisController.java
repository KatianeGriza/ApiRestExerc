package com.api.rest.controllers;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.repository.AnimaisRepository;
import com.api.rest.entidades.Animais;

@RestController
@RequestMapping("/")
public class AnimaisController {

	@Autowired
	AnimaisRepository repo;

	@GetMapping
	public String xpto() {
		return "Index de Animais";
	}

	@GetMapping("/animais")
	public ResponseEntity<List<Animais>> getAnimais() {
		List<Animais> animais = (List<Animais>) repo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(animais);
	}

	@GetMapping("/animais/{idanimais}")
	public ResponseEntity<Animais> getAnimaisById(@PathVariable("idanimais") Long idanimais) {
		Optional<Animais> animais = repo.findById(idanimais);
		return animais.isPresent() ? ResponseEntity.ok(animais.get()) : ResponseEntity.notFound().build();
	}
	@PostMapping("/animais")
	public ResponseEntity<Animais> saveAnimais(@RequestBody Animais animais) {
		Animais ct = repo.save(animais);
		return ResponseEntity.status(HttpStatus.CREATED).body(ct);
	}

	@DeleteMapping("/animais/{idanimais}")
	public ResponseEntity<Void> deleteAnimais(@PathVariable("idanimais") Long idanimais) {
		repo.deleteById(idanimais);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/animais/{idanimais}")
	public ResponseEntity<Animais> alteraAnimais(@PathVariable("idanimais") int idanimais,
			@RequestBody Animais animais) {
		return ResponseEntity.ok(repo.save(animais));
	}

}
