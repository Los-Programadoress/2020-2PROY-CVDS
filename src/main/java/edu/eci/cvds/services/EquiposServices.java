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
      */
     public Usuario consultarUsuario(String idCorreo) throws EquiposException;
     
     /**
      * Método que permite registrar a un usuario 
      * @param usuario: Usuario a registrar
      */
     public void registrarUsuario(Usuario usuario) throws EquiposException;
     
     /**
      * Método que permite consultar los equipos
      * @return lista de equipos consultados
      * 
      */
 	 public List<Equipo> consultarEquipos() throws EquiposException;
 	 
 	 /**
      * Método que permite consultar un equipo
      * @param numero: Número que identifica el equipo
      * @return Equipo consultado
      */
 	 public Equipo consultarEquipo(int nequipo) throws EquiposException;
 	
     /**
      * Método que permite registrar un equipo 
      * @param marca: Marca del equipo
      * @param usuario: Usuario que registra el equipo
      */
 	 public void registrarEquipo(String marca, Usuario usuario) throws EquiposException;
 	 
 	/**
      * Método que permite registrar elemento a un equipo
 	  * @param tipo: Tipo del elemento
 	  * @param nombre: Nombre del elemento
 	  * @param nequipo: Número de equipo al que pertenece el elemento
      */
 	 public void registrarElementoEquipo(String tipo, String nombre, int nequipo) throws EquiposException;
 	 
 	/**
      * Método que permite registrar consultar los elementos de un equipo 
      * @param nequipo: Número que identifica el equipo
      * @return lista de elementos del equipo consultados
      */
 	 public List<Elemento> consultarElementosEquipo(int nequipo) throws EquiposException;
 	 
 	/**
      * Método que permite registrar un elemento
 	  * @param tipo: Tipo del elemento
 	  * @param nombre: Nombre del elemento
      */
 	 public void registrarElemento(String tipo, String nombre) throws EquiposException;
 	 
 	/**
 	 * Método que permite registrar un elemento
 	     * @param nume: Identificador del numero
 	 * @param tipo: Tipo del elemento
 	     */
 	public void asociarElemento(int nume, String tipo) throws EquiposException;

 	/**
 	     * Método que permite registrar un elemento
 	     * @return lista de elementos consultados
 	     */
 	public List<Elemento> consultarElementos() throws EquiposException;
}