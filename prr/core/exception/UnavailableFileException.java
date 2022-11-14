package prr.core.exception;

import java.io.Serial;

/**
 *  Exception for unavailable files.
 */
public class UnavailableFileException extends Exception {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 3135198898705281069L;
  
  /** The requested filename. */
  String _filename;
  
  /**
   * @param filename 
   */
  public UnavailableFileException(String filename) {
    super("Erro a processar ficheiro " + filename);
    _filename = filename;
  }
  
  /**
   * @return the requested filename
   */
  public String getFilename() {
    return _filename;
  }
}
