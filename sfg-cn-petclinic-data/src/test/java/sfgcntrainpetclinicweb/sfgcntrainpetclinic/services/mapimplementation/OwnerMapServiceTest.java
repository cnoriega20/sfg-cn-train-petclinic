package sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.mapimplementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
    OwnerMapService ownerMapService;

    final Long ownerId = 1L;
    final String lastName= "Noriega";

    @BeforeEach
    void setUp(){
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());

    }

    @Test
    void testFindAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void testFindById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(1L, ownerId);
    }

    @Test
    void testSaveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        ownerMapService.save(owner2);
        assertEquals(owner2,ownerMapService.findById(id));
    }

    @Test
    void testSaveNotNull() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner savedByName = ownerMapService.findByLastName(lastName);
        assertNotEquals("Smith", savedByName.getLastName());
    }
}