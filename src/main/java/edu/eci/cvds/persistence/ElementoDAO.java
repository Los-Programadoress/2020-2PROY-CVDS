package edu.eci.cvds.persistence;

import java.util.List;

import edu.eci.cvds.entities.Elemento;

/**
* Interface que permite acceder a datos
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public interface ElementoDAO {
	/**
     * Método que permite registrar elemento a un equipo
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del elemento
	 * @param nequipo: Número de equipo al que pertenece el elemento
     */
	 public void registrarElementoEquipo(String tipo, String nombre, int nequipo) throws PersistenceException;
	 
	/**
     * Método que permite registrar un elemento
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del elemento
     */
	 public void registrarElemento(String tipo, String nombre) throws PersistenceException;

	/**
    * Método que permite registrar un elemento
    * @param nume: Identificador del numero
	* @param tipo: Tipo del elemento
	*/
	public void asociarElemento(int nume, String tipo) throws PersistenceException;

	/**
    * Método que permite registrar un elemento
    * @return lista de elementos consultados
    */
	public List<Elemento> consultarElementos() throws PersistenceException;
}
