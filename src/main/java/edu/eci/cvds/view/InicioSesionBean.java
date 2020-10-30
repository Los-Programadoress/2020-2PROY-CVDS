package edu.eci.cvds.view;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

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



@SuppressWarnings("serial")
@Named
@Stateless
@SessionScoped
@ManagedBean(name = "InicioSesionBean", eager = true)
public class InicioSesionBean implements Serializable {

	private static final Logger log = LoggerFactory.getLogger(InicioSesionBean.class);
	private String urlLogin = "/faces/sesion.xhtml";
	private Boolean rememberMe = false;
	private String idCorreo;
    private String password;
	private String message;
	Subject subject;
	
	/**
     * Try and authenticate the user
     */
    public void doLogin(){
    	subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(getidCorreo(), getPassword());
        try {
        	subject.login(token);
        	System.err.println();
			FacesContext.getCurrentInstance().getExternalContext().redirect(urlLogin);
        } catch (UnknownAccountException ex) {
            facesError("Cuenta Desconocida");
            log.error(ex.getMessage(), ex);
        } catch (IncorrectCredentialsException ex) {
        	System.err.println("Incorrecto");
            facesError("Contraseña incorrecta");
            log.error(ex.getMessage(), ex);
        } catch (LockedAccountException ex) {
            facesError("Cuenta bloqueada");
            log.error(ex.getMessage(), ex);
        } catch (AuthenticationException | IOException ex) {
            facesError("Error Desconocido: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        } catch (NullPointerException ex) {
            System.err.println("Nulo");
        } finally {
            token.clear();
        }
    }
	
	public void doLogOut() throws  IOException{
        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(urlLogin);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(InicioSesionBean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
	}
	
	/**
     * Adds a new SEVERITY_ERROR FacesMessage
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
	
	public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean lembrar) {
        this.rememberMe = lembrar;
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
	

    public void setUrl(String urlLogin) {
        this.urlLogin = urlLogin;
    }
}	