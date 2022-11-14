package prr.core.exception;

import java.io.Serial;

/**
 * Exception for unknown import file entries.
 */
public class UnrecognizedEntryException extends Exception {

  /** Class serial number. */
  private static final long serialVersionUID = 3048972048358959797L;
  
  /** Bad bad entry specification. */
  private String _entrySpecification;
  
  /**
   * @param entrySpecification
   */
  public UnrecognizedEntryException(String entrySpecification) {
    _entrySpecification = entrySpecification;
  }
  
  /**
   * @param entrySpecification
   * @param cause
   */
  public UnrecognizedEntryException(String entrySpecification, Exception cause) {
    super(cause);
    _entrySpecification = entrySpecification;
  }
  
  /**
   * @return the bad entry specification.
   */
  public String getEntrySpecification() {
    return _entrySpecification;
  }
}
