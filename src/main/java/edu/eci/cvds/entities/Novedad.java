package edu.eci.cvds.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;


/**
* Clase que define una novedad y los atributos con los que cuenta
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public class Novedad implements Serializable{
	
	//Atributos de la clase
	private static final long serialVersionUID = 1L;
	private int id;
	private String titulo;
	private Date fecha;
	private Usuario responsable;
	private String detalle;
	
	/**
	 *Constructor para la clase novedad
	 */
   public Novedad() {}
   
   /**
    *Constructor para la clase laboratorio
    * @param nombre: Nombre que identifica el laboratorio
    * @param equipos: Lista de equipos que tiene el laboratorio
    */
   public Novedad(int id, String titulo, Date fecha, Usuario responsable, String detalle) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fecha = fecha;
		this.responsable = responsable;
		this.detalle = detalle;
	}
   
   /**
    * Método que devuelve el identificador de la novedad
    * @return El identificador de la novedad
    */
   	public int getId() {
	   return id;
   	}
   
   /**
    * Método que cambia el identificador de la novedad
    * @param El identificador de la novedad
    */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Método que devuelve el titulo de la novedad
	 * @return El identificador de la novedad
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
     * Método que cambia el titulo de la novedad
     * @param El titulo de la novedad
     */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Método que devuelve la fecha de la novedad
	 * @return La fecha de la novedad
	 */
	public Date getFecha() {
		return fecha;
	}
	
	/**
     * Método que cambia la fecha de la novedad
     * @param El titulo de la novedad
     */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Método que devuelve el responsable de la novedad
	 * @return El responsable de la novedad
	 */
	public Usuario getResponsable() {
		return responsable;
	}
	
	/**
     * Método que cambia el responsable de la novedad
     * @param El responsable de la novedad
     */
	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}
	
	/**
	 * Método que devuelve el detalle de la novedad
	 * @return El detalle de la novedad
	 */
	public String getDetalle() {
		return detalle;
	}
	
	/**
     * Método que cambia el detalle de la novedad
     * @param El detalle de la novedad
     */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	/**
     * Método que permite mostrar la salida como string
     * @return Los atributos relacionados del usuario
     */
	@Override
	public String toString() {
		return "Novedad {id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", responsable=" + responsable
				+ ", detalle=" + detalle + "}";
	}
	
	
}
