package prr.app.terminal;

import prr.core.*;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.CommandException;

 /**
 * Command for ending communication.
 * **/
 class DoEndInteractiveCommunication extends TerminalCommand {

     /** addIntegerField that represents the Communication's duration that the user wants **/
     DoEndInteractiveCommunication(Network context, Terminal terminal) {
         super(Label.END_INTERACTIVE_COMMUNICATION, context, terminal, receiver -> receiver.canEndCurrentCommunication());
         addIntegerField("duracao", Message.duration());
     }

     /**
      * With the help of a boolean in the Terminal Class,
      * it's possible to hide the option when needed.
      **/

     /**
      * Execute that ends the current terminal's communication if all the requirements are met,
      * and displays a message of the cost of the same Communication
      * @throws CommandException
      */
     @Override
     protected final void execute() throws CommandException {
         int duracao = integerField("duracao");
         try {
             if (_receiver.getCurrentComm() instanceof CommunicationVideo)
                 _display.popup(
                         Message.communicationCost(
                                 _network.stopVideoCall((CommunicationVideo) _receiver.getCurrentComm(), duracao)
                         )
                 );
             if (_receiver.getCurrentComm() instanceof CommunicationVoice)
                 _display.popup(
                         Message.communicationCost(
                                 _network.stopVoiceCall((CommunicationVoice) _receiver.getCurrentComm(), duracao)
                         )
                 );
         } catch (NumberFormatException e) { // suposta exceção para o formato numerico da duração
             throw new RuntimeException(e);
         }
     }
 }


