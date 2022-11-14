package prr.app.lookup;

import prr.app.exception.UnknownClientKeyException;
import prr.core.Network;
import prr.core.exception.InvalidClientIDException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show communications to a client.
 */
class DoShowCommunicationsToClient extends Command<Network> {

  /**
   * Constructor that just uses the super() with the receiver parameter
   * and creates a StringField that will hold the client key
   * @param receiver
   */
  DoShowCommunicationsToClient(Network receiver) {
    super(Label.SHOW_COMMUNICATIONS_TO_CLIENT, receiver);
    addStringField("clientKey", Message.clientKey());
  }

  /**
   * Execute method that displays all the communications received by the given client
   * using the stringField with the client's key
   * @throws CommandException
   */
  @Override
  protected final void execute() throws CommandException {
    try {
      _display.popup(_receiver.getCommsReceivedByClient(stringField("clientKey")));
    } catch (InvalidClientIDException e) {
      throw new UnknownClientKeyException(e.getID());
    }
  }
}
