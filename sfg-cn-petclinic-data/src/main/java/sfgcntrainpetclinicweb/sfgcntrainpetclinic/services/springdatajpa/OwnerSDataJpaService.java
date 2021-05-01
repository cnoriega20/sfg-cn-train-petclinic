package sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Owner;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.repositories.OwnerRepository;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDataJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDataJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner ownerToSave) {
        return ownerRepository.save(ownerToSave);
    }

    @Override
    public void delete(Owner ownerToDelete) {
        ownerRepository.delete(ownerToDelete);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
