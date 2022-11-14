package prr.app.client;

import prr.core.Network;
import prr.app.exception.UnknownClientKeyException;
import prr.core.exception.InvalidClientIDException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show the payments and debts of a client.
 */
class DoShowClientPaymentsAndDebts extends Command<Network> {
  /**
   * Constructor that uses addStringField to represent the Client's key
   * @param receiver
   */
  DoShowClientPaymentsAndDebts(Network receiver) {
    super(Label.SHOW_CLIENT_BALANCE, receiver);
    addStringField("clientKey", Message.key());
  }

  /**
   * Execute method that displays the payments and debts of a client,
   * if there is no such client, it catches an exception, and it throws a new one
   * @throws CommandException
   */
  @Override
  protected final void execute() throws CommandException {
    try {
      _display.popup(
              Message.clientPaymentsAndDebts(
                      stringField("clientKey"),
                      _receiver.getClient(stringField("clientKey")).getPagamentos(),
                      _receiver.getClient(stringField("clientKey")).getDebts()
              )
      );
    } catch (InvalidClientIDException e) {
      throw new UnknownClientKeyException(e.getID());
    }
  }
}
