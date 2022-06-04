package pe.edu.upc.clientsboot.domain.values;

import lombok.Value;
import pe.edu.upc.clientsboot.application.notification.Notification;
import pe.edu.upc.clientsboot.application.notification.Result;

import javax.persistence.Embeddable;

@Embeddable
@Value
public class Email {
    private String value;

    private final static int MAX_LENGTH = 150;

    private Email(String email) {
        value = email;
    }

    protected Email() {
        this.value = "";
    }

    public static Result<Email, Notification> create(String email) {
        Notification notification = new Notification();
        email = email == null ? "" : email.trim();
        if (email.isEmpty()) {
            notification.addError("email is required", null);
        }
        if (email.length() > MAX_LENGTH) {
            notification.addError("The maximum length of an email is " + MAX_LENGTH + " characters including spaces", null);
        }
        if (notification.hasErrors()) {
            return Result.failure(notification);
        }
        return Result.success(new Email(email));
    }
}