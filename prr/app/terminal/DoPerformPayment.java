package prr.app.terminal;

import prr.core.Communication;
import prr.core.Network;
import prr.core.Terminal;
import prr.core.exception.InvalidCommIDException;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Perform payment.
 */
class DoPerformPayment extends TerminalCommand {

  /** addIntegerField that represents the Communication's key **/
  DoPerformPayment(Network context, Terminal terminal) {
    super(Label.PERFORM_PAYMENT, context, terminal);
    addIntegerField("commKey",Message.commKey());
  }

  /**
   * Execute method that performs a payment of the given
   * communication if the requirements are met
   * @throws CommandException
   **/
  @Override
  protected final void execute() throws CommandException {
    if (!_network.getComms().containsKey(integerField("commKey")) ||
            !_network.getComms().get(integerField("commKey")).getSender().getTerminalId().equals(_receiver.getTerminalId()))
      _display.popup(Message.invalidCommunication());
    else
      _network.performPayment(integerField("commKey"));
  }
}
