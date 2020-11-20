package edu.eci.cvds.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

	private static final long serialVersionUID = 650984420982868194L;

	private List<Equipo> equipos= null;
	private List<Elemento> elementosEq = null;
	private Equipo equipoSelec;

	@Inject
	private EquiposServices equipoS;
	
	public List<Equipo> consultarEquipos(){
 		try{
 			equipos= equipoS.consultarEquipos();
 		}catch(EquiposException e){    
 	    }
 		return equipos;
 	}
	
	public void registrarEquipo(String marca, String idcorreo) {
		equipoS.getElSelected().clear();
		
		try{
			equipoS.registrarEquipo(marca, idcorreo);
		}catch(EquiposException e){           
        }
	}

	public void asociacionEquipo(String nLab, String nome) throws EquiposException{
		try{
			equipoS.asociacionEquipo(nLab,nome);
		}
		catch(EquiposException e){        
		}
	}
	
	public void cambiarBajaEquipo(String nome) throws EquiposException{
		try{
			info();
			System.out.println(nome);
			equipoS.cambiarBajaEquipo(true,nome);
			System.out.println("EntroBean");
		}
		catch(EquiposException e){          
		} 
	}
	  
	public List<Elemento> consultarElementosSelected(){
 		return equipoS.getElSelected();
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