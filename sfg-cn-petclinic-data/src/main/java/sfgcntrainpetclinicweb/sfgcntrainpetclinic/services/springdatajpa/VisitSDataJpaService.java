package sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Visit;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.repositories.VisitRepository;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDataJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDataJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit visitToSave) {
        return visitRepository.save(visitToSave);
    }

    @Override
    public void delete(Visit visitObjToDelete) {
        visitRepository.delete(visitObjToDelete);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
