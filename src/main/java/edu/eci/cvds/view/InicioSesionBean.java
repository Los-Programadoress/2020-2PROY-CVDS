package edu.eci.cvds.view;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.google.inject.Inject;

import edu.eci.cvds.security.InicioSesion;
import edu.eci.cvds.services.EquiposException;


@SuppressWarnings("deprecation")
@ManagedBean(name = "InicioSesionBean")
@SessionScoped
public class InicioSesionBean {
	@Inject
	private InicioSesion iniciosesion;
	private String correo;
    private String password;
    private String message;
	
	public void islogin() throws IOException, EquiposException {
		if(!iniciosesion.isLogged()) {
            iniciosesion.login(correo, password);
            volverInicio();
        }
        else{
            sesionExistente();
        }
	}
	
	public void sesionExistente() throws IOException{
        this.message = "Ya hay otro usuario logueado";
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("");
    }
	
	public void volverInicio() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        session.setAttribute("correo", correo);
        facesContext.getExternalContext().redirect("../sesion.xhtml");
    }
	
	public void logOut() throws  IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("../sesion.xhtml");
        iniciosesion.logout();
    }

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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
	
	public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, "PrimeFaces Rocks."));
    }
	
}
