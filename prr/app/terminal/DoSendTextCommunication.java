package prr.app.terminal;

import prr.core.Network;
import prr.core.Notification;
import prr.core.NotificationType;
import prr.core.Terminal;
import prr.app.exception.UnknownTerminalKeyException;
import prr.core.exception.InvalidTerminalIDException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Command for sending a text communication.
 **/
 class DoSendTextCommunication extends TerminalCommand {

    /**
     * addStringField that represents the Terminal's key
     * addStringField that represents the text message itself
     **/
    DoSendTextCommunication(Network context, Terminal terminal) {
      super(Label.SEND_TEXT_COMMUNICATION, context, terminal, receiver -> receiver.canStartCommunication());
      addStringField("terminalReceiver", Message.terminalKey());
      addStringField("message", Message.textMessage());
    }

    /**
     * Execute method that creates and sens a Text Communication if
     * all the requirements are met, if not a setup will be made
     * for the notifications to be used later
     * @throws CommandException
     */
    @Override
    protected final void execute() throws CommandException {
      try{
          Terminal t = _network.getTerminal(stringField("terminalReceiver"));
          if (t.getTerminalModeEnum().toString().equals("OFF")){
              _display.popup(Message.destinationIsOff(stringField("terminalReceiver")));
              if(_receiver.getClientTerminal().isRecieveNotifications()
                      && !t.verificarClienteIDExistente(_receiver.getClientTerminal())) {
                  t.getTentaramNotificar().add(_receiver);
              }
          }
          else {
              _network.DoSendTextCommunication(
                      _receiver.getTerminalId(),
                      stringField("terminalReceiver"),
                      stringField("message")
              );
          }
      } catch (InvalidTerminalIDException e){
          throw new UnknownTerminalKeyException(e.getID());
      }
    }
}

