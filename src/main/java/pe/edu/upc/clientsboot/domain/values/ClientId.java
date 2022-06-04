package pe.edu.upc.clientsboot.domain.values;

import lombok.Value;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Value(staticConstructor = "of")
public class ClientId implements Serializable {
    private UUID value;

    private ClientId(UUID value) {
        this.value = value;
    }

    protected ClientId() {
        this.value = UUID.randomUUID();
    }
}