package edu.eci.cvds.entities;

import java.io.Serializable;

/**
* Esta clase define a un usuario y los atributos con los que cuenta
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public class Usuario implements Serializable{
	
	//Atributos de la clase
	private static final long serialVersionUID = 1L;
	private String idCorreo;
    private String nombre;
    private int rol;
    private String estado;
    private String correo;
    private String contrasena;
    
    //Constructor para la clase usuario
    public Usuario() {}
    
    /**
     *Constructor para la clase usuario
     * @param idCorreo: Identificador de correo del usuario
     * @param nombre: Nombre del usuario
     * @param rol: Rol de permisos con los que cuenta el usuario
     * @param estado: Indica si un usuario esta activo o no
     * @param contrasena: Contraseña con la que cuenta el usuario
     */
    public Usuario(String idCorreo, String nombre, int rol, String estado, String correo, String contrasena) {
    	this.idCorreo = idCorreo;
        this.nombre= nombre;
    	this.rol = rol;
    	this.estado = estado;
    	this.correo = correo;
        this.contrasena = contrasena;
    }
    
    public String getIdCorreo() {
		return idCorreo;
	}

	public void setIdCorreo(String idCorreo) {
		this.idCorreo = idCorreo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
    public String toString() {
        return "Usuario {idCorreo: " + idCorreo + ", nombre: " + nombre + ", rol: " + rol + ", estado: " + estado + ", correo : " + correo + ", contrasena: " + contrasena + "}";
    }
}
