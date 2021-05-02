package sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.PetType;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.repositories.PetTypeRepository;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDataJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDataJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
