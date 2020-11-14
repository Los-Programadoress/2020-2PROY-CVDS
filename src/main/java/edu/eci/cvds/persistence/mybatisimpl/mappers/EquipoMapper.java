package edu.eci.cvds.persistence.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.persistence.PersistenceException;

public interface EquipoMapper {
	
	 /**
      * Método que permite consultar los equipos
      * @return lista de equipos consultados
      */
	 public List<Equipo> consultarEquipos();
	 
	 /**
      * Método que permite consultar un equipo
      * @param numero: Número que identifica el equipo
      * @return Equipo consultado
      */
	 public Equipo consultarEquipo(@Param("nequipo") int nequipo);
	 
	/**
      * Método que permite registrar un equipo 
	  * @param disponible 
      * @param numero: Número que identifica el equipo
      * @param marca: Marca del equipo
      * @param idcorreo: Identificador del correo del usuario
      */
	 public void registrarEquipo(@Param("marca")String marca, @Param("disponible")boolean disponible, @Param("uidcorreo")String idCorreo);
	 
	 /**
      * Método que permite registrar consultar los elementos de un equipo 
      * @param nequipo: Número que identifica el equipo
      * @return lista de elementos del equipo consultados
      */
	 public List<Elemento> consultarElementosEquipo(@Param("nequipo")int nequipo);
	 
	 /**
	  * Método que permite asociar un equipo a un laboratorio
 	  * @param nLab: Número del laboratorio
      * @param nume: Identificador del equipo
   	  */
	public void asociarEquipo(@Param("nLab")String nLab, @Param("nume")int nume); 
	
	/**
	 * Método que permite desasociar un equipo a un laboratorio
	 * @param disponible: Permite identificar la disponibilidad del elemento
	 * @param nLab: Número del laboratorio
	 */
    public void desasociarEquipo(@Param("disponible")boolean disponible, @Param("nLab") String nLab);
    
    /**
     * Método que permite cambiar el estado de dar de baja a un elemento
     * @param dBaja: Cambiar estado de baja al elemento
     * @param eId: Identificador del elemento
     */
	public void cambiarBajaEquipo(@Param("dBaja")boolean dBaja, @Param("eId") int eId);
}
