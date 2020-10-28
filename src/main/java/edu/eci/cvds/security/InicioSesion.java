package edu.eci.cvds.security;

import edu.eci.cvds.services.EquiposException;

public interface InicioSesion {
    public void login(String correo , String password) throws EquiposException;
    public void logout();
    public boolean isLogged();
}