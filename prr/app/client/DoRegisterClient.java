package prr.app.client;

import prr.app.exception.UnknownClientKeyException;
import prr.core.Network;
import prr.app.exception.DuplicateClientKeyException;
import prr.core.exception.ClientKeyAlreadyUsedException;
import prr.core.exception.UnkownClientKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Register new client.
 */
class DoRegisterClient extends Command<Network> {

  /**
   * addStringField that represents the Client's key
   * addStringField that represents the Client's name
   * addIntegerField that represents the Client's tax number
   **/

  DoRegisterClient(Network receiver) {
    super(Label.REGISTER_CLIENT, receiver);
    addStringField("clientKey", Message.key());
    addStringField("clientName", Message.name());
    addIntegerField("clientTaxNumber", Message.taxId());
  }

  /**
   * Execute method that uses the previous stringFields and
   * IntegerField to register a Client in the system
   * @throws CommandException
   */
  @Override
  protected final void execute() throws CommandException {
    try {
      _receiver.registerClient(
              stringField("clientKey"),
              stringField("clientName"),
              integerField("clientTaxNumber")
      );
    } catch (ClientKeyAlreadyUsedException e) {
      throw new DuplicateClientKeyException(e.getKey());
    } catch (UnkownClientKeyException e) {
      throw new UnknownClientKeyException(e.getID());
    }
  }
}
