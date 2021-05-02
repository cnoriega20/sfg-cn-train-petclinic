package sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Speciality;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.repositories.SpecialityRepository;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.SpecialityService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDataJpaService implements SpecialityService {
    private final SpecialityRepository specialityRepository;

    public SpecialitySDataJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }


    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality specialityToSave) {
        return specialityRepository.save(specialityToSave);
    }

    @Override
    public void delete(Speciality specialityToDelete) {
        specialityRepository.delete(specialityToDelete);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
