package edu.eci.cvds.persistence.mybatisimpl.mappers;


import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.persistence.PersistenceException;

public interface NovedadMapper {
	
	/**
     * Método que permite registrar una novedad para el laboratorio
	 * @param titulo: Titulo de la novedad
	 * @param fecha: Fecha en la que se registro la novedad
	 * @param responsable: Identificador del correo del usuario
	 * @param detalle: Detalle de la novedad del laboratorio
	 * @param nLab: Nombre del laboratorio que tiene la novedad
     */
	 public void registrarNovedadLaboratorio(@Param("titulo")String titulo, @Param("fecha")Date fecha, @Param("resp")String resp, @Param("detalle")String detalle, @Param("nLab")String nLab);
	 
	 /**
      * Método que permite registrar una novedad para el laboratorio
	  * @param titulo: Titulo de la novedad
      * @param fecha: Fecha en la que se registro la novedad
	  * @param responsable: Identificador del correo del usuario
	  * @param detalle: Detalle de la novedad del laboratorio
	  * @param nEquip: Nombre del equipo que tiene la novedad
	  * @param nLab: Nombre del laboratorio que tiene la novedad
	  */
	 public void registrarNovedadEquipo(@Param("titulo")String titulo, @Param("fecha")Date fecha, @Param("resp")String resp, @Param("detalle")String detalle, @Param("nEquip")String nEquip, @Param("nLab")String nLab); 
	 
	 /**
      * Método que permite registrar una novedad para el laboratorio
	  * @param titulo: Titulo de la novedad
      * @param fecha: Fecha en la que se registro la novedad
	  * @param responsable: Identificador del correo del usuario
	  * @param detalle: Detalle de la novedad del laboratorio
	  * @param nElem: Nombre del elemento que tiene la novedad
	  * @param nEq: Nombre del equipo que tiene la novedad
	  */
	 public void registrarNovedadElemento(@Param("titulo")String titulo, @Param("fecha")Date fecha, @Param("resp")String resp, @Param("detalle")String detalle, @Param("nEq") String nEq, @Param("nElem")String nElem);
	 
	 /**
      * Método que permite consultar la novedad de los laboratorios
      * @return lista de novedades del laboratorio
      */
	 public List<Novedad> consultarNovedadLaboratorios(); 
	 
	 /**
      * Método que permite consultar la novedad de los laboratorios
      * @return lista de novedades del equipo
      */
	 public List<Novedad> consultarNovedadEquipos(); 
	 
	 /**
      * Método que permite consultar la novedad de los laboratorios
      * @return lista de novedades del elemento
      */
	 public List<Novedad> consultarNovedadElementos(); 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
