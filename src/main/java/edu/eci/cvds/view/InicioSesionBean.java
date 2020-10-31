package edu.eci.cvds.view;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;


@Named
@Stateless
@SessionScoped
@ManagedBean(name = "inicioSesionBean", eager = true)
public class InicioSesionBean implements Serializable{

    private static final Logger log = LoggerFactory.getLogger(InicioSesionBean.class);
    private String message;
    private String idCorreo;
    private String password;
    private Boolean rememberMe = false;
    private String redirectUrl = "/faces/index.xhtml";
    Subject subject;

    /**
     * Try and authenticate the user
     */
    public void doLogin() {
    	//System.out.println(getidCorreo());
    	//System.out.println(getPassword());
        subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(getidCorreo(), getPassword());
        try {
            subject.login(token);
            if (subject.hasRole("Estudiante")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/sesion.xhtml");
            } else if (subject.hasRole("Profesor")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/sesion.xhtml");
            }
        } catch (UnknownAccountException ex) {
        	System.err.println("Cuenta Desconocida");
            facesError("Cuenta Desconocida");
            log.error(ex.getMessage(), ex);
        } catch (IncorrectCredentialsException ex) {
            System.err.println("Contraseña Incorrecta");
            facesError("Contraseña Incorrecta");
            log.error(ex.getMessage(), ex);
        } catch (LockedAccountException ex) {
        	System.err.println("Cuenta Inactiva");
            facesError("Cuenta Inactiva");
            log.error(ex.getMessage(), ex);
        } catch (AuthenticationException | IOException ex) {
        	System.err.println("Error Desconocido:");
            facesError("Error Desconocido: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        } catch (NullPointerException e) {
            System.err.println("Nulo");
        } finally {
            token.clear();
        }
    }

    public void doLogOut() {

        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/index.xhtml");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(InicioSesionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Adds a new SEVERITY_ERROR FacesMessage
     *
     * @param message Error Message
     */
    private void facesError(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

    public String getidCorreo() {
        return idCorreo;
    }

    public void setidCorreo(String login) {
        this.idCorreo = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String senha) {
        this.password = senha;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean lembrar) {
        this.rememberMe = lembrar;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }
	public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, "PrimeFaces Rocks."));
    }
	

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
