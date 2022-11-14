package prr.core.exception;

public class InvalidCommIDException extends Exception {

    /** Serial number for serialization */
    private static final long serialVersionUID = -7490870621670007305L;

    private int _key;

    public InvalidCommIDException(int key) {
        _key = key;
    }
    public int getCommID() {
        return _key;
    }
}
