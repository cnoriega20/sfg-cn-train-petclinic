package sfgcntrainpetclinicweb.sfgcntrainpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
