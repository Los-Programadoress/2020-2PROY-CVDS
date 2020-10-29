package edu.eci.cvds.view;

import java.util.logging.*;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SuppressWarnings("deprecation")
@ManagedBean(name = "InicioSesionBean", eager=true)
@SessionScoped
public class InicioSesionBean {
	private static final Logger log = LoggerFactory.getLogger(InicioSesionBean.class);
	private String urlLogin = "sesion.xhtml";
	private String idCorreo;
    private String password;
	private String message;
	Subject subject;
	
	/**
     * Try and authenticate the user
     */
    public void doLogin() {
    	System.out.println(getidCorreo());
        subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(getidCorreo(), new Sha256Hash(getPassword()).toHex());
        try {
			subject.login(token);
			FacesContext.getCurrentInstance().getExternalContext().redirect(urlLogin);
            
        } catch (UnknownAccountException e1) {
            facesError("Cuenta Desconocida");
            log.error(e1.getMessage(), e1);
        } catch (IncorrectCredentialsException e2) {
            facesError("Contraseña incorrecta");
            log.error(e2.getMessage(), e2);
        } catch (LockedAccountException e3) {
            facesError("Cuenta bloqueada");
            log.error(e3.getMessage(), e3);
        } catch (AuthenticationException | IOException e4) {
            facesError("Error Desconocido: " + e4.getMessage());
            log.error(e4.getMessage(), e4);
        } catch (NullPointerException e5) {
            System.err.println("Nulo");
        } finally {
            token.clear();
        }
    }
	
	public void logOut() throws  IOException{
        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(urlLogin);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(InicioSesionBean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
	}
	
	public boolean isLogged(){
        return SecurityUtils.getSubject().isAuthenticated();  
    }
	
	/**
     * Adds a new SEVERITY_ERROR FacesMessage for the ui
     * @param message Error Message
     */
    private void facesError(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

	public String getidCorreo() {
		return idCorreo;
	}

	public void setidCorreo(String idCorreo) {
		this.idCorreo = idCorreo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getUrl() {
        return urlLogin;
    }
	public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, "PrimeFaces Rocks."));
    }
	

    public void setUrl(String Url) {
        this.urlLogin = urlLogin;
    }
}	