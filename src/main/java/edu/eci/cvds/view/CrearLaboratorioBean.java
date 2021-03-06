package edu.eci.cvds.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.primefaces.PrimeFaces;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

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
	
	public List<Laboratorio> consultarLaboratoriosNoCerrados() throws EquiposException {
		try{
			laboratorios = equipoS.consultarLaboratoriosNoCerrados();
		}catch (EquiposException e) {
 			e.printStackTrace();          
		}
		return laboratorios;
	 }
	
	public List<String> consultarLaboratoriosNombre() throws EquiposException {
		List<String> nombre = new ArrayList<String>();
		try{
			laboratorios = equipoS.consultarLaboratoriosNoCerrados();
			for(Laboratorio la:laboratorios) {
				nombre.add(la.getNombre());
			}
		}catch (EquiposException e) {
 			e.printStackTrace();          
		}
		return nombre;
	 }

	public void registrarLaboratorio(String nombre) throws EquiposException{
    	try {
    		//Capturar el usuario
    		Subject currentUser = SecurityUtils.getSubject();
    		user = currentUser.getPrincipal().toString();
   		 	equipoS.registrarLaboratorio(nombre, user);
 		}catch (EquiposException e) {
 			e.printStackTrace();
   	 	}
	 }
	
	public void cerrarLaboratorio(String nombreLab) throws EquiposException{
		try{
			//Capturar el usuario
    		Subject currentUser = SecurityUtils.getSubject();
    		user = currentUser.getPrincipal().toString();
    		equipoS.cerrarLaboratorio(nombreLab, user);
    		info();
		}
		catch (EquiposException e){
			e.printStackTrace();          
	    }
	}
	
	public int cantidadEquiposLab(String nombreLab) throws EquiposException{
		int cantidad = 0;
		try{
			cantidad = equipoS.cantidadEquiposLab(nombreLab);
		}
		catch(Exception e){
			e.printStackTrace();              
	    }
		return cantidad;
	}
	
	public void info() {
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Laboratorio cerrado", "Se cerró el laboratorio satisfactoriamente.");
		 PrimeFaces.current().dialog().showMessageDynamic(message);
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
