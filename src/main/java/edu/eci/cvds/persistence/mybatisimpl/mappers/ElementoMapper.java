package edu.eci.cvds.persistence.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Elemento;

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
	* Método que permite registrar un elemento
	* @param nume: Identificador del numero
	* @param tipo: Tipo del elemento
	*/
	public void asociarElemento(@Param("nume")int nume, @Param("tipo")String tipo);

	/**
    * Método que permite registrar un elemento
    * @return lista de elementos consultados
    */
	public List<Elemento> consultarElementos();
}
