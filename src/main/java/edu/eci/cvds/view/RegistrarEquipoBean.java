package edu.eci.cvds.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.EquiposException;
import edu.eci.cvds.services.EquiposServices;


@ManagedBean(name="RegistrarEquiposBean")
@SessionScoped
public class RegistrarEquipoBean extends BasePageBean{
	private List<Equipo> equipos= null;
	private Equipo equipo = null;

	@Inject
	private EquiposServices equipoS;
	@Inject
	private Usuario usuarioUsado;
	
	public List<Equipo> consultarEquipos(){
 		try{
 			equipos= equipoS.consultarEquipos();
 		}
 		catch(EquiposException e){    
 	    }
 		return equipos;
 	}
	
	public void registrarEquipo(String marca, Usuario usuario) {
		try{
			equipoS.registrarEquipo(marca, usuario);
		}
		catch(EquiposException e){           
        }
	 }
	
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
}