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
     * @param numero: Número que identifica el equipo
     * @param marca: Marca del equipo
     * @param usuario: Usuario que registra el equipo
     */
	 public void registrarEquipo(@Param("idnum")int numero, @Param("marca") String marca, @Param("uidcorreo") String idCorreo);
	 
	 /**
     * Método que permite registrar consultar los elementos de un equipo 
     * @param nequipo: Número que identifica el equipo
     * @return lista de elementos del equipo consultados
     */
	 public List<Elemento> consultarElementosEquipo(@Param("nequipo") int nequipo);
}
