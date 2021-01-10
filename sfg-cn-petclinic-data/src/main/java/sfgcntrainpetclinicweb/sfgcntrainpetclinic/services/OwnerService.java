package sfgcntrainpetclinicweb.sfgcntrainpetclinic.services;

import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Owner;

public interface OwnerService extends PetClinicService<Owner, Long> {

    Owner findByLastName(String lastName);

}
