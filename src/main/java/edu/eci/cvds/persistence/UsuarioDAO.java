package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Usuario;

public interface UsuarioDAO {
	
	public Usuario consultarUsuario(String idCorreo, String contrasena) throws PersistenceException;
}