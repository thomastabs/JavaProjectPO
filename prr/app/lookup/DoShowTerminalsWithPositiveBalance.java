package prr.app.lookup;

import prr.core.Network;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show terminals with positive balance.
 */
class DoShowTerminalsWithPositiveBalance extends Command<Network> {

  /**
   * Constructor that just uses the super() with the receiver parameter
   * @param receiver
   */
  DoShowTerminalsWithPositiveBalance(Network receiver) {
    super(Label.SHOW_TERMINALS_WITH_POSITIVE_BALANCE, receiver);
  }

  /**
   * Execute that shows the terminals that have a positive balance
   * @throws CommandException
   */
  @Override
  protected final void execute() throws CommandException {
    _display.popup(_receiver.getTerminalsPositiveBalance());
  }
}
