package prr.app.client;

import prr.core.Network;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show all clients.
 */
class DoShowAllClients extends Command<Network> {

  /**
   * Constructor that just uses the receiver parameter with the super()
   * @param receiver
   */
  DoShowAllClients(Network receiver) {
    super(Label.SHOW_ALL_CLIENTS, receiver);
  }

  /**
   * Execute method uses the getAllClients to display all the clients of the system
   * @throws CommandException
   */
  @Override
  protected final void execute() throws CommandException {
    _display.popup(_receiver.getAllClients());
  }
}
