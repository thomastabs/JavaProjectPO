package prr.app.lookup;

import prr.app.exception.UnknownClientKeyException;
import prr.core.Network;
import prr.core.exception.InvalidClientIDException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show communications from a client.
 */
class DoShowCommunicationsFromClient extends Command<Network> {

  /**
   * Constructor that just uses the super() with the receiver parameter
   * and creates a StringField that will hold the client key
   * @param receiver
   */
  DoShowCommunicationsFromClient(Network receiver) {
    super(Label.SHOW_COMMUNICATIONS_FROM_CLIENT, receiver);
    addStringField("clientKey", Message.clientKey());
  }

  /**
   * Execute method that displays all the communications made by the given client
   * using the stringField with the client's key
   * @throws CommandException
   */
  @Override
  protected final void execute() throws CommandException {
    try {
      _display.popup(_receiver.getCommsMadeByClient(stringField("clientKey")));
    } catch (InvalidClientIDException e) {
      throw new UnknownClientKeyException(e.getID());
    }
  }
}
