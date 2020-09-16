package com.springboot.training.petclinic.sfgcntrainpetclinic.services.mapS;

import com.springboot.training.petclinic.sfgcntrainpetclinic.model.Owner;
import com.springboot.training.petclinic.sfgcntrainpetclinic.services.PetClinicService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements PetClinicService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }


    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }


    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }



}
