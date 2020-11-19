package edu.eci.cvds.persistence.mybatisimpl;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.persistence.NovedadDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.LaboratorioMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.NovedadMapper;

public class MyBATISNovedadDAO implements NovedadDAO {
	
	@Inject
	private NovedadMapper novedadMapper;
	
	/**
     * Método que permite registrar una novedad para el laboratorio
	 * @param titulo: Titulo de la novedad
	 * @param fecha: Fecha en la que se registro la novedad
	 * @param responsable: Identificador del correo del usuario
	 * @param detalle: Detalle de la novedad del laboratorio
	 * @param nLab: Nombre del laboratorio que tiene la novedad
	 * @throws PersistenceException Errores con la base de datos
     */
	 public void registrarNovedadLaboratorio(String titulo, Date fecha, String resp, String detalle, String nLab) throws PersistenceException{
	    	try{
	    		novedadMapper.registrarNovedadLaboratorio(titulo, fecha, resp, detalle, nLab);
			}
			catch(Exception e){
		        throw new PersistenceException("Error al registrar novedad del laboratorio",e);            
		    }
	    }
	 
	 /**
      * Método que permite registrar una novedad para el laboratorio
	  * @param titulo: Titulo de la novedad
      * @param fecha: Fecha en la que se registro la novedad
	  * @param responsable: Identificador del correo del usuario
	  * @param detalle: Detalle de la novedad del laboratorio
	  * @param nEquip: Número del equipo que tiene la novedad
	  * @throws PersistenceException Errores con la base de datos
	  */
	 public void registrarNovedadEquipo(String titulo, Date fecha, String resp, String detalle, int nEquip) throws PersistenceException{
		 try{
	    	novedadMapper.registrarNovedadEquipo(titulo, fecha, resp, detalle, nEquip);
		}
		catch(Exception e){
		    throw new PersistenceException("Error al registrar novedad del equipo",e);            
	    }
	 }
	 
	 /**
      * Método que permite registrar una novedad para el laboratorio
	  * @param titulo: Titulo de la novedad
      * @param fecha: Fecha en la que se registro la novedad
	  * @param responsable: Identificador del correo del usuario
	  * @param detalle: Detalle de la novedad del laboratorio
	  * @param idElem: Identificador del elemento que tiene la novedad
	  * @throws PersistenceException Errores con la base de datos
	  */
	 public void registrarNovedadElemento(String titulo, Date fecha, String resp, String detalle, int idElem) throws PersistenceException{
		 try{
	    	novedadMapper.registrarNovedadElemento(titulo, fecha, resp, detalle, idElem);
		}
		catch(Exception e){
	        throw new PersistenceException("Error al registrar novedad del elemento",e);            
	    }
	 }
	 
	 /**
      * Método que permite consultar la novedad de los laboratorios
      * @throws PersistenceException Errores con la base de datos
      * @return lista de novedades del laboratorio
      */
	 public List<Novedad> consultarNovedadLaboratorios() throws PersistenceException{
		 try{
	   		return novedadMapper.consultarNovedadLaboratorios();
		}
		catch(Exception e){
	        throw new PersistenceException("Error al consultar las novedades de los laboratorios",e);            
	    } 
	 }
	 
	 /**
      * Método que permite consultar la novedad de los laboratorios
      * @throws PersistenceException Errores con la base de datos
      * @return lista de novedades del equipo
      */
	 public List<Novedad> consultarNovedadEquipos() throws PersistenceException{
		 try{
		   	return novedadMapper.consultarNovedadEquipos();
		}
		catch(Exception e){
	        throw new PersistenceException("Error al consultar las novedades de los equipos",e);            
	    } 
	 }
	 
	 /**
      * Método que permite consultar la novedad de los laboratorios
      * @throws PersistenceException Errores con la base de datos
      * @return lista de novedades del elemento
      */
	 public List<Novedad> consultarNovedadElementos() throws PersistenceException{
		 try{
			 return novedadMapper.consultarNovedadElementos();
		}
		catch(Exception e){
	        throw new PersistenceException("Error al consultar las novedades de los elementos",e);            
	    }  
	 }
}
