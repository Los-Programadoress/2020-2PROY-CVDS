package edu.eci.cvds.persistence;

/**
* Clase que permite controlar las excepciones
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public class PersistenceException extends Exception {

	private static final long serialVersionUID = 1L;

	public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(Throwable cause) {
        super(cause);
    }
}