package sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Vet;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.repositories.VetRepository;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDataJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDataJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vetToSave) {
        return vetRepository.save(vetToSave);
    }

    @Override
    public void delete(Vet vetToDelete) {
        vetRepository.delete(vetToDelete);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
