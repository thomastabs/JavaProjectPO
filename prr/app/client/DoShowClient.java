package prr.app.client;

import prr.core.Network;
import prr.app.exception.UnknownClientKeyException;
import prr.core.exception.InvalidClientIDException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show specific client: also show previous notifications.
 */
class DoShowClient extends Command<Network> {

  /**
   * Constructor that uses addIntegerField to represent the Client's key
   * @param receiver
   */
  DoShowClient(Network receiver) {
    super(Label.SHOW_CLIENT, receiver);
    addStringField("clientKey", Message.key());
  }

  /**
   * Execute method tries to display a Client's parameters in a String, and
   * if necessary catches an InvalidClientIDException
   * @throws CommandException
   */
  @Override
  protected final void execute() throws CommandException {
    try{
      _display.popup(_receiver.getClientString(stringField("clientKey")));
      _display.popup(_receiver.readClientNotifications(stringField("clientKey")));
    } catch (InvalidClientIDException e) {
      throw new UnknownClientKeyException(e.getID());
    }
  }
}
