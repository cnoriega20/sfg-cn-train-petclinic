package sfgcntrainpetclinicweb.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.*;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.*;

import java.time.LocalDate;

@Slf4j
@Component
public class DataInitialzr implements CommandLineRunner {

    private final OwnerService ownerService;

    private final VetService vetService;

    private final PetService petService;

    private final PetTypeService petTypeService;

    private final SpecialtyService specialtyService;

    public DataInitialzr(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }
    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        //Stub data for Owner, Vet and Pet and PetType

        PetType petType1 = new PetType();
        petType1.setName("Dog");
        PetType savedDogPetType = petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType2.setName("Cat");
        PetType savedCatPetType = petTypeService.save(petType2);

        log.info("Loaded Pet Types...");

        Specialty specialty1 = new Specialty();
        specialty1.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(specialty1);

        Specialty specialty2 = new Specialty();
        specialty2.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(specialty2);

        Specialty specialty3 = new Specialty();
        specialty3.setDescription("dentistry");
        Specialty savedDentistry = specialtyService.save(specialty3);

        log.info("Loaded Specialties...");

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
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Zoe");
        vet2.setLastName("Oakland");
        vet1.getSpecialties().add(savedDentistry);
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
