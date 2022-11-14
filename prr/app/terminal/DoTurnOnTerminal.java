package prr.app.terminal;

import prr.core.*;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Turn on the terminal.
 */
class DoTurnOnTerminal extends TerminalCommand {

  /**
   * Constructor that just uses the super() with the parameters
   * @param context
   * @param terminal
   */
  DoTurnOnTerminal(Network context, Terminal terminal) {
    super(Label.POWER_ON, context, terminal);
  }

  /**
   * Execute that turns the terminal ON, if the terminal's
   * already turned on, a message will be sent
   **/
  @Override
  protected final void execute() throws CommandException {
    if (_receiver.getTerminalModeEnum() == TerminalMode.ON) {
      _display.popup(Message.alreadyOn());
    }
    else {
      _receiver.setONIdle();
    }
  }
}
