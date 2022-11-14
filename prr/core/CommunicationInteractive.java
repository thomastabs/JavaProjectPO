package prr.core;

import java.io.Serializable;

public abstract class CommunicationInteractive extends Communication implements Serializable {

    /** Serial number for serialization. */
    private static final long serialVersionUID = 8009448938807110202L;

    /** The duration of the call */
    private int _duration;

    /** To check if the communication is still ocurring */
    private boolean _isOnGoing;

    /**
     * Main Constructor
     * Same parameters as communication
     */
    public CommunicationInteractive(Terminal sender, Terminal receiver, int id){
        super(sender, receiver, id);
        this._duration = 0;
        this._isOnGoing = true;
    }

    /** @return the detais of the communication*/
    public abstract String toCommString();

    /** @return Communication's duration **/
    @Override
    protected int getSize() {
        return _duration;
    }

    /** @return the boolean attribute that shows if the comm is finished or not **/
    public boolean isOnGoing(){ return _isOnGoing; }

    /**
     * Void method that sets the duration of
     * the Communication with the given argument
     */
    protected void setSizeDuration(int size){ this._duration = size; }

    /** Void method that sets the communication state to finished **/
    public void acabaCall(){this._isOnGoing = false;}

}
