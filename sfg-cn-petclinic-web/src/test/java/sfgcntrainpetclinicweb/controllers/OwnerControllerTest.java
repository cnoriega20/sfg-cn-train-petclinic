package sfgcntrainpetclinicweb.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.model.Owner;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners;
    MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        owners = new HashSet<>();
        Owner o1 = Owner.builder().id(1L).build();
        Owner o2 = Owner.builder().id(2L).build();
        Owner o3 = Owner.builder().id(3L).build();
        owners.add(o1);
        owners.add(o2);
        owners.add(o3);
        System.out.println("Size: " + owners.size());

        mockMvc = MockMvcBuilders
                    .standaloneSetup(ownerController)
                    .build();
    }
    @Test
    void testListOwners() throws Exception{
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"));
                //.andExpect(model().attribute("owners",hasSize(3)));
    }

    @Test
    void testListOwnerByIndex() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"));
    }

    @Test
    void testListOwnerNotImplemented() throws Exception {

        mockMvc.perform(get("/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"));
        verifyNoInteractions(ownerService);
    }

}