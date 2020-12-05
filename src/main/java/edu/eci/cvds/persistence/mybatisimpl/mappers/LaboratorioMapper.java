package edu.eci.cvds.persistence.mybatisimpl.mappers;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;

public interface LaboratorioMapper {
	
	/**
	 * Método que permite registrar un laboratorio
	 * @param nombre: Nombre que identifica el laboratorio
	 * @param idcorre: Identificador del usuario
	 * @param fechacreacion: Fecha de creación del laboratorio
	 */
    public void registrarLaboratorio(@Param("nombre")String nombre, @Param("idcorreo")String idcorreo, @Param("fechacreacion")Date fechacreacion);
	
	/**
     * Método que permite consultar los laboratorios
     * @return lista de laboratorios consultados
     */
	public List<Laboratorio> consultarLaboratorios(); 
	
	/**
     * Método que permite consultar los laboratorios no cerrados
     * @return lista de laboratorios no cerrados consultados
     */
	public List<Laboratorio> consultarLaboratoriosNoCerrados(); 

	/**
     * Método que permite cerrar un laboratorio
     * @param nombreLab: Nombre del laboratorio que va a cerrarse
     */
	public void cerrarLaboratorio(@Param("nombreLab")String nombreLab, @Param("fechafin")Date fechafin);
	
	/**
	 * Método que permite contar cuantos equipos tiene un laboratorio
	 * @param nombreLab: Nombre del laboratorio
	 */
	public int cantidadEquiposLab(@Param("nombreLab")String nombreLab);
	
	/**
	 * Método que permite contar consultar el nombre de los equipos que tiene un laboratorio
	 * @return lista de de los nombres de los equipos
	 */
	public List<Equipo> nombreEquiposLab(@Param("nombreLab")String nombreLab);
}
