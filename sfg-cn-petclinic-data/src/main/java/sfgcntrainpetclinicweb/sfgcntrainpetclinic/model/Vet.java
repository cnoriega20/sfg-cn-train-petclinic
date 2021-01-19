package sfgcntrainpetclinicweb.sfgcntrainpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vet extends Person {
    private Set<Specialty> specialties = new HashSet<>();
}
