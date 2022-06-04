package pe.edu.upc.clientsboot.application.commands;

import lombok.Value;

@Value
public class EditPerson {
    private String id;
    private String dni;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
}
