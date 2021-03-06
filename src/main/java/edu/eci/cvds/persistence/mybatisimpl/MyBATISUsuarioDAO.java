package edu.eci.cvds.persistence.mybatisimpl;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UsuarioDAO;
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
     * @throws PersistenceException Errores con la base de datos
     * @return Usuario consultado
     */
	@Override
	public Usuario consultarUsuario(String idCorreo) throws PersistenceException{;
		try{
			return usuarioMapper.consultarUsuario(idCorreo);
		}
		catch(Exception e){
            throw new PersistenceException("Error al consultar el usuario",e);            
        }
	}
	
	/**
     * Método que permite registrar a un usuario
     * @param usuario: Usuario a registrar
     * @throws PersistenceException Errores con la base de datos
     * @throws NullPointerException
     */
	@Override
	@Transactional
	public void registrarUsuario(Usuario usuario) throws PersistenceException{
		try{
			usuarioMapper.registrarUsuario(usuario);
		}
		catch(Exception e){
            throw new PersistenceException("Error al registrar el usuario",e);            
        }
	}
}
	