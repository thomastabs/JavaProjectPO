package prr.app.terminal;

import prr.core.Network;
import prr.core.Terminal;
import prr.core.exception.InvalidTerminalIDException;
import pt.tecnico.uilib.menus.CommandException;


/**
 * Remove friend.
 */
class DoRemoveFriend extends TerminalCommand {

  /** addStringField that represents the Terminal's key **/
  DoRemoveFriend(Network context, Terminal terminal) {
    super(Label.REMOVE_FRIEND, context, terminal);
    addStringField("terminalFriend", Message.terminalKey());
  }

  /**
   * Execute method that removes a friend (of type
   * Terminal) of the terminal's friend list if the requirements are met
   **/
  @Override
  protected final void execute() throws CommandException {
    try {
      if(_receiver.getTerminalAmigos().contains(stringField("terminalFriend"))) {
        _network.removeFriend(_receiver.getTerminalId(), stringField("terminalFriend"));
      }
    } catch (InvalidTerminalIDException e) {
      throw new RuntimeException(e);
    }
  }
}
