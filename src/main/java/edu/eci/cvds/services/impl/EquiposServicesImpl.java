package edu.eci.cvds.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.services.EquiposException;
import edu.eci.cvds.services.EquiposServices;

/**
* Clase que cuenta con los servicios
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public class EquiposServicesImpl implements EquiposServices{
	
	@Inject
    UsuarioDAO usuarioDAO;
	
     /**
      * Método que permite consultar a un usuario 
      * @param idCorreo: Identificador de correo del usuario
      * @param contrasena: Contraseña con la que cuenta el usuario
      */
     @Override
     public Usuario consultarUsuario(String idCorreo, String contrasena) throws EquiposException {
    	 try {
    		 return usuarioDAO.consultarUsuario(idCorreo,contrasena);
    	 }
    	 catch (PersistenceException ex) {
    		 throw new EquiposException("Error al consultar el usuario" + ex.getLocalizedMessage(), ex);
    	 }
    }
}
