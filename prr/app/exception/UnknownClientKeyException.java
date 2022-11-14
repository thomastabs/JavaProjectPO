package prr.app.exception;

import pt.tecnico.uilib.menus.CommandException;

import java.io.Serial;

/** Exception for unknown clients. **/
public class UnknownClientKeyException extends CommandException {

	/** Serial number (serialization) */
	private static final long serialVersionUID = 3819864629621048319L;

	/** @param key Unknown client to report. */
	public UnknownClientKeyException(String key) {
		super(Message.unknownClientKey(key));
	}

}
