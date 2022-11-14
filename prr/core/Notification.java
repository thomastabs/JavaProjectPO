package prr.core;

import java.io.Serializable;

public class Notification implements Serializable {

    /** Serial number for serialization. **/
    private static final long serialVersionUID = 5459416424048243113L;

    /** The notification's type **/
    private NotificationType _tipoNotificacao;

    /** The client associated with the notification **/
    private Terminal _terminalANotificar;

    /**
     * Main Constructor
     * @param tipoNotificacao
     * @param terminalANotificar
     */
    public Notification(NotificationType tipoNotificacao, Terminal terminalANotificar) {
        this._tipoNotificacao = tipoNotificacao;
        this._terminalANotificar = terminalANotificar;
    }

    /** @return a String that symbolizes the communication **/
    public NotificationType getTipoNotificacao() {
        return _tipoNotificacao;
    }

    /** @return a Terminal that is going to be notified **/
    public Terminal getTerminalANotificar() {
        return _terminalANotificar;
    }

    /** @return a String that represents the notification itself with the parameters necessary **/
    public String notificationStringed() {
        return String.join(
                "|",
                getTipoNotificacao().toString(),
                getTerminalANotificar().getTerminalId()
        );
    }
}
