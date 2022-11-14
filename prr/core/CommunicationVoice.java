package prr.core;

import java.io.Serializable;

public class CommunicationVoice extends CommunicationInteractive implements Serializable {

    /** Serial number for serialization. */
    private static final long serialVersionUID = -5965358224750296684L;

    /** The type of comm (in this case is voice)  */
    private String _type;

    /**
     * Main Constructor
     * @param sender
     * @param receiver
     * @param id
     */
    public CommunicationVoice(Terminal sender, Terminal receiver, int id) {
        super(sender, receiver, id);
        this._type = "VOICE";
    }

    /** @return the Communication's type **/
    private String getType(){ return _type; }

    /** @return a String that represents the Communication **/
    @Override
    public String toCommString(){
        String status;
        int caracteres;
        if (isOnGoing()) {
            status = "ONGOING";
            caracteres = 0;
        }
        else {
            status = "FINISHED";
            caracteres = this.getSize();
        }

        return String.join(
                "|",
                getType(),
                String.valueOf(getId()),
                getSender().getTerminalId(),
                getReceiver().getTerminalId(),
                String.valueOf(caracteres),
                String.valueOf(Math.round(getCost())),
                status);
    }
}