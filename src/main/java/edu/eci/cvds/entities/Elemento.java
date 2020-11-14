package edu.eci.cvds.entities;

import java.util.ArrayList;

/**
* Clase que define a un usuario y los atributos con los que cuenta
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public class Elemento {
	
	//Atributos de la clase
	private static final long serialVersionUID = 1L;
	private int id;
	private String tipo;
	private String nombre;
    private boolean disponible;
    private String disponibilidad;
    private boolean dadoDeBaja;
    private ArrayList<Novedad> novedades;

    /**
     *Constructor para la clase elemento
     */
    public Elemento() {}
    
    /**
	 *Constructor para la clase elemento
	 * @param id: Identificador del elemento
	 * @param tipo: Tipo del elemento
	 * @param nombre: Modelo del elemento
	 * @param disponible: Disponibilidad del elemento
 	 */
	public Elemento(int id, String tipo, String nombre, boolean disponible) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.disponible = disponible;
		
	}
	
	/**
	 *Constructor para la clase elemento
	 * @param id: Identificador del elemento
	 * @param tipo: Tipo del elemento
	 * @param nombre: Modelo del elemento
 	 */
	public Elemento(int id, String tipo, String nombre) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.disponible = true;
	}
	
	 /**
     * Método que devuelve el identificador del elemento
     * @return El identificador del elemento
     */
	public int getId() {
		return id;
	}

	/**
     * Método que cambia el identificador del elemento
     * @param El identificador del elemento
     */
	public void setId(int id) {
		this.id = id;
	}
	
	 /**
     * Método que devuelve el tipo del elemento
     * @return El tipo del elemento
     */
	public String getTipo() {
		return tipo;
	}
	
	/**
     * Método que cambia el tipo del elemento
     * @param El tipo del elemento
     */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	 /**
     * Método que devuelve el nombre del elemento
     * @return El nombre del elemento
     */
	public String getNombre() {
		return nombre;
	}
	
	/**
     * Método que cambia el nombre del elemento
     * @param El nombre del elemento
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
     * Método que devuelve la disponibilidad del elemento
     * @param La disponibilidad del elemento
     */
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
     * Método que cambia la disponibilidad del elemento para mostrarlo como Si o No
     * @return La disponibilidad del elemento
     */
	public String getDisponibilidad() {
		if (isDisponible() == true) {
			this.disponibilidad = "Si";
		}
		else {
			this.disponibilidad = "No";
		}
		return disponibilidad;
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
     * Método que devuelve las novedades del elemento
     * @return Novedades del elemento
     */
	public ArrayList<Novedad> getNovedades() {
		return novedades;
	}
	
	/**
	 * Método que cambia las novedades del elemento
	 * @param Novedades del elemento
	 */
	public void setNovedades(ArrayList<Novedad> novedades) {
		this.novedades = novedades;
	}

	/**
	 * Método que permite mostrar la salida como string
	 * @return Los atributos relacionados del equipo
	 */
	@Override
	public String toString() {
		return "Elemento {id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", disponible=" + disponible
				+ ", dadoDeBaja=" + dadoDeBaja + ", novedades=" + novedades + "}";
	}
	
	
}
