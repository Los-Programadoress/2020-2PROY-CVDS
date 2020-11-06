package edu.eci.cvds.persistence.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.persistence.PersistenceException;

public interface ElementoMapper {
	/**
     * Método que permite registrar elemento a un equipo 
	 * @param disponible 
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del elemento
	 * @param disponible: Estado del elemento
	 * @param nequipo: Número de equipo al que pertenece el elemento
     */
	 public void registrarElementoEquipo(@Param("tipo") String tipo, @Param("nombre") String nombre, @Param("disponible")boolean disponible, @Param("nequipo") int nequipo);
	 
	/**
     * Método que permite registrar un elemento
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del elemento
	 * @param disponible: Estado del elemento
     */
	 public void registrarElemento(@Param("tipo") String tipo, @Param("nombre") String nombre, @Param("disponible")boolean disponible);

	 /**
 	 * Método que permite asociar un elemento a un equipo
	 * @param disponible 
 	 * @param nume: Identificador del numero
 	 * @param numElemento: Identificador del elemento
 	 * @param disponible: Estado del elemento
 	 */
	public void asociarElemento(@Param("nume")int nume, @Param("numel")int numElemento, @Param("disponible")boolean disponible);

	/**
    * Método que permite registrar un elemento
    * @return lista de elementos consultados
    */
	public List<Elemento> consultarElementos();
	
	/**
     * Método que permite registrar un elemento
     * @param tipo El tipo de elemento
	 * @param disponible 
     * @return lista de elementos del tipo consultados
     */
	public List<Elemento> consultarElementoDisponible(@Param("tipo")String tipo, @Param("disponible")boolean disponible);
	
}
