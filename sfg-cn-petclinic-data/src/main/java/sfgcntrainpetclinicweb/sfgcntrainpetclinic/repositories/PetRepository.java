package sfgcntrainpetclinicweb.sfgcntrainpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
