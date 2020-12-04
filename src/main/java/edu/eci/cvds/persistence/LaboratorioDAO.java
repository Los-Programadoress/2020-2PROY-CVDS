package edu.eci.cvds.persistence;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;

/**
* Interface que permite acceder a datos
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public interface LaboratorioDAO {
	
	/**
     * Método que permite registrar un laboratorio
     * @param nombre: Nombre que identifica el laboratorio
     * @param idcorreo: Identificador del correo del usuario
     * @param fechacreacion: Fecha de creación del laboratorio
     * @throws PersistenceException Errores con la base de datos
     */
	 public void registrarLaboratorio(String nombre, String idcorreo, Date fechacreacion) throws PersistenceException;
	 
	/**
     * Método que permite consultar los laboratorios
     * @return Lista de laboratorios
     * @throws PersistenceException Errores con la base de datos
     */
	 public List<Laboratorio> consultarLaboratorios() throws PersistenceException;
	 
	 /**
     * Método que permite consultar los laboratorios no cerrados
     * @return Lista de laboratorios no cerrados
     * @throws PersistenceException Errores con la base de datos
     */
	 public List<Laboratorio> consultarLaboratoriosNoCerrados() throws PersistenceException;
	 
	 /**
	  * Método que permite cerrar un laboratorio
	  * @param nombreLab: Nombre del laboratorio que va a cerrarse
	  * @param fechafin: Fecha de cierre del laboratorio
	  */
	 public void cerrarLaboratorio(String nombreLab, Date fechafin) throws PersistenceException;
	 
	 /**
	  * Método que permite contar cuantos equipos tiene un laboratorio
	  * @param nombreLab: Nombre del laboratorio
	  */
	 public int cantidadEquiposLab(String nombreLab) throws PersistenceException;
	 
	 /**
	  * Método que permite contar consultar el nombre de los equipos que tiene un laboratorio
	  * @return lista de de los nombres de los equipos
	  */
	 public List<Equipo> nombreEquiposLab(String nombreLab) throws PersistenceException;
}
