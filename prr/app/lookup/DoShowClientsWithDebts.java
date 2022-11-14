package prr.app.lookup;

import prr.core.Network;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show clients with negative balance.
 */
class DoShowClientsWithDebts extends Command<Network> {

  /**
   * Constructor that just uses the super() with the receiver parameter
   * @param receiver
   */
  DoShowClientsWithDebts(Network receiver) {
    super(Label.SHOW_CLIENTS_WITH_DEBTS, receiver);
  }

  /**
   * Execute method that shows in the display all
   * the clients with debts in the system
   * @throws CommandException
   */
  @Override
  protected final void execute() throws CommandException {
    _display.popup(_receiver.getAllClientsWithDebts());
  }
}
