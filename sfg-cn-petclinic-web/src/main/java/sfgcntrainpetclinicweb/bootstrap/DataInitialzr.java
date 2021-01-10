package sfgcntrainpetclinicweb.bootstrap;

import com.springboot.training.petclinic.sfgcntrainpetclinic.model.Owner;
import com.springboot.training.petclinic.sfgcntrainpetclinic.model.Pet;
import com.springboot.training.petclinic.sfgcntrainpetclinic.model.Vet;
import com.springboot.training.petclinic.sfgcntrainpetclinic.services.OwnerService;
import com.springboot.training.petclinic.sfgcntrainpetclinic.services.PetService;
import com.springboot.training.petclinic.sfgcntrainpetclinic.services.VetService;
import com.springboot.training.petclinic.sfgcntrainpetclinic.services.mapimplementation.OwnerServiceMap;
import com.springboot.training.petclinic.sfgcntrainpetclinic.services.mapimplementation.PetServiceMap;
import com.springboot.training.petclinic.sfgcntrainpetclinic.services.mapimplementation.VetServiceMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class DataInitialzr implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    private final PetService petService;

    public DataInitialzr(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
        petService = new PetServiceMap();
    }

    /*public DataInitialzr(OwnerService ownerService, VetService vetService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
    }*/


    @Override
    public void run(String... args) throws Exception {
        //Stub data for Owner, Vet and Pet

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Joe");
        owner1.setLastName("Doe");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner1.setFirstName("Claudia");
        owner2.setLastName("Lynwood");

        ownerService.save(owner2);

        log.info("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Ferguson");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Zoe");
        vet2.setLastName("Oakland");

        vetService.save(vet2);

        log.info("Loaded Vets...");

        Pet pet1 = new Pet();
        pet1.setId(1L);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.of(2016, 1, 8));

        petService.save(pet1);

        Pet pet2 = new Pet();
        pet1.setId(2L);
        pet1.setOwner(owner2);
        pet1.setBirthDate(LocalDate.ofYearDay(2020, 7));

        petService.save(pet2);

        log.info("Loaded Pets...");

    }
}
