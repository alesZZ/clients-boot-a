package pe.edu.upc.clientsboot.domain.values;

import lombok.Value;
import pe.edu.upc.clientsboot.application.notification.Notification;
import pe.edu.upc.clientsboot.application.notification.Result;

import javax.persistence.Embeddable;

@Embeddable
@Value
public class CompanyName {
    private String value;
    private final static int MAX_LENGTH = 100;

    private CompanyName(String name) {
        value = name;
    }

    protected CompanyName() {
        this.value = "";
    }

    public static Result<CompanyName, Notification> create(String name) {
        Notification notification = new Notification();
        name = name == null ? "" : name.trim();
        if (name.isEmpty()) {
            notification.addError("company name is required", null);
        }
        if (name.length() > MAX_LENGTH) {
            notification.addError("The maximum length of a company name is " + MAX_LENGTH + " characters including spaces", null);
        }
        if (notification.hasErrors()) {
            return Result.failure(notification);
        }
        return Result.success(new CompanyName(name));
    }
}
