package com.springboot.training.petclinic.sfgcntrainpetclinic.services.mapS;

import com.springboot.training.petclinic.sfgcntrainpetclinic.model.Vet;
import com.springboot.training.petclinic.sfgcntrainpetclinic.services.PetClinicService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements PetClinicService<Vet, Long> {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }


    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }


}
