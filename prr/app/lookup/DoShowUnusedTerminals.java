package prr.app.lookup;

import prr.core.Network;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show unused terminals (without communications).
 */
class DoShowUnusedTerminals extends Command<Network> {

  /**
   * Constructor that just uses the super() with the receiver parameter
   * @param receiver
   */
  DoShowUnusedTerminals(Network receiver) {
    super(Label.SHOW_UNUSED_TERMINALS, receiver);
  }

  /**
   * Execute method that shows in the display all terminals
   * that were never used once for a Communication
   * @throws CommandException
   */
  @Override
  protected final void execute() throws CommandException {
    _display.popup(_receiver.getAllVirginTerminals());
  }
}
