package edu.eci.cvds.persistence.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Usuario;

/**
* Interface que permite mapear el resultado de la base de datos
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public interface UsuarioMapper {

     /**
      * Método que permite consultar a un usuario 
      * @param idCorreo: Identificador de correo del usuario
      * @param contrasena: Contraseña con la que cuenta el usuario
      */
     public Usuario consultarUsuario( @Param("idCorreo") String idCorreo);
     
     /**
      * Método que permite registrar a un usuario 
      * @param usuario: Usuario a registrar
      */
     public void registrarUsuario(@Param("usuario") Usuario usuario);   
}
