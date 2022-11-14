package prr.app.exception;

import pt.tecnico.uilib.menus.CommandException;

import java.io.Serial;

/** Exception for unknown terminals. */
public class UnknownTerminalKeyException extends CommandException {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 7201948848609827699L;

	/** @param key Unknown terminal to report. */
	public UnknownTerminalKeyException(String key) {
		super(Message.unknownTerminalKey(key));
	}

}
