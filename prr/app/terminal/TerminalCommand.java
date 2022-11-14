package prr.app.terminal;

import java.util.function.Predicate;

import prr.core.Network;
import prr.core.Terminal;
import pt.tecnico.uilib.menus.Command;

/**
 * Commands for terminals may sometimes need to consider the network context.
 */
abstract class TerminalCommand extends Command<Terminal> {

  protected Network _network;

  TerminalCommand(String label, Network network, Terminal terminal) {
    super(label, terminal);
    _network = network;
  }
  
  TerminalCommand(String label, Network network, Terminal terminal, Predicate<Terminal> valid) {
    super(label, terminal, valid);
    _network = network;
  }
}
