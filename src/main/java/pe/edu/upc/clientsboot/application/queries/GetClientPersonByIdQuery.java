package pe.edu.upc.clientsboot.application.queries;

import lombok.Data;

@Data
public class GetClientPersonByIdQuery {
    private String clientId;

    public GetClientPersonByIdQuery(String clientId) {
        this.clientId = clientId;
    }
}
