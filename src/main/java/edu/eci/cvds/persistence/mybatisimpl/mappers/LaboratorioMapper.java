package edu.eci.cvds.persistence.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.persistence.PersistenceException;

public interface LaboratorioMapper {
	
	/**
	 * Método que permite registrar un laboratorio
	 * @param nombre: Nombre que identifica el laboratorio
	 * @param idcorre: Identificador del usuario
	 */
    public void registrarLaboratorio(@Param("nombre")String nombre, @Param("idcorreo")String idcorreo);
	
	/**
     * Método que permite consultar los laboratorios
     * @return lista de laboratorios consultados
     */
	public List<Laboratorio> consultarLaboratorios(); 

}
