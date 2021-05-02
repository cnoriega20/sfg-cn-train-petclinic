package sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Pet;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.repositories.PetRepository;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.PetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDataJpaService implements PetService {

    private final PetRepository petRepository;

    public PetSDataJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet petToSave) {
        return petRepository.save(petToSave);
    }

    @Override
    public void delete(Pet petToDelete) {
        petRepository.delete(petToDelete);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
