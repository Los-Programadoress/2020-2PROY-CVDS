package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBATISUsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;

/**
* Clase que permite mapear el acceso a datos
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public class MyBATISUsuarioDAO implements UsuarioDAO{
	
	@Inject
	private UsuarioMapper usuarioMapper;
	
	/**
     * Método que permite consultar a un usuario 
     * @param idCorreo: Identificador de correo del usuario
     * @param contrasena: Contraseña con la que cuenta el usuario
     */
	@Override
	public Usuario consultarUsuario(String idCorreo, String contrasena) throws PersistenceException {;
		try{
			return usuarioMapper.consultarUsuario(idCorreo,contrasena);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el usuario",e);            
        }
	}
}
	