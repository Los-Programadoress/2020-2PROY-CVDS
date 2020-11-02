package edu.eci.cvds.persistence;

/**
* Interface que permite acceder a datos
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public interface ElementoDAO {
	/**
     * Método que permite registrar elemento a un equipo
     * @param id: Identificador del elemento
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del elemento
	 * @param nequipo: Número de equipo al que pertenece el elemento
     */
	 public void registrarElementoEquipo(int id, String tipo, String nombre, int nequipo) throws PersistenceException;
	 
	/**
     * Método que permite registrar un elemento
     * @param id: Identificador del elemento
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del elemento
     */
	 public void registrarElemento(int id, String tipo, String nombre) throws PersistenceException;
}
