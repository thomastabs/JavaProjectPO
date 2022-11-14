package prr.app.terminal;

import prr.core.*;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Turn off the terminal.
 */
class DoTurnOffTerminal extends TerminalCommand {

  /**
   * Constructor that just uses the super() with the parameters
   * @param context
   * @param terminal
   */
  DoTurnOffTerminal(Network context, Terminal terminal) {
    super(Label.POWER_OFF, context, terminal);
  }

  /**
   * Execute that turns the terminal OFF, if the terminal's
   * already turned off, a message will be sent
   **/
  @Override
  protected final void execute() throws CommandException {
    if(_receiver.getTerminalModeEnum() == TerminalMode.OFF){
      _display.popup(Message.alreadyOff());
    }
    else
      _receiver.turnOff();
  }
}


