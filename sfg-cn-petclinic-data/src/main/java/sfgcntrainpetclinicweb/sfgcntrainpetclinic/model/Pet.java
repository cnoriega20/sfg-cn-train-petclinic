package sfgcntrainpetclinicweb.sfgcntrainpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pet extends BaseEntity{
    private String name;
    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;
}
