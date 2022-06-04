package pe.edu.upc.clientsboot.domain.values;

import lombok.Value;
import pe.edu.upc.clientsboot.application.notification.Notification;
import pe.edu.upc.clientsboot.application.notification.Result;

import javax.persistence.Embeddable;

@Embeddable
@Value
public class Address {
    private String value;
    private final static int MAX_LENGTH = 150;

    private Address(String address) {
        value = address;
    }

    protected Address() {
        this.value = "";
    }

    public static Result<Address, Notification> create(String address) {
        Notification notification = new Notification();
        address = address == null ? "" : address.trim();
        if (address.isEmpty()) {
            notification.addError("address is required", null);
            return Result.failure(notification);
        }
        if (address.length() > MAX_LENGTH) {
            notification.addError("The maximum length of an address is " + MAX_LENGTH + " characters including spaces", null);
        }
        if (notification.hasErrors()) {
            return Result.failure(notification);
        }
        return Result.success(new Address(address));
    }
}
