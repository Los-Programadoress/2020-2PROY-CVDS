package edu.eci.cvds.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.services.EquiposException;
import edu.eci.cvds.services.EquiposServices;

@ManagedBean(name="crearLaboratoriosBean")
@SessionScoped
public class CrearLaboratorioBean extends BasePageBean{
	
	private static final long serialVersionUID = 1L;
	
	private List<Laboratorio> laboratorios = null;
	private String user;
	private Laboratorio laboratorioSelec;
	
	@Inject
	private EquiposServices equipoS;
	
	public List<Laboratorio> consultarLaboratorios() throws EquiposException {
		try{
			laboratorios = equipoS.consultarLaboratorios();
		}catch (EquiposException e) {
 			e.printStackTrace();          
		}
		return laboratorios;
	 }

	public void registrarLaboratorio(String nombre) throws EquiposException{
    	try {
    		//Capturar el usuario
    		Subject currentUser = SecurityUtils.getSubject();
    		user = currentUser.getPrincipal().toString();
    		System.out.println(user);
   		 	equipoS.registrarLaboratorio(nombre, user);
 		}catch (EquiposException e) {
 			e.printStackTrace();
   	 	}
	 }
	
	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}

	public EquiposServices getEquipoS() {
		return equipoS;
	}

	public void setEquipoS(EquiposServices equipoS) {
		this.equipoS = equipoS;
	}

	public Laboratorio getLaboratorioSelec() {
		return laboratorioSelec;
	}

	public void setLaboratorioSelec(Laboratorio laboratorioSelec) {
		this.laboratorioSelec = laboratorioSelec;
	}
	
	
}
