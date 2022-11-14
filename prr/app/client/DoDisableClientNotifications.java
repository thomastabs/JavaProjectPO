package prr.app.client;

import prr.core.Network;
import prr.app.exception.UnknownClientKeyException;
import prr.core.exception.InvalidClientIDException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Disable client notifications.
 */
class DoDisableClientNotifications extends Command<Network> {

  /** addStringField that represents the Client's key **/
  DoDisableClientNotifications(Network receiver) {
    super(Label.DISABLE_CLIENT_NOTIFICATIONS, receiver);
    addStringField("clientKey", Message.key());
  }

  /**
   * execute that tries to disable the Client's
   * notifications, if its already disabled then there
   * is no effect and a message is showed to the user,
   * and tries to catch exceptions as well if necessary
   * @throws CommandException
   */
  @Override
  protected final void execute() throws CommandException {
    try {
      if (_receiver.getClient(stringField("clientKey")).isRecieveNotifications())
        _receiver.getClient(stringField("clientKey")).deactivateNotifications();
      else
        _display.popup(Message.clientNotificationsAlreadyDisabled());
    } catch (InvalidClientIDException e) {
      throw new UnknownClientKeyException(e.getID());
    }
  }
}
