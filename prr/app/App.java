package prr.app;

import prr.core.NetworkManager;
import prr.core.exception.ImportFileException;
import pt.tecnico.uilib.Dialog;

/**
 ---> Projeto Final de PO:
 Turno de Lab nº5, grupo 28

 - Fábio Sobrinho nº103473
 - Tomás Taborda nº103641
 **/

/**
 * Application entry-point.
 */
public class App {

  public static void main(String[] args) {
    try (var ui = Dialog.UI) {
      var receiver = new NetworkManager();
      
      String datafile = System.getProperty("import");
      if (datafile != null) {
        try {
          receiver.importFile(datafile);
        } catch (ImportFileException e) {
          // no behavior described: just present the problem
          e.printStackTrace();
        }
      }
      (new prr.app.main.Menu(receiver)).open();
    }
  }
}
