package edu.eci.cvds.persistence.mybatisimpl;

import java.util.List;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.EquipoDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatisimpl.mappers.EquipoMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.cvds.services.EquiposException;

public class MyBATISEquipoDAO implements EquipoDAO{
	
	@Inject
	private EquipoMapper equipoMapper;
	
	@Inject
	private UsuarioMapper usuarioMapper;
	
	 /**
     * Método que permite consultar los equipos
     * @return lista de equipos consultados
     */
	 @Override
	 public  List<Equipo> consultarEquipos() throws PersistenceException{
		try{
			return equipoMapper.consultarEquipos();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
	        throw new PersistenceException("Error al consultar los equipos",e);            
	    }
	 }
	 
	 /**
     * Método que permite consultar un equipo
     * @param numero: Número que identifica el equipo
     * @return Equipo consultado
     */
	@Override
	 public Equipo consultarEquipo(int nequipo) throws PersistenceException{
		try{
			return equipoMapper.consultarEquipo(nequipo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
	        throw new PersistenceException("Error al consultar el equipo",e);            
	    }
	}
	 
	/**
     * Método que permite registrar un equipo 
     * @param numero: Número que identifica el equipo
     * @param marca: Marca del equipo
     * @param usuario: Usuario que registra el equipo
     */
	@Override
	@Transactional
	 public void registrarEquipo(String marca, String idcorreo) throws EquiposException{
		boolean disponible = true;
		try{
			Usuario user = usuarioMapper.consultarUsuario(idcorreo);
			equipoMapper.registrarEquipo(marca, disponible, user.getIdCorreo());
		}
		catch(NullPointerException e){
            throw new EquiposException("Error al registrar el equipo",e);            
        }
	 }
	
	/**
     * Método que permite registrar consultar los elementos de un equipo 
     * @param nequipo: Número que identifica el equipo
     * @return lista de elementos del equipo consultados
     */
	@Override
	 public List<Elemento> consultarElementosEquipo(int nequipo) throws PersistenceException{
		try{
			return equipoMapper.consultarElementosEquipo(nequipo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
	        throw new PersistenceException("Error al consultar elementos del equipo",e);            
	    }
	}
	
}
