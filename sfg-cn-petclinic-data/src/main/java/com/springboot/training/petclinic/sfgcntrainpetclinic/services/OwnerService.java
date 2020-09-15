package com.springboot.training.petclinic.sfgcntrainpetclinic.services;

import com.springboot.training.petclinic.sfgcntrainpetclinic.model.Owner;

public interface OwnerService extends PetClinicService<Owner, Long> {

    Owner findByLastName(String lastName);

}
