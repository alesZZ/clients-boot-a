package pe.edu.upc.clientsboot.application.dtos;

import lombok.Data;

@Data
public class EditPersonRequest {
    private String id;
    private String dni;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
}