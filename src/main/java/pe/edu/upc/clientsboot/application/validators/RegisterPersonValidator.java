package pe.edu.upc.clientsboot.application.validators;

import org.springframework.stereotype.Component;
import pe.edu.upc.clientsboot.application.dtos.RegisterPersonRequest;
import pe.edu.upc.clientsboot.application.notification.Notification;
import pe.edu.upc.clientsboot.domain.entities.Person;
import pe.edu.upc.clientsboot.infrastructure.repositories.PersonRepository;

import java.util.Optional;

@Component
public class RegisterPersonValidator {
    private final PersonRepository personRepository;

    public RegisterPersonValidator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Notification validate(RegisterPersonRequest registerPersonRequest)
    {
        Notification notification = new Notification();
        String dni = registerPersonRequest.getDni() != null ? registerPersonRequest.getDni().trim() : "";
        if (dni.isEmpty()) {
            notification.addError("Client dni is required");
        }
        String firstName = registerPersonRequest.getFirstName() != null ? registerPersonRequest.getFirstName().trim() : "";
        if (firstName.isEmpty()) {
            notification.addError("Client firstname is required");
        }
        String lastName = registerPersonRequest.getLastName() != null ? registerPersonRequest.getLastName().trim() : "";
        if (lastName.isEmpty()) {
            notification.addError("Client lastname is required");
        }
        String address = registerPersonRequest.getAddress() != null ? registerPersonRequest.getAddress().trim() : "";
        if (address.isEmpty()) {
            notification.addError("Client address is required");
        }
        String email = registerPersonRequest.getEmail() != null ? registerPersonRequest.getEmail().trim() : "";
        if (email.isEmpty()) {
            notification.addError("Client email is required");
        }
        String phone = registerPersonRequest.getPhone() != null ? registerPersonRequest.getPhone().trim() : "";
        if (phone.isEmpty()) {
            notification.addError("Client phone is required");
        }
        if (notification.hasErrors()) {
            return notification;
        }
        Optional<Person> personOptional = personRepository.findByDniValue(dni);
        if (personOptional.isPresent()) {
            notification.addError("Client dni is taken");
        }
        return notification;
    }
}
