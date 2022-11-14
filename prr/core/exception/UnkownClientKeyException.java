package prr.core.exception;

public class UnkownClientKeyException extends Exception{

    /** Serial number for serialization */
    private static final long serialVersionUID = 7502548784080056944L;
    private String _key;

    public UnkownClientKeyException(String key) {
        _key = key;
    }

    public String getID() {
        return _key;
    }
}
