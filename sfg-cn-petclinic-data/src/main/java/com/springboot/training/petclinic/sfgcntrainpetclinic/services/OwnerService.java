package com.springboot.training.petclinic.sfgcntrainpetclinic.services;

import com.springboot.training.petclinic.sfgcntrainpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();

}
