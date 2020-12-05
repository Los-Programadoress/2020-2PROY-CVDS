package edu.eci.cvds.entities;

public class ReporteElementoDTO {
	private int id;
	private String nombre;
	private String tipo;
	private boolean disponible;
	private String disponibilidad;
	private boolean dadoDeBaja;
	private String bajado;
	private int equipo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isDisponible() {
		return disponible;
	}
	/**
     * Método que cambia la disponibilidad del elemento
     * @param La disponibilidad del elemento
     */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	/**
     * Método que cambia el dado de baja del equipo para mostrarlo como Si o No
     * @return El estado dado de baja del equipo
     */
	public String getDisponibilidad() {
		if (isDisponible()) {
			this.disponibilidad = "Si";
		}
		else {
			this.disponibilidad = "No";
		}
		return disponibilidad;
	}
	
	/**
     * Método que cambia la disponibilidad del elemento
     * @param La disponibilidad del elemento
     */
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	/**
     * Método que devuelve si el elemento es dado de baja
     * @return Si el elemento esta o no dado de baja
     */
	public boolean isDadoDeBaja() {
		return dadoDeBaja;
	}
	
	/**
	 * Método que cambia si el elemento es dado de baja
	 * @param Estado del elemento
	 */
	public void setDadoDeBaja(boolean dadoDeBaja) {
		this.dadoDeBaja = dadoDeBaja;
	}
	/**
     * Método que cambia el dado de baja del equipo para mostrarlo como Si o No
     * @return El estado dado de baja del equipo
     */
	public String getBajado() {
		if (isDadoDeBaja()) {
			this.bajado = "Si";
		}
		else {
			this.bajado = "No";
		}
		return bajado;
	}
	
	/**
     * Método que cambia el id del equipo
     * @return El estado dado de baja del equipo
     */
	public int getEquipo() {
		return equipo;
	}
	
	/**
	 * Método que cambia el id del equipo
	 * @param id del equipo
	 */
	public void setEquipo(int equipo) {
		this.equipo = equipo;
	}

}
