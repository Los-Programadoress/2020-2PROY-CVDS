package edu.eci.cvds.view;

import java.util.ArrayList;
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
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.EquiposException;
import edu.eci.cvds.services.EquiposServices;


@ManagedBean(name="RegistrarEquiposBean")
@SessionScoped
public class RegistrarEquipoBean extends BasePageBean{
	
	private List<Equipo> equipos= null;
	private List<Elemento> elementosEq = null;
	private Equipo equipoSelec;
	private List<Equipo> equiposSelec;
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
		try{
			equipoS.asociacionEquipo(nLab,nome, user);
			info2();
		}
		catch(EquiposException e){        
		}
	}
	
	public void cambiarBajaEquipo(List<Equipo> equipo) throws EquiposException{
		System.out.println(equiposSelec.size()+" tamaño");
		try{
			for(Equipo eq:equipo) {
				equipoS.cambiarBajaEquipo(eq.getNombre(), user);
			}
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
	
	public List<Elemento> consultarElementos() throws EquiposException{
		List<Elemento> consultaElemen = new ArrayList<Elemento>();
		try{
			System.out.println(equiposSelec.size()+" tamaño");
			for(Equipo eq:equiposSelec) {
				List<Elemento> element = equipoS.consultarElementosEquipo(eq.getNombre());
				for(Elemento el:element) {
					consultaElemen.add(el);
				}
			}
		}
		catch(EquiposException e){          
		} 
		return consultaElemen;
	 }
	
	public  List<Equipo> consultarEquiposNoDadosBaja() throws EquiposException{
 		try{
 			equipos = equipoS.consultarEquiposNoDadosBaja();
 		}
 		catch(EquiposException e){          
		}
 		return equipos;
 	 }
	
	public List<Equipo> reporteEquipos() throws EquiposException {
		try{
	 		equipos = equipoS.reporteEquipos();
	 	}
		catch(EquiposException e){          
		}
		return equipos;
	}
	
	 public String nombreEquipoPorId(int nequipo) throws EquiposException{
		 String nombreEquipo = "";
    	 try{
 	 		nombreEquipo = equipoS.nombreEquipoPorId(nequipo);
 	 	}
 	 	catch(Exception e){        
 	    } 
    	return nombreEquipo; 
 	  }
	
	public void info() {
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Equipo dado de baja", "Se dió de baja satisfactoriamente.");
		 PrimeFaces.current().dialog().showMessageDynamic(message);
	 }
	
	public void info2() {
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Asociación de Equipo", "Se asoció satisfactoriamente a el Laboratorio.");
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

	public List<Equipo> getEquiposSelec() {
		return equiposSelec;
	}

	public void setEquiposSelec(List<Equipo> equiposSelec) {
		this.equiposSelec = equiposSelec;
	}
	
	
	
}