package edu.eci.cvds.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import edu.eci.cvds.services.EquiposException;

public class InicioSesionShiro implements InicioSesion{
    
    @Override
    public void login(String correo , String password) throws EquiposException{
        try {
            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(correo, password);
            token.setRememberMe(true);
            currentUser.getSession().setAttribute("Correo", correo);
            currentUser.login(token);
        } catch (UnknownAccountException e1) {
            throw new EquiposException("El usuario no está en la base de datos", e1);
        } catch (IncorrectCredentialsException e2) {
            throw new EquiposException("Contraseña incorrecta", e2);
        }
    }
    
    @Override
    public void logout(){
        SecurityUtils.getSubject().logout();
    }

    @Override
    public boolean isLogged(){
        return SecurityUtils.getSubject().isAuthenticated();  
    }
    
}