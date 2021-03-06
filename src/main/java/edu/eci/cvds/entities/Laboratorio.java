package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;

/**
* Clase que define a un laboratorio y los atributos con los que cuenta
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public class Laboratorio  implements Serializable{

	//Atributos de la clase
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Usuario usuario;
	private boolean estaCerrado;
	private String cerrado;
	private Date fechaCreacion;
	private Date fechaFin;
	private ArrayList<Equipo> equipos;
	private ArrayList<Novedad> novedades;
	
	 /**
	  *Constructor para la clase laboratorio
	  */
    public Laboratorio() {}
    
    /**
     *Constructor para la clase laboratorio
     * @param nombre: Nombre que identifica el laboratorio
     * @param equipos: Lista de equipos que tiene el laboratorio
     */
    public Laboratorio(String nombre, ArrayList<Equipo> equipos, ArrayList<Novedad> novedades) {
		super();
		this.nombre = nombre;
		this.equipos = equipos;
		this.novedades = novedades;
	}
    
	/**
     *Constructor para la clase laboratorio
     * @param nombre: Nombre que identifica el laboratorio
     */
    public Laboratorio(String nombre) {
		super();
		this.nombre = nombre;
	}
    
    /**
     * Método que devuelve el nombre del laboratorio
     * @return El nombre del laboratorio
     */
    public String getNombre() {
		return nombre;
	}
    
    /**
	 * Método que cambia el nombre del laboratorio
	 * @param El nombre del laboratorio
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
     * Método que devuelve el usuario que registro el laboratorio
     * @return El nombre del usuario
     */
	 public Usuario getUsuario() {
		return usuario;
	}
	 
	/**
	 * Método que cambia el usuario que registro el laboratorio
	 * @param El nombre del usuario
  	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
     * Método que devuelve los equipos pertenecientes al laboratorio
     * @return Los equipos del laboratorio
     */
	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}
	
	/**
	 * Método que cambia los laboratorios del equipo
	 * @param Los equipos del laboratorio
	 */
	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	/**
     * Método que devuelve las novedades del laboratorio
     * @return Novedades del laboratorio
     */
	public ArrayList<Novedad> getNovedades() {
		return novedades;
	}
	
	/**
	 * Método que cambia las novedades del laboratorio
	 * @param Novedades del laboratorio
	 */
	public void setNovedades(ArrayList<Novedad> novedades) {
		this.novedades = novedades;
	}
	
	/**
     * Método que devuelve si el laboratorio esta cerrado
     * @return Si el laboratorio esta o no cerrado
     */
	public boolean isEstaCerrado() {
		return estaCerrado;
	}
	
	/**
	 * Método que devuelve el cerrado del laboratorio para mostrarlo como Si o No
	 * @return El estado de cerrado del laboratorio
    */
	public String getCerrado() {
		if (isEstaCerrado()) {
			this.cerrado = "Si";
		}
		else {
			this.cerrado = "No";
		}
		return cerrado;
	}
	
	/**
	 * Método que cambia el estado cerrado del laboratorio
	 * @param Estado del laboratorio
	 */
	public void setEstaCerrado(boolean estaCerrado) {
		this.estaCerrado = estaCerrado;
	}
	
	/**
	 * Método que devuelve la fecha de creación del laboratorio
	 * @return Fecha de creación del laboratorio
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	/**
	 * Método que cambia la fecha de creación del laboratorio
	 * @param Fecha de creación del laboratorio
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	/**
	 * Método que devuelve la fecha fin del laboratorio
	 * @return Fecha de fin del laboratorio
	 */
	public Date getFechaFin() {
		return fechaFin;
	}
	
	/**
	 * Método que cambia la fecha fin del laboratorio
	 * @param Fecha fin del laboratorio
	 */
	public void setFechaFin(Date fechafin) {
		this.fechaFin = fechafin;
	}

	/**
     * Método que permite mostrar la salida como string
     * @return Los atributos relacionados del equipo
     */
	@Override
	public String toString() {
		return "Laboratorio {nombre=" + nombre + ", usuario=" + usuario + ", estaCerrado=" + estaCerrado
				+ ", fechaCreacion=" + fechaCreacion + ", fechafin=" + fechaFin + ", equipos=" + equipos
				+ ", novedades=" + novedades + "}";
	}
}
