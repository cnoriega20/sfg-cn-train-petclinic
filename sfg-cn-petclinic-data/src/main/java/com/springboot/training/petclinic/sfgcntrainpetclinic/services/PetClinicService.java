package com.springboot.training.petclinic.sfgcntrainpetclinic.services;

import java.util.Set;

public interface PetClinicService <T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);
    
    void deleteById(ID id);

}
