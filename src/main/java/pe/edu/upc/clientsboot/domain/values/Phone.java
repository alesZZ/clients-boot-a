package pe.edu.upc.clientsboot.domain.values;

import lombok.Value;
import pe.edu.upc.clientsboot.application.notification.Notification;
import pe.edu.upc.clientsboot.application.notification.Result;

import javax.persistence.Embeddable;

@Embeddable
@Value
public class Phone {
    private String value;
    private final static int MAX_LENGTH = 50;

    private Phone(String phone) {
        value = phone;
    }

    protected Phone() {
        this.value = "";
    }

    public static Result<Phone, Notification> create(String phone) {
        Notification notification = new Notification();
        phone = phone == null ? "" : phone.trim();
        if (phone.isEmpty()) {
            notification.addError("phone is required", null);
        }
        if (phone.length() > MAX_LENGTH) {
            notification.addError("The maximum length of a phone is " + MAX_LENGTH + " characters including spaces", null);
        }
        if (notification.hasErrors()) {
            return Result.failure(notification);
        }
        return Result.success(new Phone(phone));
    }
}
