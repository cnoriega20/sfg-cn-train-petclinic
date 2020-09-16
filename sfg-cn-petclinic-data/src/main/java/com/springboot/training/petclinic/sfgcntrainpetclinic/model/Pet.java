package com.springboot.training.petclinic.sfgcntrainpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pet extends BaseEntity{
    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;
}
