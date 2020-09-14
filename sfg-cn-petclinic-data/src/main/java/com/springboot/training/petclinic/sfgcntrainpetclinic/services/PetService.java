package com.springboot.training.petclinic.sfgcntrainpetclinic.services;

import com.springboot.training.petclinic.sfgcntrainpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByLastName(String lastName);
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();

}
