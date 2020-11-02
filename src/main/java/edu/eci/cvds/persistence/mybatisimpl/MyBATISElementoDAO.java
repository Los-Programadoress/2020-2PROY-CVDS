package edu.eci.cvds.persistence.mybatisimpl;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ElementoMapper;

public class MyBATISElementoDAO implements ElementoDAO{
	
	@Inject
	private ElementoMapper elementoMapper;
	/**
     * Método que permite registrar un elemento a un equipo 
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del rol
	 * @param nequipo: Número de equipo al que pertenece el elemento
     */
	@Override
	@Transactional
	 public void registrarElementoEquipo(String tipo, String nombre, int nequipo) throws PersistenceException{
		boolean disponible = false;
		try{
			elementoMapper.registrarElementoEquipo(tipo,nombre,disponible,nequipo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar elemento del equipo",e);            
        }
	 }
	
	/**
     * Método que permite registrar un elemento
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del elemento
     */
	 @Override
	 @Transactional
	 public void registrarElemento(String tipo, String nombre) throws PersistenceException{
		boolean disponible = true;
		try{
			elementoMapper.registrarElemento(tipo,nombre, disponible);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar el elemento",e);            
        } 
	}
}
