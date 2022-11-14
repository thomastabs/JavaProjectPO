package prr.app.exception;

import pt.tecnico.uilib.menus.CommandException;

import java.io.Serial;

/** Exception thrown when a client key is duplicated. */
public class DuplicateClientKeyException extends CommandException {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 7751031025733713742L;

	/** @param key the duplicated key */
	public DuplicateClientKeyException(String key) {
		super(Message.duplicateClientKey(key));
	}

}
