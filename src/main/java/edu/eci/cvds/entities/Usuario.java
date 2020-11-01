package edu.eci.cvds.entities;

import java.io.Serializable;

/**
* Clase que define a un usuario y los atributos con los que cuenta
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public class Usuario implements Serializable{
	
    //Atributos de la clase
    private static final long serialVersionUID = 1L;
    private String idCorreo;
    private String nombre;
    private String estado;
    private String correo;
    private String contrasena;
    
    /**
     *Constructor para la clase usuario
     */
    public Usuario() {}
    
    /**
     *Constructor para la clase usuario
     * @param idCorreo: Identificador de correo del usuario
     * @param nombre: Nombre del usuario
     * @param estado: Indica si un usuario esta activo o no
     * @param contrasena: Contraseña con la que cuenta el usuario
     */
    public Usuario(String idCorreo, String nombre, String estado, String correo, String contrasena) {
    	this.idCorreo = idCorreo;
        this.nombre= nombre;
    	this.estado = estado;
    	this.correo = correo;
        this.contrasena = contrasena;
    }
    
    /**
     * Método que devuelve el identificador de correo del usuario
     * @return El identificador de correo del ususario
     */
    public String getIdCorreo() {
    	return idCorreo;
    }

    /**
     * Método que cambia el identificador de correo del usuario
     * @param El identificador de correo del usuario
     */
    public void setIdCorreo(String idCorreo) {
    	this.idCorreo = idCorreo;
     }
	
    /**
     * Método que devuelve el nombre del usuario
     * @return El nombre del usuario
     */
    public String getNombre() {
    	return nombre;
     }

    /**
     * Método que cambia el nombre del usuario
     * @param El nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
     }

    /**
     * Método que devuelve el estado del usuario
     * @return El estado del usuario
     */
    public String getEstado() {
    	return estado;
     }

    /**
     * Método que cambia el estado del usuario
     * @param El estado del usuario
     */
    public void setEstado(String estado) {
    	this.estado = estado;
     }

    /**
     * Método que devuelve el correo del usuario
     * @return El correo del usuario
     */
    public String getCorreo() {
    	return correo;
     }

    /**
     * Método que cambia el correo del usuario
     * @param El correo del usuario
     */
    public void setCorreo(String correo) {
    	this.correo = correo;
     }

    /**
     * Método que devuelve la contraseña del usuario
     * @return El correo del ususario
     */
    public String getContrasena() {
    	return contrasena;
     }

    /**
     * Método que cambia la contraseña del usuario
     * @param El correo del usuario
     */
    public void setContrasena(String contrasena) {
    	this.contrasena = contrasena;
     }

    /**
     * Método que permite mostrar la salida como string
     * @return Los atributos relacionados del usuario
     */
    @Override
    public String toString() {
    	return "Usuario {idCorreo: " + idCorreo + ", nombre: " + nombre + ", estado: " + estado + ", correo : " + correo + ", contrasena: " + contrasena + "}";
     }
}
