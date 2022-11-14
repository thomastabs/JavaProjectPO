package prr.core;

import java.io.*;
import java.util.ArrayList;

import prr.core.exception.*;


/**
 * Manage access to network and implement load/save operations.
 */
public class NetworkManager {

  /** Name of file corresponding to the Network. */
  private String filename = "";

  /** The network itself. */
  private Network _network = new Network();

  /** @return the network of the system **/
  public Network getNetwork() {
    return _network;
  }
  
  /**
   * @param filename name of the file containing the serialized application's state
   *        to load.
   * @throws UnavailableFileException if the specified file does not exist or there is
   *         an error while processing this file.
   */
  public void load(String filename) throws UnavailableFileException {
      try {
        ObjectInputStream ois =
                new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(filename)
                        )
                );

        _network = (Network) ois.readObject();
        ois.close();

        setFilename(filename);

      } catch (IOException | ClassNotFoundException e) {
        throw new UnavailableFileException(filename);
      }
    }

  /**
   * Saves the serialized application's state into the file associated to the current network.
   *
   * @throws FileNotFoundException if for some reason the file cannot be created or opened. 
   * @throws MissingFileAssociationException if the current network does not have a file.
   * @throws IOException if there is some error while serializing the state of the network to disk.
   */
  public void save() throws FileNotFoundException, MissingFileAssociationException, IOException {
    if (_network.getSaveFlag()) {
      return;
    }

    if (!hasFileAssociated()) {
      throw new MissingFileAssociationException();
    }

    _network.activateSaveFlag();
    ObjectOutputStream oos =
            new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(getFilename())
                    )
            );
    oos.writeObject(_network);
    oos.close();

  }
  
  /**
   * Saves the serialized application's state into the specified file. The current network is
   * associated to this file.
   *
   * @param filename the name of the file.
   * @throws FileNotFoundException if for some reason the file cannot be created or opened.
   * @throws MissingFileAssociationException if the current network does not have a file.
   * @throws IOException if there is some error while serializing the state of the network to disk.
   */
  public void saveAs(String filename) throws FileNotFoundException, MissingFileAssociationException, IOException {
    setFilename(filename);
    save();
  }

  /**
   * Read text input file and create domain entities..
   * 
   * @param filename name of the text input file
   * @throws ImportFileException
   */
  public void importFile(String filename) throws ImportFileException {
    try {
      _network.importFile(filename);
    } catch (IOException | UnrecognizedEntryException e) {
      throw new ImportFileException(filename, e);
    }
  }
  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }

  /** @return whether the manager has a filename associated or not */
  public boolean hasFileAssociated() {
    return !filename.equals("");
  }
}

