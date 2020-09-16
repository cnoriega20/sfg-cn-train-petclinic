package com.springboot.training.petclinic.sfgcntrainpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PetType extends BaseEntity{
    private String name;
}
