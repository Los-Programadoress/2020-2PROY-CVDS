package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.ArrayList;
/**
* Clase que define a un usuario y los atributos con los que cuenta
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public class Equipo implements Serializable{
	
	//Atributos de la clase
	private static final long serialVersionUID = 1L;
	private int numero;
	private String nombre;
    private String marca;
    private boolean disponible;
    private Usuario usuario;
    private String disponibilidad;
    private boolean dadoDeBaja;
    private ArrayList<Elemento> elementos;
    private ArrayList<Novedad> novedades;
    
    /**
     *Constructor para la clase equipo
     */
    public Equipo() {}
    
	/**
     *Constructor para la clase quipo
     * @param numero: Número que identifica el equipo
     * @param nombre: Nombre del equipo
     * @param marca: Marca del equipo
     * @param disponible: Disponibilidad del equipo
     * @param usuario: Usuario que registra el equipo
     * @param elementos: Lista de elementos que tiene el equipo
     * @param novedades: Lista de novedades que tiene el equipo
     */
    public Equipo(int numero, String nombre, String marca, boolean disponible, Usuario usuario, ArrayList<Elemento> elementos, ArrayList<Novedad> novedades) {
		super();
		this.numero = numero;
		this.setNombre(nombre);
		this.marca = marca;
		this.disponible = disponible;
		this.usuario = usuario;
		this.elementos = elementos;
		this.novedades = novedades;
	}
    
    /**
     *Constructor para la clase equipo
     * @param numero: Número que identifica el equipo
     * @param nombre: Nombre del equipo
     * @param marca: Marca del equipo
     * @param usuario: Usuario que registra el equipo
     */
    public Equipo(int numero, String nombre, String marca, Usuario usuario) {
  		super();
  		this.numero = numero;
  		this.marca = marca;
  		this.disponible = true;
  		this.usuario = usuario;
  		this.elementos = new ArrayList<>();
  	}
    
    /**
     * Método que devuelve el número que identifica el equipo
     * @return El número que identifica el equipo
     */
	public int getNumero() {
		return numero;
	}

	 /**
     * Método que cambia el número que identifica el equipo
     * @param numero El número que identifica el equipo
     */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
     * Método que devuelve la marca del equipo
     * @return La marca del equipo
     */
	public String getMarca() {
		return marca;
	}

	/**
	 * Método que cambia la marca del equipo
	 * @param marca La marca del equipo
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
     * Método que devuelve la disponibilidad del equipo
     * @return la disponibilidad del equipo
     */
	public boolean isDisponible() {
		return disponible;
	}
	
	/**
	 * Método que cambia la disponibilidad del equipo
	 * @param disponible La disponibilidad del equipo
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	/**
     * Método que devuelve el usuario que registro el equipo
     * @return usuario que registro el equipo
     */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * Método que cambia el usuario que registro el equipo
	 * @param usuario que registro el equipo
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
     * Método que devuelve los elementos del equipo
     * @return usuario que registro el equipo
     */
	public ArrayList<Elemento> getElementos() {
		return elementos;
	}
	
	/**
	 * Método que cambia los elementos del equipo
	 * @param elementos del equipo
	 */
	public void setElementos(ArrayList<Elemento> elementos) {
		this.elementos = elementos;
	}
	
	/**
     * Método que cambia la disponibilidad del equipo para mostrarlo como Si o No
     * @return La disponibilidad del equipo
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
     * Método que devuelve si el equipo es dado de baja
     * @return Si el equipo esta o no dado de baja
     */
    public boolean isDadoDeBaja() {
		return dadoDeBaja;
	}
    
    /**
	 * Método que cambia si el equipo es dado de baja
	 * @param dadoDeBaja Estado del equipo
	 */
	public void setDadoDeBaja(boolean dadoDeBaja) {
		this.dadoDeBaja = dadoDeBaja;
	}
	
	/**
     * Método que devuelve las novedades del equipo
     * @return Novedades del equipo
     */
	public ArrayList<Novedad> getNovedades() {
		return novedades;
	}
	
	/**
	 * Método que cambia las novedades del equipo
	 * @param novedades Novedades del equipo
	 */
	public void setNovedades(ArrayList<Novedad> novedades) {
		this.novedades = novedades;
	}
	
	/**
     * Método que devuelve el nombre del equipo registrado
     * @return nombre del equipo
     */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método que cambia el nombre del equipo
	 * @param Nombre del equipo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
    * Método que permite mostrar la salida como string
    * @return Los atributos relacionados del equipo
    */
	@Override
	public String toString() {
		return "Equipo [numero=" + numero + ", nombre=" + nombre + ", marca=" + marca + ", disponible=" + disponible
				+ ", usuario=" + usuario + ", disponibilidad=" + disponibilidad + ", dadoDeBaja=" + dadoDeBaja
				+ ", elementos=" + elementos + ", novedades=" + novedades + "]";
	}
	
	/**
     * Método que devuelve el nombre del equipo
     * @return Nombre del equipo
     */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Método que cambia el nombre del equipo
	 * @param Nombre del equipo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
