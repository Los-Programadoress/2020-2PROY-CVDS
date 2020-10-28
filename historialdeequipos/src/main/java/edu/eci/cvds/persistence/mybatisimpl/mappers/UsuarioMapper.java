package edu.eci.cvds.persistence.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Usuario;

public interface UsuarioMapper {

    public Usuario consultarUsuario( @Param("idCorreo") String idCorreo, @Param("contrasena") String contrasena);
   
}
