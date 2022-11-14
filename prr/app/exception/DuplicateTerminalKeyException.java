package prr.app.exception;

import pt.tecnico.uilib.menus.CommandException;

/** Exception thrown when a terminal key is duplicated. */
public class DuplicateTerminalKeyException extends CommandException {

	/** Serial number for serialization. */
	private static final long serialVersionUID = -2256322785295427391L;

	/** @param key Duplicate terminal to report. */
	public DuplicateTerminalKeyException(String key) {
		super(Message.duplicateTerminalKey(key));
	}

}
