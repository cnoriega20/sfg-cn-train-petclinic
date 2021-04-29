package sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.mapimplementation;

import org.springframework.stereotype.Service;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Speciality;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Vet;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.SpecialtyService;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

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
        if(object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(specialty -> {
                if(specialty.getId() == null) {
                    Speciality savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
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
