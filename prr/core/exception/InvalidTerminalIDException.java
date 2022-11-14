package prr.core.exception;

import java.io.Serial;

public class InvalidTerminalIDException extends Exception{

    /** Serial number for serialization */
    private static final long serialVersionUID = -7471432872246049481L;
    private String _terminalKey;

    public InvalidTerminalIDException(String key) {
        _terminalKey = key;
    }

    public String getID() {
        return _terminalKey;
    }
}
