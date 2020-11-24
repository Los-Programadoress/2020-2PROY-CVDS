package edu.eci.cvds.services;


import java.sql.Date;
import java.util.List;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.entities.Usuario;

/**
* Interface que cuenta con los servicios
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public interface EquiposServices {
	
	 //USUARIO
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
     
     //EQUIPO
     /**
      * Método que permite consultar los equipos
      * @throws EquiposException Errores con la operación
      * @return lista de equipos consultados
      */
 	 public List<Equipo> consultarEquipos() throws EquiposException;
 	 
 	/**
      * Método que permite consultar los equipos que no están dados de baja
      * @throws EquiposException Errores con la operación
      * @return lista de equipos consultados
      */
 	 public List<Equipo> consultarEquiposNoDadosBaja() throws EquiposException;
 	
 	 
 	 /**
      * Método que permite consultar un equipo
      * @param numero: Número que identifica el equipo
      * @throws EquiposException Errores con la operación
      * @return Equipo consultado
      */
 	 public Equipo consultarEquipo(int nequipo) throws EquiposException;
 	 
 	/**
 	 * Método que permite la asociacion de un laboratorio
 	 * @param nLab: Nombre del laboratorio
 	 * @param nome: Nombre del equipo
 	 * @throws EquiposException Errores con la operación
 	*/
 	 public void asociacionEquipo(String nLab, String nome, String user) throws EquiposException;
 	 
 	/**
 	 * Método que permite cambiar el estado de dar de baja a un elemento
 	 * @param nombre: Nombre del equipo 
 	 * @param marca: Marca del elemento
 	 * @param idCorreo: Usuario que registra el equipo
 	 * @throws EquiposException Errores con la operación
 	*/
 	public void registrarEquipo(String nombre, String marca, String idcorreo) throws EquiposException;
 	 
 	/**
      * Método que permite registrar consultar los elementos de un equipo 
      * @param nequipo: Número que identifica el equipo
      * @throws EquiposException Errores con la operación
      * @return lista de elementos del equipo consultados
      */
 	 public List<Elemento> consultarElementosEquipo(String nequipo) throws EquiposException;
     
 	/**
      * Método que permite cambiar el estado de dar de baja a un equipo
      * @param nome: Nombre del equipo
      * @throws EquiposException Errores con la operación
      */
	 public void cambiarBajaEquipo(String nome, String user) throws EquiposException;
	 
	//ELEMENTO 
 	/**
      * Método que permite registrar elemento a un equipo
 	  * @param tipo: Tipo del elemento
 	  * @param nombre: Nombre del elemento
 	  * @param nequipo: Número de equipo al que pertenece el elemento
 	  * @throws EquiposException Errores con la operación
      */
 	 public void registrarElementoEquipo(String tipo, String nombre, int nequipo) throws EquiposException;
 	 
 	/**
      * Método que permite registrar un elemento
 	  * @param tipo: Tipo del elemento
 	  * @param nombre: Nombre del elemento
 	  * @param user: Nombre del Usuario en sesión
 	  * @throws EquiposException Errores con la operación
      */
 	 public void registrarElemento(String tipo, String nombre, String user) throws EquiposException;
 	 
 	/**
 	 * Método que permite asociar un elemento a un equipo
 	 * @param nume: Identificador del numero
 	 * @param numElemento: Identificador del elemento
 	 * @throws EquiposException Errores con la operación
 	*/
 	public void asociarElemento(int nume, int numElemento) throws EquiposException;
 	
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
     * Método que permite consultar los elementos por disponibilidad
     * @return lista de elementos consultados
     */
	public List<Elemento> consultarElementosDisponibles() throws EquiposException;
 	
 	/**
     * Método que permite saber si es un tipo válido
     * @param tipo: Tipo del elemento
     * @throws EquiposException Errores con la operación
     * @return si es un elemento válido
     */
 	public boolean esTipoValido(String tipo) throws EquiposException;
	
	/**
	* Método que permite desasociar un elemento
	* @param disponible: Permite identificar la disponibilidad del elemento
	* @param nume: Identificador del equipo
	* @param tipo: Tipo del elemento
	* @param equipoNombre: Nombre del equipo
	* @param elementoNombre: Nombre del elemento 
	* @throws EquiposException Errores con la operación
	*/
 	public void asociacionElemento(int id, int numero, String tipo, String equipoNombre, String elementoNombre, String user)throws EquiposException;
	
	/**
	 * Método que permite desasociar un elemento
	 * @param disponible: Permite identificar la disponibilidad del elemento
	 * @param nume: Identificador del elemento
	 * @param tipo: Tipo del elemento
	 * @throws EquiposException Errores con la operación
	*/
	public void desasociarElemento(boolean disponible, int nume, String tipo) throws EquiposException;
	
 	/**
     * Método que permite cambiar el estado de dar de baja a un elemento
     * @param dBaja: Cambiar estado de baja al elemento
     * @param enom: Nombre del elemento
     * @throws EquiposException Errores con la operación
     */
	public void cambiarBajaElemento(boolean dBaja, String enom, String user) throws EquiposException;
	
	/**
	* Método que retorna el conjunto de elementos seleccionados
	* @return elSelected Lista de elementos seleccionados
	*/
	public List<Elemento> getElSelected();
	
	/**
	* Método que agrega elementos a la lista de seleccionados
	* @param elementoSelec: Elemento seleccionado
	*/
	public void add(Elemento elementoSelec);
	
	//NOVEDAD
	/**
     * Método que permite registrar una novedad para el laboratorio
	 * @param titulo: Titulo de la novedad
	 * @param fecha: Fecha en la que se registro la novedad
	 * @param responsable: Identificador del correo del usuario
	 * @param detalle: Detalle de la novedad del laboratorio
	 * @param nLab: Nombre del laboratorio que tiene la novedad
	 * @throws EquiposException Errores con la operación
     */
	 public void registrarNovedadLaboratorio(String titulo, Date fecha, String resp, String detalle, String nLab) throws EquiposException;
	 
	 /**
      * Método que permite registrar una novedad para el laboratorio
	  * @param titulo: Titulo de la novedad
      * @param fecha: Fecha en la que se registro la novedad
	  * @param responsable: Identificador del correo del usuario
	  * @param detalle: Detalle de la novedad del laboratorio
	  * @param nEquip: Nombre del equipo que tiene la novedad
	  * @param nLab: Nombre del laboratorio que tiene la novedad
	  * @throws EquiposException Errores con la operación
	  */
	 public void registrarNovedadEquipo(String titulo, Date fecha, String resp, String detalle, String nEquip, String nLab) throws EquiposException;
	 
	 /**
      * Método que permite registrar una novedad para el laboratorio
	  * @param titulo: Titulo de la novedad
      * @param fecha: Fecha en la que se registro la novedad
	  * @param responsable: Identificador del correo del usuario
	  * @param detalle: Detalle de la novedad del laboratorio
	  * @param nElem: Nombre del elemento que tiene la novedad
	  * @param nEq: Nombre del equipo que tiene la novedad
	  * @throws EquiposException Errores con la operación
	  */
	 public void registrarNovedadElemento(String titulo, Date fecha, String resp, String detalle, String nEq, String nElem) throws EquiposException;
	 
	 /**
      * Método que permite consultar la novedad de los laboratorios
      * @throws EquiposException Errores con la operación
      * @return lista de novedades del laboratorio
      */
	 public List<Novedad> consultarNovedadLaboratorios() throws EquiposException;
	 
	 /**
      * Método que permite consultar la novedad de los laboratorios
      * @throws EquiposException Errores con la operación
      * @return lista de novedades del equipo
      */
	 public List<Novedad> consultarNovedadEquipos() throws EquiposException;
	 
	 /**
      * Método que permite consultar la novedad de los laboratorios
      * @throws EquiposException Errores con la operación
      * @return lista de novedades del elemento
      */
	 public List<Novedad> consultarNovedadElementos() throws EquiposException;
	
	//LABORATORIO
	 /**
      * Método que permite registrar un laboratorio
      * @param nombre: Nombre que identifica el laboratorio
      * @param idcorreo: Identificador del correo del usuario
      * @throws EquiposException Errores con la operación
     */
	public void registrarLaboratorio(String nombre, String idcorreo ) throws EquiposException;	 
	 
	/**
     * Método que permite consultar los laboratorios
     * @return Lista de laboratorios
     * @throws EquiposException Errores con la operación
     */
	 public List<Laboratorio> consultarLaboratorios() throws EquiposException;

}