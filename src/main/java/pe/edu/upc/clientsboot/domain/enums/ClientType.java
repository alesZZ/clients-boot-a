package pe.edu.upc.clientsboot.domain.enums;

public enum ClientType {
    PERSON(1),
    COMPANY(2);

    private final int value;

    ClientType(final int type) {
        value = type;
    }

    public int getValue() { return value; }
}
