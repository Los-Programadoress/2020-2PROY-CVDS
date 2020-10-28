package edu.eci.cvds.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.services.EquiposException;
import edu.eci.cvds.services.EquiposServices;

public class EquiposServicesImpl implements EquiposServices{
	
	@Inject
    UsuarioDAO usuarioDAO;
	
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
