package prr.core;

import java.io.Serializable;

/**
 * Class representing a communication
 */
public abstract class Communication implements Serializable {

    /** Serial number for serialization. */
    private static final long serialVersionUID = -809010677570144248L;

    /** Communication's id, the first comm starts with 1 */
    private int _id;

    /** To check if the communication has been paid */
    private boolean _isPaid;

    /** The terminal that will receive the comm */
    private Terminal _receiver;

    /** The terminal that will send the comm */
    private Terminal _sender;

    /** Communication's cost*/
    private long _cost;


    /**
     * Main Construtor
     * @param sender
     * @param receiver
     * @param id
     */
    public Communication(Terminal sender, Terminal receiver, int id) {
        this._id = id;
        this._isPaid = false;
        this._receiver = receiver;
        this._sender = sender;
        this._cost = 0;
    }

    /** @return Communication's id **/
    public int getId() { return _id; }

    /** @return the Communication's receiver **/
    public Terminal getReceiver() {
        return _receiver;
    }

    /** @return the Communication's sender **/
    public Terminal getSender() {
        return _sender;
    }

    /** @return if the communication has been paid */
    public boolean isPaid() {
        return _isPaid;
    }

    /** @return comm's cost */
    public long getCost() {
        return _cost;
    }

    /** method that makes the communication be paid */
    public void pagarComm(){this._isPaid = true;}

    /**
     * Void method that sets the _cost attribute to the value of the argument
     * @param cost
     **/
    public void setCost(long cost) {this._cost = cost;}

    /** @return the detais of the communication*/
    public abstract String toCommString();

    /** @return the size of the message*/
    protected abstract int getSize();

}

