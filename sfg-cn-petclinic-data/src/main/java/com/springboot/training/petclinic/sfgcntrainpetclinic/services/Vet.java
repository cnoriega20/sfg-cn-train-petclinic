package com.springboot.training.petclinic.sfgcntrainpetclinic.services;

import java.util.Set;

public interface Vet {
    Vet findByLastName(String lastName);
    Vet findById(Long id);
    Vet save(Vet pet);
    Set<Vet> findAll();
}
