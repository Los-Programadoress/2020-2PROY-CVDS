package edu.eci.cvds.persistence.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

public interface ElementoMapper {
	/**
     * Método que permite registrar elemento a un equipo 
     * @param id: Identificador del elemento
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del elemento
	 * @param nequipo: Número de equipo al que pertenece el elemento
     */
	 public void registrarElementoEquipo(@Param("id")int id, @Param("tipo") String tipo, @Param("nombre") String nombre,@Param("nequipo") int nequipo);
	 
	/**
     * Método que permite registrar un elemento
     * @param id: Identificador del elemento
	 * @param tipo: Tipo del elemento
	 * @param nombre: Nombre del elemento
     */
	 public void registrarElemento(@Param("id")int id, @Param("tipo") String tipo, @Param("nombre") String nombre);

}
