package pe.edu.upc.clientsboot.application.handlers.commands;

import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;
import pe.edu.upc.clientsboot.application.commands.RegisterPerson;
import pe.edu.upc.clientsboot.application.notification.Notification;
import pe.edu.upc.clientsboot.application.notification.Result;
import pe.edu.upc.clientsboot.domain.entities.Person;
import pe.edu.upc.clientsboot.domain.enums.ClientState;
import pe.edu.upc.clientsboot.domain.values.*;
import pe.edu.upc.clientsboot.infrastructure.repositories.PersonRepository;

import java.util.UUID;

@Component
public class RegisterPersonHandler {
    private PersonRepository personRepository;

    public RegisterPersonHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @CommandHandler
    public Result<Person, Notification> handle(RegisterPerson registerPerson) {
        Notification notification = new Notification();
        ClientId clientId = ClientId.of(UUID.fromString(registerPerson.getId()));
        Result<Address, Notification> addressResult = Address.create(registerPerson.getAddress());
        if (addressResult.isFailure()) {
            notification.addError(addressResult.getFailure().errorMessage());
        }
        Result<Email, Notification> emailResult = Email.create(registerPerson.getEmail());
        if (emailResult.isFailure()) {
            notification.addError(addressResult.getFailure().errorMessage());
        }
        Result<Phone, Notification> phoneResult = Phone.create(registerPerson.getPhone());
        if (phoneResult.isFailure()) {
            notification.addError(phoneResult.getFailure().errorMessage());
        }
        Result<AuditTrail, Notification> auditTrailResult = AuditTrail.create(UUID.randomUUID());
        if (auditTrailResult.isFailure()) {
            notification.addError(auditTrailResult.getFailure().errorMessage());
        }
        Result<Dni, Notification> dniResult = Dni.create(registerPerson.getDni());
        if (dniResult.isFailure()) {
            notification.addError(dniResult.getFailure().errorMessage());
        }
        Result<FullName, Notification> fullNameResult = FullName.create(registerPerson.getFirstName(), registerPerson.getLastName());
        if (fullNameResult.isFailure()) {
            notification.addError(fullNameResult.getFailure().errorMessage());
        }
        if (notification.hasErrors()) {
            return Result.failure(notification);
        }
        Person person = new Person(
            clientId,
            addressResult.getSuccess(),
            emailResult.getSuccess(),
            phoneResult.getSuccess(),
            ClientState.ACTIVE,
            auditTrailResult.getSuccess(),
            dniResult.getSuccess(),
            fullNameResult.getSuccess());
        personRepository.save(person);
        return Result.success(person);
    }
}
