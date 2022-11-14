package prr.app.terminal;

import prr.app.exception.UnknownTerminalKeyException;
import prr.core.Network;
import prr.core.Terminal;
import prr.core.exception.InvalidTerminalIDException;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show balance.
 */
class DoShowTerminalBalance extends TerminalCommand {

  /**
   * Constructor that just uses the super() with the parameters
   * @param context
   * @param terminal
   */
  DoShowTerminalBalance(Network context, Terminal terminal) {
    super(Label.SHOW_BALANCE, context, terminal);
  }

  /**
   * Execute method that shows a message with the terminal's
   * debts and payments
   **/
  @Override
  protected final void execute() throws CommandException {
    _display.popup(
            Message.terminalPaymentsAndDebts(
                    _receiver.getTerminalId(),
                    _receiver.getTerminalPayments(),
                    _receiver.getTerminalDebts()
            )
    );
  }
}
