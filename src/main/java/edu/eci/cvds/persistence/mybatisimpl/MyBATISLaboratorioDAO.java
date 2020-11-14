package edu.eci.cvds.persistence.mybatisimpl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.persistence.LaboratorioDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatisimpl.mappers.LaboratorioMapper;

public class MyBATISLaboratorioDAO implements LaboratorioDAO{
	
	@Inject
	private LaboratorioMapper laboratorioMapper;
	
	/**
	 * Método que permite registrar un laboratorio
	 * @param nombre: Nombre que identifica el laboratorio
	 * @param idcorre: Identificador del usuario
	 * @throws PersistenceException Errores con la base de datos
	 */
	@Override
    public void registrarLaboratorio(String nombre, String idcorreo) throws PersistenceException{
    	try{
    		laboratorioMapper.registrarLaboratorio(nombre, idcorreo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
	        throw new PersistenceException("Error al registrar el laboratorio",e);            
	    }
    }
    
    /**
     * Método que permite consultar los laboratorios
     * @throws PersistenceException Errores con la base de datos
     * @return Lista de laboratorios
     */
	@Override
	 public List<Laboratorio> consultarLaboratorios() throws PersistenceException{
		try{
			return laboratorioMapper.consultarLaboratorios();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar los laboratorios",e);            
	    }
	}
}