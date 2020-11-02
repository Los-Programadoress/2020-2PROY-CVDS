package edu.eci.cvds.view;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
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
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;

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
     * Permite acceso al Usuario
     */
    public void doLogin() {

    	subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(getidCorreo(),new Sha256Hash(getPassword()).toHex());
        
        try {
            subject.login(token);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/sesion.xhtml");
        } catch (UnknownAccountException e) {
        	messageError("Usuario Desconocido");
            log.error(e.getMessage(), e);
        } catch (IncorrectCredentialsException e) {
            messageError("Credenciales Incorrectas");
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
    
    /**
     * Permite cierre de sesión del Usuario
     */
    public void doLogOut() {
    	SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(loginUrl);
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(ShiroLoginBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    

    /**
     * Construye un SEVERITY_ERROR con mensaje
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
