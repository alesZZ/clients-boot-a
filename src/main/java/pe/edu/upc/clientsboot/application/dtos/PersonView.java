package pe.edu.upc.clientsboot.application.dtos;

import lombok.Data;
import lombok.Value;

@Data
public class PersonView {
    private String clientId;
    private String dni;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String createdAt;
}