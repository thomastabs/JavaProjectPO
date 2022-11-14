package prr.app.terminals;

import prr.app.exception.UnknownTerminalKeyException;
import prr.core.Network;
import prr.app.exception.DuplicateTerminalKeyException;
import prr.app.exception.InvalidTerminalKeyException;
import prr.app.exception.UnknownClientKeyException;
import prr.core.exception.*;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


/**
 * Register terminal.
 */
class DoRegisterTerminal extends Command<Network> {

  /**
   * addStringField that represents the Terminal's key
   * addOptionField that represents the terminal's type ("BASIC", "FANCY")
   * addStringField that represents the associated client's key
   **/
  DoRegisterTerminal(Network receiver) {
    super(Label.REGISTER_TERMINAL, receiver);
    String[] options = {"BASIC","FANCY"};
    addStringField("terminalKey", Message.terminalKey());
    addOptionField("terminalType", Message.terminalType(),options);
    addStringField("clientTerminal", Message.clientKey());
  }

  /**
   * execute that registers a terminal with the stringFields and optionFields
   * made previously, and tries to catch exceptions as well if necessary
   * @throws CommandException
   */

  @Override
  protected final void execute() throws CommandException {
    String id = String.valueOf(stringField("terminalKey"));
    if (id.matches(".*[a-z].*") || id.matches(".*[A-Z].*")) {
      throw new InvalidTerminalKeyException(id);
    }
    try {
      _receiver.registerTerminal(
              optionField("terminalType"),
              id,
              stringField("clientTerminal"));
    } catch (AlreadyExistsTerminalException e) {
      throw new DuplicateTerminalKeyException(e.getKey());
    } catch (InvalidClientIDException y) {
      throw new UnknownClientKeyException(y.getID());
    } catch(InvalidTerminalIDException t){
      throw new InvalidTerminalKeyException(t.getID());
    }
  }
}

