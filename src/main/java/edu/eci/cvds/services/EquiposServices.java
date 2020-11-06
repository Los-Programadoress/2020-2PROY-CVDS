package edu.eci.cvds.services;

import java.util.List;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
/**
* Interface que cuenta con los servicios
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public interface EquiposServices {
	
     /**
      * Método que permite consultar a un usuario 
      * @param idCorreo: Identificador de correo del usuario
      * @param contrasena: Contraseña con la que cuenta el usuario
      * @throws EquiposException Errores con la operación
      * @return Usuario consultado
      */
     public Usuario consultarUsuario(String idCorreo) throws EquiposException;
     
     /**
      * Método que permite registrar a un usuario 
      * @param usuario: Usuario a registrar
      * @throws EquiposException Errores con la operación
      */
     public void registrarUsuario(Usuario usuario) throws EquiposException;
     
     /**
      * Método que permite consultar los equipos
      * @throws EquiposException Errores con la operación
      * @return lista de equipos consultados
      */
 	 public List<Equipo> consultarEquipos() throws EquiposException;
 	 
 	 /**
      * Método que permite consultar un equipo
      * @param numero: Número que identifica el equipo
      * @throws EquiposException Errores con la operación
      * @return Equipo consultado
      */
 	 public Equipo consultarEquipo(int nequipo) throws EquiposException;
 	
     /**
      * Método que permite registrar un equipo 
      * @param marca: Marca del equipo
      * @param idcorreo: Identificador del correo del usuario
      * @throws EquiposException Errores con la operación
      */
 	 public void registrarEquipo(String marca, String idcorreo) throws EquiposException;
 	 
 	/**
      * Método que permite registrar elemento a un equipo
 	  * @param tipo: Tipo del elemento
 	  * @param nombre: Nombre del elemento
 	  * @param nequipo: Número de equipo al que pertenece el elemento
 	  * @throws EquiposException Errores con la operación
      */
 	 public void registrarElementoEquipo(String tipo, String nombre, int nequipo) throws EquiposException;
 	 
 	/**
      * Método que permite registrar consultar los elementos de un equipo 
      * @param nequipo: Número que identifica el equipo
      * @throws EquiposException Errores con la operación
      * @return lista de elementos del equipo consultados
      */
 	 public List<Elemento> consultarElementosEquipo(int nequipo) throws EquiposException;
 	 
 	/**
      * Método que permite registrar un elemento
 	  * @param tipo: Tipo del elemento
 	  * @param nombre: Nombre del elemento
 	  * @throws EquiposException Errores con la operación
      */
 	 public void registrarElemento(String tipo, String nombre) throws EquiposException;
 	 
 	/**
 	 * Método que permite asociar un elemento a un equipo
 	 * @param nume: Identificador del numero
 	 * @param numElemento: Identificador del elemento
 	 * @throws EquiposException Errores con la operación
 	*/
 	public void asociarElemento(int nume, int numElemento) throws EquiposException;
 	
 	/**
 	* Método que permite desasociar un elemento
 	* @param disponible: Permite identificar la disponibilidad del elemento
 	* @param nume: Identificador del equipo
 	* @param tipo: Tipo del elemento
 	* @throws EquiposException Errores con la operación
 	*/
 	public void desasociarElemento(boolean disponible, int nume, String tipo) throws EquiposException;
 	
 	/**
     * Método que permite consultar los elementos existentes
     * @throws EquiposException Errores con la operación
     * @return lista de elementos consultados
     */
 	public List<Elemento> consultarElementos() throws EquiposException;
 	
 	/**
     * Método que permite registrar un elemento
     * @param tipo El tipo de elemento
     * @throws EquiposException Errores con la operación
     * @return lista de elementos del tipo consultados
     */
 	public List<Elemento> consultarElemento(String tipo) throws EquiposException;
 	
 	/**
     * Método que permite saber si es un tipo válido
     * @param tipo: Tipo del elemento
     * @throws EquiposException Errores con la operación
     * @return si es un elemento válido
     */
 	public boolean esTipoValido(String tipo) throws EquiposException;
}