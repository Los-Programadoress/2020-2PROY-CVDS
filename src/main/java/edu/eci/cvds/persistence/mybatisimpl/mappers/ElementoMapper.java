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
 	 * Método que permite asociar un elemento a un equipo
	 * @param disponible 
 	 * @param nume: Identificador del numero
 	 * @param numElemento: Identificador del elemento
 	 * @param disponible: Estado del elemento
 	 */
	public void asociarElemento(@Param("nume")int nume, @Param("numel")int numElemento, @Param("disponible")boolean disponible);
	
	/**
	* Método que permite desasociar un elemento
	* @param disponible: Permite identificar la disponibilidad del elemento
	* @param nume: Identificador del equipo
	* @param tipo: Tipo del elemento
	*/
	public void desasociarElemento(@Param("disp") boolean disponible, @Param("nume")int nume, @Param("tipo") String tipo);
	
	/**
    * Método que permite registrar un elemento
    * @return lista de elementos consultados
    */
	public List<Elemento> consultarElementos();
	
	/**
     * Método que permite consultar un elemento
     * @param tipo El tipo de elemento
     * @return lista de elementos del tipo consultados
     */
	public List<Elemento> consultarElemento(@Param("tipo")String tipo);
	
	/**
     * Método que permite consultar los elementos por disponibilidad
     * @return lista de elementos consultados
     */
	public List<Elemento> consultarElementosDisponibles();
	
	/**
     * Método que permite cambiar el estado de dar de baja a un elemento
     * @param dBaja: Cambiar estado de baja al elemento
     * @param enom: Nombre del elemento
     */
	public void cambiarBajaElemento(@Param("dBaja") boolean dBaja, @Param("enom") String enom);
	
	/**
    * Método que permite consultar un reporte del elemento
    * @return lista de elementos consultados
    */
	public List<Elemento> reporteElementos();
	
}
