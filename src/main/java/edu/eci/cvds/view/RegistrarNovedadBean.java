package edu.eci.cvds.view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.EquiposException;
import edu.eci.cvds.services.EquiposServices;

@ManagedBean(name="registrarNovedadBean")
@SessionScoped
public class RegistrarNovedadBean extends BasePageBean{
	private String f_seleccionada = "";
	private List<Novedad> novedadesEq = null;
	private List<Novedad> novedadesEl = null;
	private List<Novedad> novedadesLa = null;
	private List<Equipo> marcaEquipos;
	private List<Elemento> nombreElementos;
	private List<Laboratorio> nombreLaboratorios;
	private String user;
	
	@Inject
	private EquiposServices equipoS;
	
	public void actualizar_fecha(SelectEvent event) {
        SimpleDateFormat fecha1 = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
        StringBuilder cadena_fecha1_11 = new StringBuilder(fecha1.format(event.getObject()));
        f_seleccionada = cadena_fecha1_11.toString();
    }
	
	 public List<Novedad> consultarNovedadEquipos() throws EquiposException{
		 try{
			novedadesEq = equipoS.consultarNovedadEquipos();
		}
		 catch (EquiposException e) {
	 			e.printStackTrace();          
		}
		 return novedadesEq;
	 }
	 
	 public List<Novedad> consultarNovedadElementos() throws EquiposException{
		 try{
			novedadesEl = equipoS.consultarNovedadElementos();
		}
		 catch (EquiposException e) {
	 			e.printStackTrace();          
		}
		 return novedadesEl;
	 }
	 
	 public List<Novedad> consultarNovedadLaboratorios() throws EquiposException{
		try{
			novedadesLa = equipoS.consultarNovedadLaboratorios();
		}
		catch (EquiposException e) {
 			e.printStackTrace();             
		}
		return novedadesLa;
	}
	 
	public List<Integer> consultarMarcaEquipo() throws EquiposException{
		List<Integer> marcaEq = new ArrayList<Integer>();
		try {
			marcaEquipos = equipoS.consultarEquipos();
			for(Equipo es:marcaEquipos) {
				marcaEq.add(es.getNumero());
			}
		}
		catch(EquiposException e) {
 			e.printStackTrace(); 
		}
		return marcaEq;
	} 

	public void registrarNovedadEquipo(String titulo, String detalle) throws EquiposException{
		try{
			//Capturar el usuario
    		Subject currentUser = SecurityUtils.getSubject();
    		user = currentUser.getPrincipal().toString();
    		Date fecha = new Date(System.currentTimeMillis()); 
    		System.out.println(fecha);
			equipoS.registrarNovedadEquipo(titulo, fecha, "maria.alfaro", detalle, 1);
		}
		catch(EquiposException e) {
 			e.printStackTrace();           
		}
	}
	

	public String getF_seleccionada() {
		return f_seleccionada;
	}

	public void setF_seleccionada(String f_seleccionada) {
		this.f_seleccionada = f_seleccionada;
	}
}
