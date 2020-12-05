package edu.eci.cvds.entities;

import java.sql.Date;

public class ReporteNovedadDTO {
	private int id;
	private String titulo;
	private Date fecha;
	private String responsable;
	private String detalle;
	private String nombreEq;
	private String nombreElem;
	private String nombreLab;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getNombreEq() {
		return nombreEq;
	}
	public void setNombreEq(String nombreEq) {
		this.nombreEq = nombreEq;
	}
	public String getNombreElem() {
		return nombreElem;
	}
	public void setNombreElem(String nombreElem) {
		this.nombreElem = nombreElem;
	}
	public String getNombreLab() {
		return nombreLab;
	}
	public void setNombreLab(String nombreLab) {
		this.nombreLab = nombreLab;
	}
}
