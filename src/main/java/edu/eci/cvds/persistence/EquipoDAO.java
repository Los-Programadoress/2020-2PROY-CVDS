package edu.eci.cvds.persistence;

import java.util.List;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Usuario;

/**
* Interface que permite acceder a datos
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/

public interface EquipoDAO {
	
	 /**
     * Método que permite consultar los equipos
     * @return lista de equipos consultados
     */
	 public List<Equipo> consultarEquipos() throws PersistenceException;
	 
	 /**
     * Método que permite consultar un equipo
     * @param numero: Número que identifica el equipo
     * @return Equipo consultado
     */
	 public Equipo consultarEquipo(int nequipo) throws PersistenceException;
	
	 /**
     * Método que permite registrar un equipo 
     * @param numero: Número que identifica el equipo
     * @param marca: Marca del equipo
     * @param usuario: Usuario que registra el equipo
     */
	 public void registrarEquipo(String marca, Usuario usuario) throws PersistenceException;
	 
	 /**
     * Método que permite registrar consultar los elementos de un equipo 
     * @param nequipo: Número que identifica el equipo
     * @return lista de elementos del equipo consultados
     */
	 public List<Elemento> consultarElementosEquipo(int nequipo) throws PersistenceException;
		 
}
