package prr.core.exception;

public class AlreadyExistsTerminalException extends Exception {

    /** Serial number for serialization */
    private static final long serialVersionUID = -8508696160170486614L;
    private String _terminalKey;

    public AlreadyExistsTerminalException(String key) {
        _terminalKey = key;
    }

    public String getKey() {
        return _terminalKey;
    }
}
