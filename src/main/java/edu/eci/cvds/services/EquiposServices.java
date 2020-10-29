package edu.eci.cvds.services;

import edu.eci.cvds.entities.Usuario;
/**
* Interface que cuenta con los servicios
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public interface EquiposServices {
	
     /**
      * Método que permite consultar a un usuario 
      * @param idCorreo: Identificador de correo del usuario
      * @param contrasena: Contraseña con la que cuenta el usuario
      */
     public Usuario consultarUsuario(String idCorreo, String contrasena) throws EquiposException;
}