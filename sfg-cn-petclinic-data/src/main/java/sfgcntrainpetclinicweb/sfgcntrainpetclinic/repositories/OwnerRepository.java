package sfgcntrainpetclinicweb.sfgcntrainpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Owner findByLastName(String lastName);
}
