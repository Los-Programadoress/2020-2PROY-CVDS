package edu.eci.cvds.persistence.mybatisimpl;

import java.util.List;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
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
	 
	 /**
	 * Método que permite registrar un elemento
	 * @param nume: Identificador del numero
	 * @param tipo: Tipo del elemento
	 */
	 public void asociarElemento(int nume, String tipo) throws PersistenceException{
		 try{
			 elementoMapper.asociarElemento(nume,tipo);
		 }
		 catch(org.apache.ibatis.exceptions.PersistenceException e){
		     throw new PersistenceException("Error al asociar el elemento",e);            
		 }
	 }

	 /**
     * Método que permite registrar un elemento
     * @return lista de elementos consultados
     */
	 public List<Elemento> consultarElementos() throws PersistenceException{
		 try{
			 return elementoMapper.consultarElementos();
		 }
		 catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consutar elementos",e);            
        }
	 }

}
