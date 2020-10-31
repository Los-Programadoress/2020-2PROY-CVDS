package edu.eci.cvds.security;

import edu.eci.cvds.services.EquiposException;

/**
 * Inicio de Sesión
 */
public interface InicioSesion {
    public void login(String correo,String password) throws EquiposException;
    public boolean isLogged();
}