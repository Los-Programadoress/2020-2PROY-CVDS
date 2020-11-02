package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ElementoMapper;

public class MyBATISElementoDAO implements ElementoDAO{
	
	@Inject
	private ElementoMapper elementoMapper;
	/**
     * Método que permite registrar un elemento a un equipo 
     * @param id: Identificador del elemento
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del rol
	 * @param nequipo: Número de equipo al que pertenece el elemento
     */
	@Override
	 public void registrarElementoEquipo(int id, String tipo, String nombre, int nequipo) throws PersistenceException{
		try{
			elementoMapper.registrarElementoEquipo(id,tipo,nombre,nequipo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar elemento del equipo",e);            
        }
	 }
	
	/**
     * Método que permite registrar un elemento
     * @param id: Identificador del elemento
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del elemento
     */
	 public void registrarElemento(int id, String tipo, String nombre) throws PersistenceException{
		try{
			elementoMapper.registrarElemento(id,tipo,nombre);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar el elemento",e);            
        } 
	}
}
