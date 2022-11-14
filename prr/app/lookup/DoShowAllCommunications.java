package prr.app.lookup;

import prr.core.Network;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Command for showing all communications.
 */
class DoShowAllCommunications extends Command<Network> {

  /**
   * Constructor that just uses the super() with the receiver parameter
   * @param receiver
   */
  DoShowAllCommunications(Network receiver) {
    super(Label.SHOW_ALL_COMMUNICATIONS, receiver);
  }

  /**
   * Execute method that shows in the display all
   * communications in the system
   * @throws CommandException
   */
  @Override
  protected final void execute() throws CommandException {
    _display.popup(_receiver.getAllComms());
  }
}
