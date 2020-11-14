package edu.eci.cvds.persistence.mybatisimpl;

import java.util.List;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.TipoElemento;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ElementoMapper;
import edu.eci.cvds.services.EquiposException;

public class MyBATISElementoDAO implements ElementoDAO{
	
	@Inject
	private ElementoMapper elementoMapper;
	
	/**
     * Método que permite registrar un elemento a un equipo 
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del rol
	 * @param nequipo: Número de equipo al que pertenece el elemento
	 * @throws PersistenceException Errores con la base de datos
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
	 * @throws PersistenceException Errores con la base de datos
	 * @throws IllegalArgumentException No existe el tipo de elemento
     */
	 @Override
	 @Transactional
	 public void registrarElemento(String tipo, String nombre) throws PersistenceException{
		boolean disponible = true;
		String tipoC = convertToFormat(tipo);
		try{
			if (esTipoValido(tipoC)) {
				elementoMapper.registrarElemento(tipoC,nombre, disponible);
			}
		}
		catch(org.apache.ibatis.exceptions.PersistenceException | IllegalArgumentException e){
            throw new PersistenceException("Error al registrar el elemento",e);            
        } 
	}
	 
	/**
 	 * Método que permite asociar un elemento a un equipo
 	 * @param nume: Identificador del numero
 	 * @param numElemento: Identificador del elemento
 	 * @throws PersistenceException Errores con la base de datos
 	 */
	@Override
	@Transactional
	 public void asociarElemento(int nume, int numElemento) throws PersistenceException{
		boolean disponible = false; 
		try{
			 elementoMapper.asociarElemento(nume,numElemento, disponible);
		 }
		 catch(org.apache.ibatis.exceptions.PersistenceException e){
		     throw new PersistenceException("Error al asociar el elemento",e);            
		 }
	 }
	
  /**
	* Método que permite desasociar un elemento
	* @param disponible: Permite identificar la disponibilidad del elemento
	* @param nume: Identificador del equipo
	* @param tipo: Tipo del elemento
	* @throws PersistenceException Errores con la base de datos
	*/
	@Override
	@Transactional
	public void desasociarElemento(boolean disponible, int nume, String tipo) throws PersistenceException{
		String tipoC = convertToFormat(tipo);
		try{
			if(esTipoValido(tipoC)) {
				elementoMapper.desasociarElemento(disponible,nume,tipo);
			}
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al desasociar el elemento",e);
		}
	}

	 /**
     * Método que permite registrar un elemento
     * @throws PersistenceException Errores con la base de datos
     * @return lista de elementos consultados
     */
	 @Override
	 public List<Elemento> consultarElementos() throws PersistenceException{
		 try{
			 return elementoMapper.consultarElementos();
		 }
		 catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar elementos",e);            
        }
	 }
	 
	 /**
     * Método que permite registrar un elemento
     * @param tipo El tipo de elemento
     * @throws PersistenceException Errores con la base de datos
     * @return lista de elementos del tipo consultados
     */
	 @Override
	 public List<Elemento> consultarElemento(String tipo) throws PersistenceException {
		 String tipoC = convertToFormat(tipo);
		 try {
			 return elementoMapper.consultarElemento(tipoC);
		 }
		 catch(org.apache.ibatis.exceptions.PersistenceException | IllegalArgumentException e){
			 throw new PersistenceException("Error al consultar elementos de tipo: "+ tipoC,e);
		 }
	 }

	 /**
     * Método que permite saber si es un tipo válido
     * @param tipo: Tipo del elemento
     * @return si es un elemento válido
     */
	@Override
	public boolean esTipoValido(String tipo){	
		return (TipoElemento.valueOf(tipo) != null);
	}
	
	/**
     * Método que permite convertir el tipo ingresado a un formato reconocido
     * @param tipo: Tipo del elemento
     * @return el tipo en el formato
     */
	public String convertToFormat(String tipo) {
		 // Obtener primera letra y convertirla a mayúscula
	    String primeraLetra = tipo.substring(0, 1).toUpperCase();

	    // Obtener el resto de la cadena, intacta.
	    // Y convertir a minúscula
	    String restoDeLaCadena = tipo.substring(1).toLowerCase();

	    // Concatenar
	    String tipoConverted = primeraLetra + restoDeLaCadena;
		return tipoConverted;
		
	}
	
	/**
     * Método que permite cambiar el estado de dar de baja a un elemento
     * @param dBaja: Cambiar estado de baja al elemento
     * @param eId: Identificador del elemento
     * @throws EquiposException Errores con la operación
     */
	@Override
	public void cambiarBajaElemento(boolean dBaja,int eId) throws PersistenceException{
		try{
			elementoMapper.cambiarBajaElemento(dBaja, eId);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
           throw new PersistenceException("Error al cambiar la baja del elemento",e);            
       }
	}
	

}