package sfgcntrainpetclinicweb.sfgcntrainpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visit extends BaseEntity{

    private LocalDate date;
    private String description;
    private Pet pet;
}
