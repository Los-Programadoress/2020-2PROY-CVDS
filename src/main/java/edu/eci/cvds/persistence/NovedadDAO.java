package edu.eci.cvds.persistence;

import java.util.Date;
import java.util.List;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Novedad;

/**
* Interface que permite acceder a datos
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public interface NovedadDAO {
	
	/**
     * Método que permite registrar una novedad para el laboratorio
	 * @param titulo: Titulo de la novedad
	 * @param fecha: Fecha en la que se registro la novedad
	 * @param responsable: Identificador del correo del usuario
	 * @param detalle: Detalle de la novedad del laboratorio
	 * @param nLab: Nombre del laboratorio que tiene la novedad
	 * @throws PersistenceException Errores con la base de datos
     */
	 public void registrarNovedadLaboratorio(String titulo, Date fecha, String resp, String detalle, String nLab) throws PersistenceException;
	 
	 /**
      * Método que permite registrar una novedad para el laboratorio
	  * @param titulo: Titulo de la novedad
      * @param fecha: Fecha en la que se registro la novedad
	  * @param responsable: Identificador del correo del usuario
	  * @param detalle: Detalle de la novedad del laboratorio
	  * @param nEquip: Número del equipo que tiene la novedad
	  * @throws PersistenceException Errores con la base de datos
	  */
	 public void registrarNovedadEquipo(String titulo, Date fecha, String resp, String detalle, int nEquip) throws PersistenceException;
	 
	 /**
      * Método que permite registrar una novedad para el laboratorio
	  * @param titulo: Titulo de la novedad
      * @param fecha: Fecha en la que se registro la novedad
	  * @param responsable: Identificador del correo del usuario
	  * @param detalle: Detalle de la novedad del laboratorio
	  * @param idElem: Identificador del elemento que tiene la novedad
	  * @throws PersistenceException Errores con la base de datos
	  */
	 public void registrarNovedadElemento(String titulo, Date fecha, String resp, String detalle, int idElem) throws PersistenceException;
	 
	 /**
      * Método que permite consultar la novedad de los laboratorios
      * @throws PersistenceException Errores con la base de datos
      * @return lista de novedades del laboratorio
      */
	 public List<Novedad> consultarNovedadLaboratorios() throws PersistenceException;
	 
	 /**
      * Método que permite consultar la novedad de los laboratorios
      * @throws PersistenceException Errores con la base de datos
      * @return lista de novedades del equipo
      */
	 public List<Novedad> consultarNovedadEquipos() throws PersistenceException;
	 
	 /**
      * Método que permite consultar la novedad de los laboratorios
      * @throws PersistenceException Errores con la base de datos
      * @return lista de novedades del elemento
      */
	 public List<Novedad> consultarNovedadElementos() throws PersistenceException;
	 
	 
}
