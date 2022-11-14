package prr.app.main;

import prr.core.NetworkManager;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import prr.core.exception.MissingFileAssociationException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Command to save a file.
 * If the file does not belong into the app, it will ask the file's name.
 * If it does belong, the file will be saved.
 */
class DoSaveFile extends Command<NetworkManager> {

  /** @param receiver */
  DoSaveFile(NetworkManager receiver) {
    super(Label.SAVE_FILE, receiver);
  }
  
  @Override
  protected final void execute() {
    try {
      _receiver.save();
    } catch (MissingFileAssociationException mfe) {
      boolean saved = false;
      while (!saved) {
        try {
          _receiver.saveAs(Form.requestString(Message.newSaveAs()));
          saved = true;
        } catch (MissingFileAssociationException | IOException e) {
          // catches this error if the user presses "Enter" without anything written
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
