package pe.edu.upc.clientsboot.domain.enums;

public enum ClientState {
    INACTIVE(0),
    ACTIVE(1);

    private final int value;

    ClientState(final int state) {
        value = state;
    }

    public int getValue() { return value; }
}
