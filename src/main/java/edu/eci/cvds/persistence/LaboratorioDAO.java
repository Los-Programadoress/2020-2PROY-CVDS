package edu.eci.cvds.persistence;

import java.util.List;

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
     * @throws PersistenceException Errores con la base de datos
     */
	 public void registrarLaboratorio(String nombre, String idcorreo ) throws PersistenceException;
	 
	/**
     * Método que permite consultar los laboratorios
     * @return Lista de laboratorios
     * @throws PersistenceException Errores con la base de datos
     */
	 public List<Laboratorio> consultarLaboratorios() throws PersistenceException;

}
