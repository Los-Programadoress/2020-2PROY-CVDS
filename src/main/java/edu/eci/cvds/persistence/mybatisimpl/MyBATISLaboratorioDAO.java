package edu.eci.cvds.persistence.mybatisimpl;

import java.sql.Date;
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
	 * @param idcorreo: Identificador del usuario
	 * @param fechacreacion: Fecha de creación del laboratorio
	 * @throws PersistenceException Errores con la base de datos
	 */
	@Override
    public void registrarLaboratorio(String nombre, String idcorreo, Date fechacreacion) throws PersistenceException{
    	try{
    		laboratorioMapper.registrarLaboratorio(nombre, idcorreo, fechacreacion );
		}
		catch(Exception e){
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
		catch(Exception e){
			throw new PersistenceException("Error al consultar los laboratorios",e);            
	    }
	}
	
	/**
     * Método que permite cerrar un laboratorio
     * @param nombreLab: Nombre del laboratorio que va a cerrarse
     * @param fechafin: Fecha de cierre del laboratorio
     */
	@Override
	public void cerrarLaboratorio(String nombreLab, Date fechafin) throws PersistenceException{
		try{
			laboratorioMapper.cerrarLaboratorio(nombreLab, fechafin);
		}
		catch(Exception e){
			throw new PersistenceException("Error al cerrar el laboratorio",e);            
	    }
	}
	
	/**
	 * Método que permite contar cuantos equipos tiene un laboratorio
	 * @param nombreLab: Nombre del laboratorio
	 */
	@Override
	 public int cantidadEquiposLab(String nombreLab) throws PersistenceException{
		try{
			return laboratorioMapper.cantidadEquiposLab(nombreLab);
		}
		catch(Exception e){
			throw new PersistenceException("Error al consultar cantidad de equipos",e);            
	    }
	}
}
