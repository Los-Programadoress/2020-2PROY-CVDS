package edu.eci.cvds.security;

import edu.eci.cvds.services.EquiposException;

public interface InicioSesion {
    
    public void login(String idCorreo , String password) throws EquiposException;
    public boolean isLogged();
}