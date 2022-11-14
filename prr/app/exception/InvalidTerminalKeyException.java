package prr.app.exception;

import pt.tecnico.uilib.menus.CommandException;

import java.io.Serial;

/** Exception for unknown terminals. */
public class InvalidTerminalKeyException extends CommandException {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 7218875754827558866L;

	/** @param key Unknown terminal to report. */
	public InvalidTerminalKeyException(String key) {
		super(Message.invalidTerminalKey(key));
	}

}
