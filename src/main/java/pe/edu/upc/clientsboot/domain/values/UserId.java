package pe.edu.upc.clientsboot.domain.values;

import lombok.Value;

import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
@Value(staticConstructor = "of")
public class UserId {
    private UUID value;

    private UserId(UUID value) {
        this.value = value;
    }

    protected UserId() {
        this.value = UUID.randomUUID();
    }
}
