package edu.eci.cvds.services;

/**
* Clase que permite controlar las excepciones
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public class EquiposException extends Exception{
	
   private static final long serialVersionUID = 1L;

   public EquiposException() {}

   public EquiposException(String message) {
	super(message);
   }

   public EquiposException(String message, Throwable cause) {
        super(message, cause);
   }

   public EquiposException(Throwable cause) {
        super(cause);
    }	    
}
