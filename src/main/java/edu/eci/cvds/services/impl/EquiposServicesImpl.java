package edu.eci.cvds.services.impl;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.EquipoDAO;
import edu.eci.cvds.persistence.LaboratorioDAO;
import edu.eci.cvds.persistence.NovedadDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.services.EquiposException;
import edu.eci.cvds.services.EquiposServices;

/**
* Clase que cuenta con los servicios
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public class EquiposServicesImpl implements EquiposServices{
	
	static final ArrayList<Elemento> elSelected = new ArrayList<>();

	@Inject
    UsuarioDAO usuarioDAO;
	
	@Inject
	EquipoDAO equipoDAO;
	
	@Inject
	ElementoDAO elementoDAO;
	
	@Inject
	NovedadDAO novedadDAO;
	
	@Inject
	LaboratorioDAO laboratorioDAO;
	
	//USUARIO
	/**
      * Método que permite consultar a un usuario 
      * @param idCorreo: Identificador de correo del usuario
      * @param contrasena: Contraseña con la que cuenta el usuario
      * @throws EquiposException Errores con la operación
      * @return Usuario consultado
     */
     @Override
     public Usuario consultarUsuario(String idCorreo) throws EquiposException {
    	 try {
    		 return usuarioDAO.consultarUsuario(idCorreo);
    	 }
    	 catch (PersistenceException ex) {
    		 throw new EquiposException("Error al consultar el usuario" + ex.getLocalizedMessage(), ex);
    	 }
     }
     
     /**
      * Método que permite registrar a un usuario 
      * @param usuario: Usuario a registrar
      * @throws EquiposException Errores con la operación
      */
 	 @Override
     public void registrarUsuario(Usuario usuario) throws EquiposException {
 		try {
 			usuarioDAO.registrarUsuario(usuario);
 		}
 		catch (PersistenceException ex) {
 			throw new EquiposException("Error al registrar el usuario" + ex.getLocalizedMessage(), ex);
 		}
 	 }
    
 	//EQUIPO
     /**
      * Método que permite consultar los equipos
      * @throws EquiposException Errores con la operación
      * @return lista de equipos consultados
      */
 	 @Override
 	 public  List<Equipo> consultarEquipos() throws EquiposException{
 		try{
 			return equipoDAO.consultarEquipos();
 		}
 		catch(PersistenceException e){
 	        throw new EquiposException("Error al consultar los equipos",e);            
 	    }
 	 }
 	 
 	 /**
      * Método que permite consultar un equipo
      * @param numero: Número que identifica el equipo
      * @throws EquiposException Errores con la operación
      * @return Equipo consultado
      */
 	@Override
 	 public Equipo consultarEquipo(int nequipo) throws EquiposException{
 		try{
 			return equipoDAO.consultarEquipo(nequipo);
 		}
 		catch(PersistenceException e){
 	        throw new EquiposException("Error al consultar el equipo",e);            
 	    }
 	 }
     
 	 //FALTA REGISTRAR EQUIPO
 	
 	/**
     * Método que permite registrar consultar los elementos de un equipo 
     * @param nequipo: Número que identifica el equipo
     * @throws EquiposException Errores con la operación
     * @return lista de elementos del equipo consultados
     */
	@Override
	 public List<Elemento> consultarElementosEquipo(int nequipo) throws EquiposException{
		try{
			return equipoDAO.consultarElementosEquipo(nequipo);
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al consultar elementos del equipo",e);            
		}
	 }
	
	/**
	 * Método que permite la asociacion de un 
	 * @param nLab: Nombre del laboratorio
	 * @param nome: Nombre del equipo
	 * @throws EquiposException Errores con la operación
	*/
	@Override
	public void asociacionEquipo(String nLab, String nome) throws EquiposException{
		try {
			System.out.println("EntroEquipoServiceImpl");
			equipoDAO.desasociarEquipo(true,nome);
			System.out.println("EntroEquipoServiceImpl2");
			equipoDAO.asociarEquipo(nLab,nome);
		}catch(PersistenceException e){  
 			throw new EquiposException("Error al asociar el equipo: ",e);  
		}	
	}
	  
	  /**
       * Método que permite cambiar el estado de dar de baja a un elemento
	   * @param dBaja: Cambiar estado de baja al elemento
       * @param eId: Identificador del elemento
       * @throws EquiposException Errores con la operación
      */
     @Override
 	 public void registrarEquipo(String marca, String idcorreo) throws EquiposException {
 		try {
 			equipoDAO.registrarEquipo(marca, idcorreo);
 			List<Equipo> equipos = consultarEquipos();

 		    //antes de registrar elementos
 		    Equipo equipoRegistrado = equipos.get(equipos.size()-1);
 		    //asociar elementos
 		    List<Elemento> elementos = getElSelected();
 		    
 		    for(Elemento e: elementos) {
 		    	asociarElemento(equipoRegistrado.getNumero(),e.getId());
 		    }
 		    EquiposServicesImpl.elSelected.clear();
 		}
 		catch (PersistenceException ex) {
 			throw new EquiposException("Error al registrar el equipo" + ex.getLocalizedMessage(), ex);
   	 	}
 	 }
     
	  public void cambiarBajaEquipo(boolean dBaja,int eId) throws EquiposException{
		try{
			equipoDAO.cambiarBajaEquipo(dBaja,eId);
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al cambiar baja del equipo",e);            
		} 
	  }
	
	//ELEMENTO 	 
     /**
      * Método que permite registrar elemento a un equipo
 	  * @param tipo: Tipo del elemento
 	  * @param nombre: Nombre del elemento
 	  * @param nequipo: Número de equipo al que pertenece el elemento
 	  * @throws EquiposException Errores con la operación
      */
     @Override
 	 public void registrarElementoEquipo(String tipo, String nombre, int nequipo) throws EquiposException{
    	try {
   		 elementoDAO.registrarElementoEquipo(tipo,nombre,nequipo);
 		}
 		catch (PersistenceException ex) {
 			throw new EquiposException("Error al registrar elemento del equipo" + ex.getLocalizedMessage(), ex);
   	 	}
     }
	
	/**
     * Método que permite registrar un elemento
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del elemento
	 * @throws EquiposException Errores con la operación
     */
	@Override
	 public void registrarElemento(String tipo, String nombre) throws EquiposException{
		try{
			elementoDAO.registrarElemento(tipo, nombre);
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al registrar el elemento",e);            
		}
	}
	
	/**
 	 * Método que permite asociar un elemento a un equipo
 	 * @param nume: Identificador del numero
 	 * @param numElemento: Identificador del elemento
 	 * @throws EquiposException Errores con la operación
 	*/
	@Override
	public void asociarElemento(int nume, int numElemento) throws EquiposException{
		try{
			elementoDAO.asociarElemento(nume, numElemento);
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al asociar el elemento",e);            
		}
	}

	/**
     * Método que permite consultar los elementos existentes
     * @throws EquiposException Errores con la operación
     * @return lista de elementos consultados
     */
	@Override
	public List<Elemento> consultarElementos() throws EquiposException{
		try{
			return elementoDAO.consultarElementos();
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al consultar elementos",e);            
		}
	}
	
 	/**
     * Método que permite consultar los elementos de un tipo.
     * @param tipo El tipo de elemento
     * @throws EquiposException Errores con la operación
     * @return lista de elementos del tipo consultados
     */
	@Override
	public List<Elemento> consultarElemento(String tipo) throws EquiposException {
		try{
			return elementoDAO.consultarElemento(tipo);
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al consultar elementos de tipo: "+tipo,e);            
		}
	}
	
	/**
     * Método que permite saber si es un tipo válido
     * @param tipo: Tipo del elemento
     * @throws EquiposException Errores con la operación
     * @return si es un elemento válido
     */
	@Override
	public boolean esTipoValido(String tipo) throws EquiposException {
		return elementoDAO.esTipoValido(tipo);
	}
	
	/**
	 * Método que permite desasociar un elemento
	 * @param disponible: Permite identificar la disponibilidad del elemento
	 * @param nume: Identificador del equipo
	 * @param tipo: Tipo del elemento
	 * @throws EquiposException Errores con la operación
	*/
	@Override
	public void asociacionElemento(int id,int numero,String tipo) throws EquiposException{
		try {
			elementoDAO.desasociarElemento(true, numero, tipo);
			elementoDAO.asociarElemento(numero, id);
		}catch(PersistenceException e){  
 			throw new EquiposException("Error al asociar un elemento: ",e);  
		}	
	}
	
	/**
	* Método que retorna el conjunto de elementos seleccionados
	* @return elSelected Lista de elementos seleccionados
	*/
	@Override
	public ArrayList<Elemento> getElSelected() {
		return elSelected;
	}
	
	/**
	* Método que agrega elementos a la lista de seleccionados
	* @param elementoSelec: Elemento seleccionado
	*/
	@Override
	public void add(Elemento elementoSelec) {
		boolean exist = false;
		for(Elemento e : elSelected) {
			if (e.getTipo().equals(elementoSelec.getTipo())) {
				exist = true;
				break;
			}
		}
		if (elSelected.size() <= 3 && !exist){
			EquiposServicesImpl.elSelected.add(elementoSelec);
		}
	}
	
	
	/**
     * Método que permite cambiar el estado de dar de baja a un elemento
     * @param dBaja: Cambiar estado de baja al elemento
     * @param eId: Identificador del elemento
     * @throws EquiposException Errores con la operación
     */
	@Override
	public void cambiarBajaElemento(boolean dBaja,int eId) throws EquiposException{
		try{
			elementoDAO.cambiarBajaElemento(dBaja,eId);
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al cambiar baja del elemento",e);            
		}
	}
	
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
	 public void registrarNovedadLaboratorio(String titulo, Date fecha, String resp, String detalle, String nLab) throws EquiposException{
		try{
			novedadDAO.registrarNovedadLaboratorio(titulo, fecha, resp, detalle, nLab);
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al registrar novedad del laboratorio: ",e);            
		} 
	 }
	
	/**
     * Método que permite registrar una novedad para el laboratorio
     * @param titulo: Titulo de la novedad
     * @param fecha: Fecha en la que se registro la novedad
     * @param responsable: Identificador del correo del usuario
     * @param detalle: Detalle de la novedad del laboratorio
     * @param nEquip: Número del equipo que tiene la novedad
     * @throws EquiposException Errores con la operación
     */
	public void registrarNovedadEquipo(String titulo, Date fecha, String resp, String detalle, String nEquip) throws EquiposException{
		try{
			novedadDAO.registrarNovedadEquipo(titulo, fecha, resp, detalle, nEquip);
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al registrar novedad del equipo: ",e);            
		}
	}
	
	/**
     * Método que permite registrar una novedad para el laboratorio
	 * @param titulo: Titulo de la novedad
     * @param fecha: Fecha en la que se registro la novedad
	 * @param responsable: Identificador del correo del usuario
	 * @param detalle: Detalle de la novedad del laboratorio
	 * @param idElem: Identificador del elemento que tiene la novedad
	 * @throws EquiposException Errores con la operación
	 */
	public void registrarNovedadElemento(String titulo, Date fecha, String resp, String detalle, String nElem) throws EquiposException{
		try{
			novedadDAO.registrarNovedadElemento(titulo, fecha, resp, detalle, nElem);
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al registrar novedad del elemento: ",e);            
		}
	}
	
	/**
     * Método que permite consultar la novedad de los laboratorios
     * @throws EquiposException Errores con la operación
     * @return lista de novedades del laboratorio
     */
	public List<Novedad> consultarNovedadLaboratorios() throws EquiposException{
		try{
			return novedadDAO.consultarNovedadLaboratorios();
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al consultar las novedades de los laboratorios: ",e);            
		}
	}
	
	/**
     * Método que permite consultar la novedad de los laboratorios
     * @throws EquiposException Errores con la operación
     * @return lista de novedades del equipo
     */
	 public List<Novedad> consultarNovedadEquipos() throws EquiposException{
		 try{
			return novedadDAO.consultarNovedadEquipos();
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al consultar las novedades de los equipos: ",e);            
		} 
	 }
	 
	 /**
      * Método que permite consultar la novedad de los laboratorios
      * @throws EquiposException Errores con la operación
      * @return lista de novedades del elemento
      */
	 public List<Novedad> consultarNovedadElementos() throws EquiposException{
		 try{
			return novedadDAO.consultarNovedadElementos();
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al consultar las novedades de los elementos: ",e);            
		}  
	 }
	
	//LABORATORIO 
	 /**
      * Método que permite registrar un laboratorio
      * @param nombre: Nombre que identifica el laboratorio
      * @param idcorreo: Identificador del correo del usuario
      * @throws EquiposException Errores con la operación
      */
	 @Override
	 public void registrarLaboratorio(String nombre, String idcorreo) throws EquiposException{ 
    	try{
    		System.out.println("Service");
    		System.out.println(nombre);
    		System.out.println(idcorreo);
    		laboratorioDAO.registrarLaboratorio(nombre, idcorreo);
		}
		catch(PersistenceException e){
	        throw new EquiposException("Error al registrar el laboratorio",e);            
	    }
    }
    
	/**
	 * Método que permite consultar los laboratorios
	 * @return Lista de laboratorios
	 * @throws EquiposException Errores con la operación
     */
	@Override
	public List<Laboratorio> consultarLaboratorios() throws EquiposException{
		try{
			return laboratorioDAO.consultarLaboratorios();
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al consultar los laboratorios",e);            
	    }
	}
}
