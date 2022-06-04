package pe.edu.upc.clientsboot.domain.entities;

import lombok.Data;
import org.axonframework.modelling.command.AggregateIdentifier;
import pe.edu.upc.clientsboot.domain.enums.ClientState;
import pe.edu.upc.clientsboot.domain.values.*;

import javax.persistence.*;

@Entity(name = "Client")
@Table(name = "clients")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    discriminatorType = DiscriminatorType.INTEGER,
    name = "client_type_id",
    columnDefinition = "TINYINT(1)"
)
public class Client {
    @AggregateIdentifier
    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BINARY(16)"))
    })
    private ClientId id;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "value", column = @Column(name = "address", length = 150, nullable = false))
    })
    private Address address;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "value", column = @Column(name = "email", length = 150, nullable = false))
    })
    private Email email;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "value", column = @Column(name = "phone", length = 50, nullable = false))
    })
    private Phone phone;

    @Column(name = "client_state_id", columnDefinition = "TINYINT(1) UNSIGNED", nullable = false)
    private ClientState state;

    @Embedded
    private AuditTrail auditTrail;

    public Client(ClientId clientId, Address address, Email email, Phone phone, ClientState state, AuditTrail auditTrail) {
        setId(clientId);
        setAddress(address);
        setEmail(email);
        setPhone(phone);
        setState(state);
        setAuditTrail(auditTrail);
    }

    protected Client() {
    }
}
