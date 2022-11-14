package prr.core;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class TariffPlan implements Serializable {

    /** Serial number */
    private static final long serialVersionUID = 5230596851456277672L;

    /** specific name of the TariffPlan **/
    private final String _name;

    /**
     * Main Constructor
     * @param name
     */
    public TariffPlan(String name){
        _name = name;
    }

    /** @return the TariffPlan's name **/
    public String getTariffName(){
        return this._name;
    }

    /**
     * The three functions below are responsible for computing the cost
     * of the transactions of the TariffPlan within the client,
     * they will have similar ways of working but different arguments,
     * depending on the Communication type
     **/

    /**
     * @return the Cost of the TariffPlan decided by some conditions and rules set by the
     * Client's status and balance; this method is only for Text Comms
     * @param c
     * @param t
     */
    public long computeCost(Client c, CommunicationText t){
        int custo = 0;

        if (Objects.equals(c.getLevel().toString(), "NORMAL")) {
            if (t.getSize() < 50)
                custo = 10;
            else if (50 <= t.getSize() && t.getSize() < 100)
                custo = 16;
            else
                custo = 2 * t.getSize();
        }
        if (Objects.equals(c.getLevel().toString(), "GOLD")) {
            if (t.getSize() < 50)
                custo = 10;
            else if (50 <= t.getSize() && t.getSize() < 100)
                custo = 10;
            else
                custo = 2 * t.getSize();
        }
        if (Objects.equals(c.getLevel().toString(), "PLATINUM")) {
            if (t.getSize() < 50)
                custo = 0;
            else if (50 <= t.getSize() && t.getSize() < 100)
                custo = 4;
            else
                custo = 4;
        }
        c.adicionaDebts(custo);
        t.getSender().adicionaDebts(custo);
        return custo;
    }

    /**
     * @return the Cost of the TariffPlan decided by some conditions and rules set by the
     * Client's status and balance; this method is only for Voice Comms
     * @param c
     * @param t
     */
    public long computeCost(Client c, CommunicationVoice t){
        int custo = 0;

        if (Objects.equals(c.getLevel().toString(), "NORMAL"))
            custo = 20 * t.getSize();
        else if (Objects.equals(c.getLevel().toString(), "GOLD"))
            custo = 10 * t.getSize();
        else if (Objects.equals(c.getLevel().toString(), "PLATINUM"))
            custo = 10 * t.getSize();
        c.adicionaDebts(custo);
        t.getSender().adicionaDebts(custo);
        return custo;
    }

    /**
     * @return the Cost of the TariffPlan decided by some conditions and rules set by the
     * Client's status and balance; this method is only for Video Comms
     * @param c
     * @param t
     */
    public long computeCost(Client c, CommunicationVideo t){
        int custo = 0;

        if (Objects.equals(c.getLevel().toString(), "NORMAL"))
            custo = 30 * t.getSize();
        else if (Objects.equals(c.getLevel().toString(), "GOLD"))
            custo = 20 * t.getSize();
        else if (Objects.equals(c.getLevel().toString(), "PLATINUM"))
            custo = 10 * t.getSize();
        c.adicionaDebts(custo);
        t.getSender().adicionaDebts(custo);
        return custo;
    }

}
