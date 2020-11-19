package edu.eci.cvds.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

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
		try{
			System.out.println("entrooo");
			System.out.println(nLab);
			System.out.println(nome);
			equipoS.asociacionEquipo(nLab,nome);
		}
		catch(EquiposException e){        
		}
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