package prr.app.lookup;

import prr.core.Network;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show clients with positive balance.
 */
class DoShowClientsWithoutDebts extends Command<Network> {

  /**
   * Constructor that just uses the super() with the receiver parameter
   * @param receiver
   */
  DoShowClientsWithoutDebts(Network receiver) {
    super(Label.SHOW_CLIENTS_WITHOUT_DEBTS, receiver);
  }

  /**
   * Execute method that shows in the display all
   * the clients without debts in the system
   * @throws CommandException
   */
  @Override
  protected final void execute() throws CommandException {
    _display.popup(_receiver.getAllClientsWithNoDebts());
  }
}

