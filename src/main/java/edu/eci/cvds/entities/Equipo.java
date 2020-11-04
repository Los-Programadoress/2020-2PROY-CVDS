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
    private String marca;
    private boolean disponible;
    private Usuario usuario;
    private ArrayList<Elemento> elementos;
    
    /**
     *Constructor para la clase equipo
     */
    public Equipo() {}
    
	/**
     *Constructor para la clase usuario
     * @param numero: Número que identifica el equipo
     * @param marca: Marca del equipo
     * @param disponible: Disponibilidad del equipo
     * @param usuario: Usuario que registra el equipo
     * @param elementos: Lista de elementos que tiene el equipo
     */
    public Equipo(int numero, String marca, boolean disponible, Usuario usuario, ArrayList<Elemento> elementos) {
		super();
		this.numero = numero;
		this.marca = marca;
		this.disponible = disponible;
		this.usuario = usuario;
		this.elementos = elementos;
	}
    
    /**
     *Constructor para la clase usuario
     * @param numero: Número que identifica el equipo
     * @param marca: Marca del equipo
     * @param usuario: Usuario que registra el equipo
     */
    public Equipo(int numero, String marca, Usuario usuario) {
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
     * @param El número que identifica el equipo
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
	 * @param La marca del equipo
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
	 * @param La disponibilidad del equipo
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
    * Método que permite mostrar la salida como string
    * @return Los atributos relacionados del equipo
    */
	@Override
	public String toString() {
		return "Equipo {numero: " + numero + ", marca: " + marca + ", disponible: " + disponible + ", usuario:" + usuario + ", elementos:" + elementos + "}";
	}
}