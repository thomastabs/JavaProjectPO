package prr.app.main;

import prr.app.exception.DuplicateClientKeyException;
import prr.app.exception.UnknownClientKeyException;
import prr.core.Network;
import prr.core.exception.ClientKeyAlreadyUsedException;
import prr.core.exception.InvalidCommIDException;
import prr.core.exception.UnkownClientKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

public class DoRemoveCommsByIdSuperior extends Command<Network> {

    DoRemoveCommsByIdSuperior(Network receiver) {
        super("Remover Comunicações novas ", receiver);
        addIntegerField("commID", "Identificador: ");
    }

    /**
     * Execute method that removes a comm
     * @throws CommandException
     */
    @Override
    protected final void execute() throws CommandException {
        try {
            _display.popup(_receiver.removeCommsSuperiorID(integerField("commID")));
        } catch (InvalidCommIDException e) {
            throw new RuntimeException(e);
        }
    }
}
