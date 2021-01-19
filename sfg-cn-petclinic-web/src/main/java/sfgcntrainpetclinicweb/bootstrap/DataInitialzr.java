package sfgcntrainpetclinicweb.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Owner;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Pet;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.PetType;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Vet;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.OwnerService;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.PetService;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.PetTypeService;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.VetService;

import java.time.LocalDate;

@Slf4j
@Component
public class DataInitialzr implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    private final PetService petService;

    private final PetTypeService petTypeService;

    public DataInitialzr(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }
    @Override
    public void run(String... args) throws Exception {
        //Stub data for Owner, Vet and Pet and PetType

        PetType petType1 = new PetType();
        petType1.setName("Dog");
        PetType savedDogPetType = petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType2.setName("Cat");
        PetType savedCatPetType = petTypeService.save(petType2);

        log.info("Loaded Pet Types...");

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Joe");
        owner1.setLastName("Doe");
        owner1.setAddress("134 Elm Street");
        owner1.setCity("Burbank");
        owner1.setTelephone("(971) 172-3098");

        Pet cesarsPet = new Pet();
        cesarsPet.setPetType(petType1);
        cesarsPet.setOwner(owner1);
        cesarsPet.setBirthDate(LocalDate.now());
        cesarsPet.setName("Toby");
        owner1.getPets().add(cesarsPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Claudia");
        owner2.setLastName("Lynwood");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("(971) 172-3094");

        Pet courtneysPet = new Pet();
        courtneysPet.setName("Sammy");
        courtneysPet.setOwner(owner2);
        courtneysPet.setBirthDate(LocalDate.now());
        courtneysPet.setPetType(savedCatPetType);
        owner2.getPets().add(courtneysPet);
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
