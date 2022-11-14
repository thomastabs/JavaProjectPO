package prr.core;

import java.io.Serializable;

public class CommunicationVideo extends CommunicationInteractive implements Serializable {

    /** Serial number for serialization. */
    private static final long serialVersionUID = 2838788769932805382L;

    /** The type of comm (in this case is video)  */
    private String _type;

    /**
     * Main Constructor
     * @param sender
     * @param receiver
     * @param id
     */
    public CommunicationVideo(Terminal sender, Terminal receiver, int id) {
        super(sender, receiver, id);
        this._type = "VIDEO";
    }

    /** @return the Communication's type **/
    public String getType(){ return this._type; }

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
