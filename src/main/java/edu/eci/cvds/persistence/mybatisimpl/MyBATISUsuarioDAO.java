package edu.eci.cvds.persistence.mybatisimpl;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBATISUsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.cvds.services.EquiposException;

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
	public Usuario consultarUsuario(String idCorreo) throws PersistenceException {;
		try{
			return usuarioMapper.consultarUsuario(idCorreo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el usuario",e);            
        }
	}
	
	/**
     * Método que permite registrar a un usuario 
     * @param usuario: Usuario a registrar
     */
	@Override
	@Transactional
	public void registrarUsuario(Usuario usuario) throws EquiposException{
		try{
			usuarioMapper.registrarUsuario(usuario);
		}
		catch(NullPointerException e){
            throw new EquiposException("Error al registrar el usuario",e);            
        }
	}
}
	