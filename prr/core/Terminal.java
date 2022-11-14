package prr.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Class that represents the terminal.
 */
public class Terminal implements Serializable {

  /** Serial number **/
  private static final long serialVersionUID = -8325403726503191669L;

  /** Terminal's id **/
  private final String _id;

  /** Terminal's type **/
  private String _tipo;

  /** Terminal's debt **/
  private long _debt;

  /** Terminal's payments **/
  private long _payments;

  /** Enum that contains the terminal's mode **/
  private TerminalMode _terminalmode;

  /** Enum that contains the terminal's mode **/
  private TerminalMode _beforeState;

  /** List that contains the terminal's friends **/
  private TreeSet<String> _amigos;

  /** Client that is associated with the terminal in question **/
  private Client _clientTerminal;

  /** Boolean that says if the terminal had made any type of comm or not **/
  private boolean _virgem;

  /** Boolean that says if the terminal is in a Communication or not **/
  private boolean _busy;

  /** Current communication in the terminal */
  private Communication _currentComm;

  /** ArrayList that contais the terminals that tried to make a Communication **/
  private ArrayList<Terminal> _tentaramNotificar;

  /**
   * Main Construtor
   * @param id
   * @param tipo
   */

  public Terminal(String id, String tipo){
    _id = id;
    _terminalmode = TerminalMode.ON;
    _beforeState = null;
    _tipo = tipo;
    _debt = 0;
    _payments = 0;
    _amigos = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
    _clientTerminal = null;
    _virgem = true;
    _busy = false;
    _currentComm = null;
    _tentaramNotificar = new ArrayList<>();
  }

  /** @return terminal's id **/
  public String getTerminalId(){
    return this._id;
  }

  /** @return terminal's mode **/
  public TerminalMode getTerminalModeEnum(){
    return this._terminalmode;
  }

  /** @return terminal's type **/
  public String getTerminalType(){
    return this._tipo;
  }

  /** @return terminal's debt **/
  public long getTerminalDebts(){
    return this._debt;
  }

  /** @return terminal's payments **/
  public long getTerminalPayments(){
    return this._payments;
  }

  /** @return terminal's Friends ArrayList **/
  public TreeSet<String> getTerminalAmigos(){return (TreeSet<String>) this._amigos;}

  /** @return terminal's asscociated Client **/
  public Client getClientTerminal(){return _clientTerminal;}

  /** @return boolean that says if the terminal has made any type of Comm or not **/
  public boolean usedOrNot(){ return this._virgem;}

  /** @return terminal's asscociated Client **/
  public Communication getCurrentComm(){ return _currentComm; }

  /**
   @return an ArrayLIst that contains the terminals
   that tried to make a communication
   **/
  public ArrayList<Terminal> getTentaramNotificar() { return _tentaramNotificar; }

  /** Void method that sets the "never used" attribute to false **/
  public void setUsed(){ this._virgem = false; }

  /**
   * Void method that sets the Client's association with the terminal
   * @param _clientTerminal
   **/
  public void setClientTerminal(Client _clientTerminal) {
    this._clientTerminal = _clientTerminal;
  }

  /**
   * Void method that sets the communication that is going to be made
   * @param _currentComm
   * **/
  public void setComm(Communication _currentComm) {
    this._currentComm = _currentComm;
  }

  /**
   Void method that changes the _busy attribute
   and saves the previous Terminal's mode depending on the boolean argument
   * @param b
   **/
  public void setBusy(boolean b) {
    if (b){
      this._beforeState = this._terminalmode;
      this._busy = b;
      this._terminalmode = TerminalMode.BUSY;
    }
    else{
      this._terminalmode = this._beforeState;
      this._beforeState = null;
      this._busy = b;
    }
  }

  /**
   Void method that receives the communication's cost and adds the
   * Terminal's debt by adding the current debts with the given cost
   * @param cost
   **/
  public void adicionaDebts(long cost){
    this._debt += cost;
  }

  /**
   * Void method that receives the communication's cost and 'pays' the
   * debts by decreasing the Terminal's debts and increasing the Terminal's payments
   * @param cost
   **/
  public void paga(long cost){
    this._debt -= cost;
    this._payments += cost;
  }

  /** Void method that sets the current Comm of the terminal to null **/
  public void setCommToNull(){ this._currentComm = null; }

  /**
   Boolean method that returns true if the Client C in the argument is one
   of the associated Clients in the ArrayList that contains the terminals
   that tried to make a communication
   * @param c
   */
  public boolean verificarClienteIDExistente(Client c){
    ArrayList<String> clientIDs = new ArrayList<String>();

    for(Terminal t : this._tentaramNotificar){
      clientIDs.add(t.getClientTerminal().getKey());
    }

    return clientIDs.contains(c.getKey());
  }

  /** ##########################
   *  METHODS USED DIRECTLY/TO HELP IN APP FUNCTIONALITIES
   * ##########################
   */

  /**
   Void method that verifies if the requirements are met, and sets the terminal's mode to ON/IDLE
   while creating the right notification
   **/
   public void setONIdle() {
      if (_terminalmode.toString().equals("OFF") || _terminalmode.toString().equals("SILENCE")) {
        if (_terminalmode.toString().equals("OFF") && !this.getTentaramNotificar().isEmpty()) {
          for (Terminal t : this.getTentaramNotificar()) {
            Notification n = new Notification(NotificationType.O2I, this);
            t.getClientTerminal().getNotificacoesClient().add(n);
          }
          this.getTentaramNotificar().clear();
        }
        if (_terminalmode.toString().equals("SILENCE") && !this.getTentaramNotificar().isEmpty()) {
          for (Terminal t : this.getTentaramNotificar()) {
            Notification n = new Notification(NotificationType.S2I, this);
            t.getClientTerminal().getNotificacoesClient().add(n);
          }
          this.getTentaramNotificar().clear();
        }
        this._terminalmode = TerminalMode.ON;
      }
    }

  /**
   Void method that verifies if the requirements are met, and sets the terminal's mode to SILENCE
   while creating the right notification
   **/
  public void setOnSilent() {
      if (_terminalmode.toString().equals("ON") || _terminalmode.toString().equals("OFF") ){
        if (_terminalmode.toString().equals("OFF") && !this.getTentaramNotificar().isEmpty()) {
          for (Terminal t : this.getTentaramNotificar()) {
            Notification n = new Notification(NotificationType.O2S, this);
            t.getClientTerminal().getNotificacoesClient().add(n);
          }
          this.getTentaramNotificar().clear();
        }
        _terminalmode = TerminalMode.SILENCE;
      }
    }

  /**
   Void method that verifies if the requirements are met, and sets the terminal's mode to OFF
   **/
  public void turnOff() {
    if (_terminalmode.toString().equals("ON") || _terminalmode.toString().equals("SILENCE")) {
      _terminalmode = TerminalMode.OFF;
    }
  }

  /**
   * Void method that adds the Terminal's ID to the Friends List
   * @param idTerminalNewFriend
   **/
  public void addAmigo(String idTerminalNewFriend){
    this._amigos.add(idTerminalNewFriend);
  }

  /**
   * Void method that adds the Terminal's ID to the Friends List
   * @param idTerminalOldFriend
   **/
  public void removeAmigo(String idTerminalOldFriend){
    this._amigos.remove(idTerminalOldFriend);
  }

  /**
   * Terminal toString
   * @return a terminal in string format
   */
  public String terminalStringed() {
    String terminalModeStringed = getTerminalModeEnum().toString();

    if(getTerminalModeEnum() == TerminalMode.ON){
      terminalModeStringed = "IDLE";
    }

    if (this._amigos.isEmpty()) {
      return String.join(
              "|",
              getTerminalType(),
              getTerminalId(),
              getClientTerminal().getKey(),
              terminalModeStringed,
              String.valueOf(Math.round(getTerminalPayments())),
              String.valueOf(Math.round(getTerminalDebts())));
    } else {
      return String.join(
              "|",
              getTerminalType(),
              getTerminalId(),
              getClientTerminal().getKey(),
              terminalModeStringed,
              String.valueOf(Math.round(getTerminalPayments())),
              String.valueOf(Math.round(getTerminalDebts())),
              String.join(", ", _amigos));
    }
  }

  /**
   -> * Checks if this terminal can end the current interactive communication.
   *
   * @return true if this terminal is busy (i.e., it has an active interactive communication) and
   *          it was the originator of this communication.
  **/
  public boolean canEndCurrentCommunication() {
    if (_busy) {
      if ((this.getCurrentComm().getReceiver().equals(this)))
        return !_busy;
      else {
        return _busy;
      }
    }
    else
      return false;
  }

  /**
   -> * Checks if this terminal can start a new communication.
   *
   * @return true if this terminal is neither off neither busy, false otherwise.
  **/
  public boolean canStartCommunication() {
    if (this.getTerminalModeEnum() == TerminalMode.OFF)
      return _busy;
    return !_busy;
  }
}
