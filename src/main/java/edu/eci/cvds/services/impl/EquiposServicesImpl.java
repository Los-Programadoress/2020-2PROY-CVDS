package edu.eci.cvds.services.impl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.EquipoDAO;
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
	
	@Inject
    UsuarioDAO usuarioDAO;
	
	@Inject
	EquipoDAO equipoDAO;
	
	@Inject
	ElementoDAO elementoDAO;
	
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
     
     /**
      * Método que permite registrar un equipo 
      * @param marca: Marca del equipo
      * @param idCorreo: Identificador del usuario.
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

 		    List<Elemento> elementos = consultarElementos();
 		 
 		    asociarElemento(equipoRegistrado.getNumero(),elementos.size());
 		    asociarElemento(equipoRegistrado.getNumero(),elementos.size()-1);
 		    asociarElemento(equipoRegistrado.getNumero(),elementos.size()-2);
 		    asociarElemento(equipoRegistrado.getNumero(),elementos.size()-3);
 		}
 		catch (PersistenceException ex) {
 			throw new EquiposException("Error al registrar el equipo" + ex.getLocalizedMessage(), ex);
   	 	}
 	 }
     
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
 	* Método que permite registrar un elemento
 	* @return lista de elementos consultados
 	*/
 	public List<Elemento> consultarElementoDisponibles() throws EquiposException{
 		try{
			return elementoDAO.consultarElementosDisponibles();
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al consultar elementos disponibles: ",e);            
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
     * Método que permite saber los elementos del ultimo Equipo
     * @throws EquiposException Errores con la operación
     * @return Lista de elementos del equipo consultado
     */
	@Override
	public List<Elemento> consultarElementosUltimoEquipo() throws EquiposException{
 		try{
 			List<Equipo> equipos = consultarEquipos();
		    Equipo equipoRegistrado = equipos.get(equipos.size()-1);
		    int equiponum = equipoRegistrado.getNumero();
 			return equipoDAO.consultarElementosEquipo(equiponum);
 		}catch(PersistenceException e){  
 			throw new EquiposException("Error al consultar elementos del equipo: ",e);  
 	    }
 	}
	
	
	/**
	* Método que permite desasociar un elemento
	* @param disponible: Permite identificar la disponibilidad del elemento
	* @param nume: Identificador del equipo
	* @param tipo: Tipo del elemento
	* @throws EquiposException Errores con la operación
	*/
	public void asociacionElemento(int id,int numero,String tipo) throws EquiposException{
		try {
			elementoDAO.desasociarElemento(true, numero, tipo);
			elementoDAO.asociarElemento(numero, id);
		}catch(PersistenceException e){  
 			throw new EquiposException("Error al asociar un elemento: ",e);  
		}	
	}

}
