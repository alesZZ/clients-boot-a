package pe.edu.upc.clientsboot.domain.entities;

import lombok.Data;
import pe.edu.upc.clientsboot.domain.enums.ClientState;
import pe.edu.upc.clientsboot.domain.values.*;

import javax.persistence.*;

@Entity
@Data
@DiscriminatorValue(value="1")
public class Person extends Client {
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "value", column = @Column(name = "dni", length = 8))
    })
    private Dni dni;

    @Embedded
    private FullName fullName;

    public Person(ClientId clientId, Address address, Email email, Phone phone, ClientState state, AuditTrail auditTrail, Dni dni, FullName fullName) {
        super(clientId, address, email, phone, state, auditTrail);
        setDni(dni);
        setFullName(fullName);
    }

    protected Person() {
    }
}
