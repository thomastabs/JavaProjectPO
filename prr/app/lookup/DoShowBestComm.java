package prr.app.lookup;

import prr.core.Network;
import prr.core.exception.InvalidCommIDException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

public class DoShowBestComm extends Command<Network> {

    /**
     * Constructor that just uses the super() with the receiver parameter
     * @param receiver
     */
    DoShowBestComm(Network receiver) {
        super("Melhor Comunicação", receiver);
    }

    /**
     * Execute method that shows in the display all
     * communications in the system
     * @throws CommandException
     */
    @Override
    protected final void execute() throws CommandException {
        try {
            _display.popup(_receiver.melhorCommPagaComTamanhoMaior());
        } catch (InvalidCommIDException e) {
            throw new RuntimeException(e);
        }
    }
}
