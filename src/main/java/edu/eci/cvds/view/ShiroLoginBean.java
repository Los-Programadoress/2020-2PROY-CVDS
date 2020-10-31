package edu.eci.cvds.view;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;

@Stateless
@SessionScoped
@ManagedBean(name = "shiroBean", eager = true)
public class ShiroLoginBean implements Serializable{

    private static final Logger log = LoggerFactory.getLogger(ShiroLoginBean.class);

    private String idCorreo;
    private String password;
    private Boolean rememberMe = false;
    private String loginUrl = "/faces/index.xhtml";
    Subject subject;

    /**
     * Permitir acceso al Usuario
     */
    public void doLogin() {
    	//System.out.println(getidCorreo());
    	//System.out.println(getPassword());
        subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(getidCorreo(), getPassword());
        //System.out.println(token.getPassword());
        
        try {
            subject.login(token);
            if (subject.hasRole("Estudiante") || subject.hasRole("Profesor")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/sesion.xhtml");
            }
        } catch (UnknownAccountException e) {
        	messageError("Usuario Desconocido");
            log.error(e.getMessage(), e);
        } catch (IncorrectCredentialsException e) {
            messageError("Contraseña Incorrecta");
            log.error(e.getMessage(), e);
        } catch (LockedAccountException e) {
            messageError("Usuario Inactivo");
            log.error(e.getMessage(), e);
        } catch (AuthenticationException | IOException e) {
        	messageError("Error Desconocido");
            log.error(e.getMessage(), e);
        } catch (NullPointerException e) {
            System.err.println("Nulo");
        } finally {
            token.clear();
        }
    }

    public void doLogOut() {

        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(loginUrl);
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(ShiroLoginBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Construir un SEVERITY_ERROR con mensaje
     * @param message Error Message
     */
    private void messageError(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "Intente de Nuevo"));
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

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rem) {
        this.rememberMe = rem;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
}
