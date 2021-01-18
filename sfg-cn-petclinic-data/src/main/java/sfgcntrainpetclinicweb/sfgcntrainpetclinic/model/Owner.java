package sfgcntrainpetclinicweb.sfgcntrainpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Owner extends Person {
    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pets;
}
