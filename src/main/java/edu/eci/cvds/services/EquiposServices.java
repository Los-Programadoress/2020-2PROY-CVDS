package edu.eci.cvds.services;

import edu.eci.cvds.entities.Usuario;

public interface EquiposServices {
	
	public Usuario consultarUsuario(String idCorreo, String contrasena) throws EquiposException;
}