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
      * Método que permite consultar los equipos
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
      * @param numero: Número que identifica el equipo
      * @param marca: Marca del equipo
      * @param usuario: Usuario que registra el equipo
      */
     @Override
 	 public void registrarEquipo(int numero, String marca, Usuario usuario) throws EquiposException {
 		try {
   		 equipoDAO.registrarEquipo(numero, marca, usuario);
 		}
 		catch (PersistenceException ex) {
 			throw new EquiposException("Error al registrar el equipo" + ex.getLocalizedMessage(), ex);
   	 	}
 	 }
     
     /**
      * Método que permite registrar elemento a un equipo
      * @param id: Identificador del elemento
 	  * @param tipo: Tipo del elemento
 	  * @param nombre: Nombre del elemento
 	  * @param nequipo: Número de equipo al que pertenece el elemento
      */
     @Override
 	 public void registrarElementoEquipo(int id, String tipo, String nombre, int nequipo) throws EquiposException{
    	try {
   		 elementoDAO.registrarElementoEquipo(id,tipo,nombre,nequipo);
 		}
 		catch (PersistenceException ex) {
 			throw new EquiposException("Error al registrar elemento del equipo" + ex.getLocalizedMessage(), ex);
   	 	}
     }
    	
	/**
     * Método que permite registrar consultar los elementos de un equipo 
     * @param nequipo: Número que identifica el equipo
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
     * @param id: Identificador del elemento
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del elemento
     */
	@Override
	 public void registrarElemento(int id, String tipo, String nombre) throws EquiposException{
		try{
			elementoDAO.registrarElemento(id, tipo, nombre);
		}
		catch(PersistenceException e){
			throw new EquiposException("Error al registrar el elemento",e);            
		}
	}
}
