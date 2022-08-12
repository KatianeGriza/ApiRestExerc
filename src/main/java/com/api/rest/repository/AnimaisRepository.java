package com.api.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.entidades.Animais;

@Repository
public interface AnimaisRepository extends CrudRepository<Animais, Long> {

}
