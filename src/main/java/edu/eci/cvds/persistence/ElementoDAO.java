package edu.eci.cvds.persistence;

import java.util.List;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.services.EquiposException;

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
	 * @throws PersistenceException Errores con la base de datos
     */
	 public void registrarElementoEquipo(String tipo, String nombre, int nequipo) throws PersistenceException;
	 
	/**
     * Método que permite registrar un elemento
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del elemento
	 * @throws PersistenceException Errores con la base de datos
     */
	 public void registrarElemento(String tipo, String nombre) throws PersistenceException;

	/**
 	 * Método que permite asociar un elemento a un equipo
 	 * @param nume: Identificador del numero
 	 * @param numElemento: Identificador del elemento
 	 * @throws PersistenceException Errores con la base de datos
 	*/
	public void asociarElemento(int nume, int numElemento) throws PersistenceException;

	/**
    * Método que permite registrar un elemento
    * @throws PersistenceException Errores con la base de datos
    * @return lista de elementos consultados
    */
	public List<Elemento> consultarElementos() throws PersistenceException;
	
	/**
     * Método que permite registrar un elemento
     * @param tipo El tipo de elemento
     * @throws EquiposException Errores con la operación
     * @return lista de elementos del tipo consultados
     */
	public List<Elemento> consultarElemento(String tipo) throws PersistenceException;
	
	/**
     * Método que permite saber si es un tipo válido
     * @param tipo: Tipo del elemento
     * @return si es un elemento válido
     */
	public boolean esTipoValido(String tipo);
}
