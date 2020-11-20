package edu.eci.cvds.view;

import java.sql.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.primefaces.PrimeFaces;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.EquiposException;
import edu.eci.cvds.services.EquiposServices;


@ManagedBean(name="RegistrarEquiposBean")
@SessionScoped
public class RegistrarEquipoBean extends BasePageBean{
	
	private List<Equipo> equipos= null;
	private List<Elemento> elementosEq = null;
	private Equipo equipoSelec;
	private String user;

	@Inject
	private EquiposServices equipoS;
	
	public List<Equipo> consultarEquipos(){
 		try{
 			equipos= equipoS.consultarEquipos();
 		}catch(EquiposException e){    
 	    }
 		return equipos;
 	}
	
	public void registrarEquipo(String nombre, String marca) {
		//Capturar el usuario
		Subject currentUser = SecurityUtils.getSubject();
		user = currentUser.getPrincipal().toString();
		try{
			equipoS.registrarEquipo(nombre, marca, user);
		}catch(EquiposException e){           
        }
	}

	public void asociacionEquipo(String nLab, String nome) throws EquiposException{
		Subject currentUser = SecurityUtils.getSubject();
		user = currentUser.getPrincipal().toString();
		Date fecha = new Date(System.currentTimeMillis());
		try{
			equipoS.asociacionEquipo(nLab,nome);
			equipoS.registrarNovedadEquipo("Asociación equipo", fecha, user, "Se  asoció el equipo " + nome + " al laboratorio " + nLab , nome , nLab);
			
		}
		catch(EquiposException e){        
		}
	}
	
	public void cambiarBajaEquipo(String nome) throws EquiposException{
		try{
			info();
			equipoS.cambiarBajaEquipo(nome);
		}
		catch(EquiposException e){          
		} 
	}
	
	public List<Elemento> consultarElementosEquipo(String nequipo) throws EquiposException{
		try{
			elementosEq = equipoS.consultarElementosEquipo(nequipo);
		}
		catch(EquiposException e){          
		} 
		return elementosEq;
	 }
	
	public void info() {
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "De baja al equipo", "Se dió de baja satisfactoriamente al equipo.");
		 PrimeFaces.current().dialog().showMessageDynamic(message);
	 }
	
	public List<Elemento> consultarElementosSelected(){
 		return equipoS.getElSelected();
 	}
	
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo getEquipoSelec() {
		return equipoSelec;
	}

	public void setEquipoSelec(Equipo equipoSelec) {
		this.equipoSelec = equipoSelec;
	}
	
	
}