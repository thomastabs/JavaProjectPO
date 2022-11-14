package prr.app.terminal;

import prr.app.exception.UnknownTerminalKeyException;
import prr.core.Network;
import prr.core.Terminal;
import prr.core.exception.InvalidTerminalIDException;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Add a friend.
 */
class DoAddFriend extends TerminalCommand {

  /** addStringField that represents the Terminal's key **/
  DoAddFriend(Network context, Terminal terminal) {
    super(Label.ADD_FRIEND, context, terminal);
    addStringField("terminalFriend", Message.terminalKey());
  }

  /**
   * Execute method that adds a friend (of type Terminal) to the terminal's
   * friend list if the requirements are met
   **/
  @Override
  protected final void execute() throws CommandException {
    try {
      if(!_receiver.getTerminalAmigos().contains(stringField("terminalFriend"))) {
        _network.addFriend(_receiver.getTerminalId(), stringField("terminalFriend"));
      }
    } catch (InvalidTerminalIDException e) {
      throw new UnknownTerminalKeyException(e.getID());
    }
  }
}
