package prr.app.terminal;

import prr.core.Network;
import prr.core.Terminal;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Command for showing the ongoing communication.
 */
class DoShowOngoingCommunication extends TerminalCommand {

  /**
   * Constructor that just uses the super() with the parameters
   * @param context
   * @param terminal
   */
  DoShowOngoingCommunication(Network context, Terminal terminal) {
    super(Label.SHOW_ONGOING_COMMUNICATION, context, terminal);
  }

  /**
   * Execute method that shows the current ongoing Communication
   * with the given terminal if the requirements are met
   */
  @Override
  protected final void execute() throws CommandException {
    if(_receiver.getCurrentComm() == null){
      _display.popup(Message.noOngoingCommunication());
    }
    else
      _display.popup(_receiver.getCurrentComm().toCommString());
  }
}
