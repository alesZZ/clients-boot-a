package pe.edu.upc.clientsboot.domain.values;

import lombok.Value;
import pe.edu.upc.clientsboot.application.notification.Notification;
import pe.edu.upc.clientsboot.application.notification.Result;

import javax.persistence.Embeddable;

@Embeddable
@Value
public class Ruc {
    private String value;

    private final static int MAX_LENGTH = 11;

    private Ruc(String ruc) {
        value = ruc;
    }

    protected Ruc() {
        this.value = "";
    }

    public static Result<Ruc, Notification> create(String ruc) {
        Notification notification = new Notification();
        ruc = ruc == null ? "" : ruc.trim();
        if (ruc.isEmpty()) {
            notification.addError("ruc is required", null);
        }
        if (ruc.length() > MAX_LENGTH) {
            notification.addError("The maximum length of a ruc is " + MAX_LENGTH + " characters including spaces", null);
        }
        if (notification.hasErrors()) {
            return Result.failure(notification);
        }
        return Result.success(new Ruc(ruc));
    }
}