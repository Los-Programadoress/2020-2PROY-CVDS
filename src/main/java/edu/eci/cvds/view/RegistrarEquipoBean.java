package edu.eci.cvds.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.EquiposException;
import edu.eci.cvds.services.EquiposServices;


@ManagedBean(name="RegistrarEquiposBean")
@SessionScoped
public class RegistrarEquipoBean extends BasePageBean{

	private static final long serialVersionUID = 650984420982868194L;

	private List<Equipo> equipos= null;
	private List<Elemento> elemento = null;
	private Equipo equipoSelec;

	@Inject
	private EquiposServices equipoS;
	@Inject
	private Usuario usuarioUsado;
	
	public List<Equipo> consultarEquipos(){
 		try{
 			equipos= equipoS.consultarEquipos();
 		}catch(EquiposException e){    
 	    }
 		return equipos;
 	}
	
	public void registrarEquipo(String marca, String idcorreo) {
		try{
			equipoS.registrarEquipo(marca, idcorreo);
		}catch(EquiposException e){           
        }
	}
	
	public List<Elemento> consultarElementosUltimoEquipo(){
 		try{
 			elemento = equipoS.consultarElementosUltimoEquipo();
 		}catch(EquiposException e){    
 	    }
 		return elemento;
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