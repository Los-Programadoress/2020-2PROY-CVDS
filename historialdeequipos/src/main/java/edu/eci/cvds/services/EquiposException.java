package edu.eci.cvds.services;

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
