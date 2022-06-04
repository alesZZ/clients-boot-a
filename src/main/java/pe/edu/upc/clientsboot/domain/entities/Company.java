package pe.edu.upc.clientsboot.domain.entities;

import lombok.Data;
import pe.edu.upc.clientsboot.domain.values.CompanyName;
import pe.edu.upc.clientsboot.domain.values.Ruc;

import javax.persistence.*;

@Entity
@Data
@DiscriminatorValue(value="2")
public class Company extends Client {
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "value", column = @Column(name = "ruc", length = 11))
    })
    private Ruc ruc;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "value", column = @Column(name = "company_name", length = 150))
    })
    private CompanyName companyName;
}