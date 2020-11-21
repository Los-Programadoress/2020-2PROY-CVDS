package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Usuario;

/**
* Interface que permite acceder a datos
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public interface UsuarioDAO {
	
     /**
     * Método que permite consultar a un usuario 
     * @param idCorreo: Identificador de correo del usuario
     * @throws PersistenceException Errores con la base de datos
     * @return Usuario consultado
     */
    public Usuario consultarUsuario(String idCorreo) throws PersistenceException;


    /**
     * Método que permite registrar a un usuario 
     * @param usuario: Usuario a registrar
     * @throws PersistenceException Errores con la base de datos
     */
	public void registrarUsuario(Usuario usuario) throws PersistenceException;
}