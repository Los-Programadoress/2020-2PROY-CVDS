package edu.eci.cvds.persistence;

import java.util.List;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;

/**
* Interface que permite acceder a datos
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public interface EquipoDAO {
	
	 /**
      * Método que permite consultar los equipos
      * @throws PersistenceException Errores con la base de datos
      * @return lista de equipos consultados
      */
	 public List<Equipo> consultarEquipos() throws PersistenceException;
	 
	 /**
      * Método que permite consultar un equipo
      * @param numero: Número que identifica el equipo
      * @throws PersistenceException Errores con la base de datos
      * @return Equipo consultado
      */
	 public Equipo consultarEquipo(int nequipo) throws PersistenceException;
	
	 /**
      * Método que permite registrar un equipo 
      * @param nombre: Nombre del equipo
      * @param marca: Marca del equipo
      * @param idcorreo: Identificador del correo del usuario
	  * @throws PersistenceException Errores con la base de datos 
      */
	 public void registrarEquipo(String nombre, String marca, String idcorreo) throws PersistenceException;
	 
	 /**
      * Método que permite registrar consultar los elementos de un equipo 
      * @param nequipo: Número que identifica el equipo
      * @throws PersistenceException Errores con la base de datos
      * @return lista de elementos del equipo consultados
      */
	 public List<Elemento> consultarElementosEquipo(String nequipo) throws PersistenceException;
	 
	 /**
 	  * Método que permite asociar un equipo a un laboratorio
 	  * @param nLab: Nombre del laboratorio
      * @param nome: Nombre del equipo
      * @throws PersistenceException Errores con la base de datos
	  */
	 public void asociarEquipo(String nLab, String nome) throws PersistenceException;
	    
	  /**
	   * Método que permite desasociar un equipo a un laboratorio
	   * @param disponible: Permite identificar la disponibilidad del elemento
	   * @param nome: Nombre del equipo
	   * @throws PersistenceException Errores con la base de datos
	   */
      public void desasociarEquipo(boolean disponible, String nome) throws PersistenceException;
	 
	 
      /**
       * Método que permite cambiar el estado de dar de baja a un equipo
       * @param dBaja: Cambiar estado de baja al equipo
       * @param nome: Nombre del equipo
       * @throws PersistenceException Errores con la base de datos
       */
 	  public void cambiarBajaEquipo(boolean dBaja,String nome) throws PersistenceException;
		 
}
