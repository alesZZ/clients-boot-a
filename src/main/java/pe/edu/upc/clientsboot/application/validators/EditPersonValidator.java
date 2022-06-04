package pe.edu.upc.clientsboot.application.validators;

import org.springframework.stereotype.Component;
import pe.edu.upc.clientsboot.application.dtos.EditPersonRequest;
import pe.edu.upc.clientsboot.application.notification.Notification;
import pe.edu.upc.clientsboot.domain.entities.Client;
import pe.edu.upc.clientsboot.domain.entities.Person;
import pe.edu.upc.clientsboot.infrastructure.repositories.PersonRepository;

import java.util.Optional;
import java.util.UUID;

@Component
public class EditPersonValidator {
    private final PersonRepository personRepository;

    public EditPersonValidator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Notification validate(EditPersonRequest editPersonRequest)
    {
        Notification notification = new Notification();
        String clientId = editPersonRequest.getId().trim();
        if (clientId.isEmpty()) {
            notification.addError("Client id is required");
        }
        Optional<Person> personOptional = personRepository.findById(UUID.fromString(clientId));
        if (personOptional.isPresent()) {
            notification.addError("Client not found");
            return notification;
        }
        String firstName = editPersonRequest.getFirstName().trim();
        if (firstName.isEmpty()) {
            notification.addError("Client firstname is required");
        }
        String lastName = editPersonRequest.getLastName().trim();
        if (lastName.isEmpty()) {
            notification.addError("Client lastname is required");
        }
        String dni = editPersonRequest.getDni().trim();
        if (dni.isEmpty()) {
            notification.addError("Client dni is required");
        }
        if (notification.hasErrors()) {
            return notification;
        }
        personOptional = personRepository.findByDniValue(dni);
        if (personOptional.isPresent()) {
            notification.addError("Client dni is taken");
        }
        return notification;
    }
}
