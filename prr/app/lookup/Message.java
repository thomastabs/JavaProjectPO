package prr.app.lookup;

/**
 * Messages.
 */
interface Message {

  /**
   * @return string prompting for client key
   */
  static String clientKey() {
    return "Identificador do cliente: ";
  }

  /**
   * @return string prompting for terminal key
   */
  static String terminalKey() {
    return "Número do terminal: ";
  }
}
