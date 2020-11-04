package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.EquiposException;

/**
* Interface que permite acceder a datos
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public interface UsuarioDAO {
	
     /**
     * Método que permite consultar a un usuario 
     * @param idCorreo: Identificador de correo del usuario
     */
    public Usuario consultarUsuario(String idCorreo) throws PersistenceException;


    /**
     * Método que permite registrar a un usuario 
     * @param usuario: Usuario a registrar
     * @throws EquiposException 
     */
	public void registrarUsuario(Usuario usuario) throws EquiposException;
}