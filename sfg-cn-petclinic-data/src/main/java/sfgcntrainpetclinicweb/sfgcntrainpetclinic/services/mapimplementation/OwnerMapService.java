package sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.mapimplementation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Owner;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Pet;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.OwnerService;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.PetService;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.PetTypeService;

import java.util.Set;

@Service
@Profile({"default", "mapServices"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }


    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if(object != null) {
            if(object.getPets() != null) {
                object.getPets().forEach(
                        pet -> {
                            if(pet.getPetType() != null) {
                                if(pet.getPetType().getId() != null){
                                    pet.setPetType(petTypeService.save(pet.getPetType()));
                                }
                            } else {
                                throw new RuntimeException("PetType is required");
                            }
                            if(pet.getId() == null) {
                                Pet savedPet = petService.save(pet);
                                pet.setId(savedPet.getId());
                            }
                        });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }


    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }


    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner ->
                        owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
        //return null;
    }
}
