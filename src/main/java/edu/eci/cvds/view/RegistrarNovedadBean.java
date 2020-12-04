package edu.eci.cvds.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.services.EquiposException;
import edu.eci.cvds.services.EquiposServices;

@ManagedBean(name="registrarNovedadBean")
@ApplicationScoped
public class RegistrarNovedadBean extends BasePageBean{
	
	private String f_seleccionada = "";
	private List<Novedad> novedadesEq = null;
	private List<Novedad> novedadesEl = null;
	private List<Novedad> novedadesLa = null;
	private List<Equipo> nombreEquipos;
	private List<Elemento> nombreElementos;
	private List<Laboratorio> nombreLaboratorios;
	private String user;
	private String nombreEq;
	private String nombreEl;
	
	@Inject
	private EquiposServices equipoS;
	
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
	 
	public List<String> consultarNombreEquipo() throws EquiposException{
		List<String> nombreEq = new ArrayList<String>();
		nombreEq.clear();
		try {
			nombreEquipos = equipoS.consultarEquipos();
			for(Equipo es:nombreEquipos) {
				nombreEq.add(es.getNombre());
			}
		}
		catch(EquiposException e) {
 			e.printStackTrace(); 
		}
		return nombreEq;
	} 

	public void registrarNovedadEquipo(String titulo, String detalle, String nEquipo) throws EquiposException{
		try{
			//Capturar el usuario
    		Subject currentUser = SecurityUtils.getSubject();
    		user = currentUser.getPrincipal().toString();
    		Date fecha = new Date(System.currentTimeMillis()); 
			equipoS.registrarNovedadEquipo(titulo, fecha, user, detalle, nEquipo, equipoS.nombreLabDelEquipo(nEquipo));
		}
		catch(EquiposException e) {
 			e.printStackTrace();           
		}
	}
	
	public List<String> consultarNombreElemento() throws EquiposException{
		List<String> nombreEl = new ArrayList<String>();
		try {
			nombreElementos = equipoS.consultarElementos();
			for(Elemento es:nombreElementos) {
				nombreEl.add(es.getNombre());
			}
		}
		catch(EquiposException e) {
 			e.printStackTrace(); 
		}
		return nombreEl;
	} 
	
	public void registrarNovedadElemento(String titulo, String detalle,String nombreElem) throws EquiposException{
		try{
			//Capturar el usuario
    		Subject currentUser = SecurityUtils.getSubject();
    		user = currentUser.getPrincipal().toString();
    		Date fecha = new Date(System.currentTimeMillis());
    		int numEq = equipoS.numEquipoDelElemento(nombreElem);
    		if (numEq > 0) {
    			equipoS.registrarNovedadElemento(titulo, fecha, user, detalle, equipoS.nombreEquipoPorId(numEq), nombreElem);
    		}
    		else {
    			equipoS.registrarNovedadElemento(titulo, fecha, user, detalle, null, nombreElem);
    		}
		}
		catch(EquiposException e) {
 			e.printStackTrace();             
		}
	}
	
	public List<String> consultarNombreLaboratorio() throws EquiposException{
		List<String> nombreEl = new ArrayList<String>();
		try {
			nombreLaboratorios = equipoS.consultarLaboratorios();
			for(Laboratorio es:nombreLaboratorios) {
				nombreEl.add(es.getNombre());
			}
		}
		catch(EquiposException e) {
 			e.printStackTrace(); 
		}
		return nombreEl;
	} 
	
	public void registrarNovedadLaboratorio(String titulo, String detalle, String nLab) throws EquiposException{
		try{
			//Capturar el usuario
    		Subject currentUser = SecurityUtils.getSubject();
    		user = currentUser.getPrincipal().toString();
    		Date fecha = new Date(System.currentTimeMillis());
			equipoS.registrarNovedadLaboratorio(titulo, fecha,user, detalle, nLab);
		}
		catch(EquiposException e) {
 			e.printStackTrace();           
		} 
	 }
	
	public List<Novedad> consultarNovedadesEquipo(String equipoNombre) throws EquiposException{
		 try{
			 novedadesEq = equipoS.consultarNovedadesEquipo(equipoNombre);
		}
		 catch(EquiposException e) {
	 			e.printStackTrace(); 
		}
		 return novedadesEq;
	 }

	 public List<Novedad> consultarNovedadesElemento(String elementoNombre) throws EquiposException{
		 try{
			 novedadesEl = equipoS.consultarNovedadesElemento(elementoNombre);
		}
		 catch(EquiposException e) {
	 			e.printStackTrace(); 
		} 
		 return novedadesEl;
	 }
	 
	 public List<Novedad> consultarNovedadesLaboratorio(String laboratorioNombre) throws EquiposException{
		 try{
			 novedadesLa = equipoS.consultarNovedadesLaboratorio(laboratorioNombre);
		}
		 catch(EquiposException e) {
	 			e.printStackTrace(); 
		}
		 return novedadesLa;
	 }

	public String getF_seleccionada() {
		return f_seleccionada;
	}

	public void setF_seleccionada(String f_seleccionada) {
		this.f_seleccionada = f_seleccionada;
	}

	public String getNombreEq() {
		return nombreEq;
	}

	public void setNombreEq(String nombreEq) {
		this.nombreEq = nombreEq;
	}

	public String getNombreEl() {
		return nombreEl;
	}

	public void setNombreEl(String nombreEl) {
		this.nombreEl = nombreEl;
	}

	
}
