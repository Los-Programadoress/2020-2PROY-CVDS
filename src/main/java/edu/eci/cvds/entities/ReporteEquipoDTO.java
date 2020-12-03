package edu.eci.cvds.entities;

public class ReporteEquipoDTO {
	private int id;
	private boolean dadoDeBaja;
	private String laboratorio;
	private String nombre;
	private String bajado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isEstado() {
		return dadoDeBaja;
	}
	public void setEstado(boolean estado) {
		this.dadoDeBaja = estado;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
     * Método que cambia el dado de baja del equipo para mostrarlo como Si o No
     * @return El estado dado de baja del equipo
     */
	public String getBajado() {
		if (isEstado()) {
			this.bajado = "Si";
		}
		else {
			this.bajado = "No";
		}
		return bajado;
	}
	public void setBajado(String bajado) {
		this.bajado = bajado;
	}
	
}
