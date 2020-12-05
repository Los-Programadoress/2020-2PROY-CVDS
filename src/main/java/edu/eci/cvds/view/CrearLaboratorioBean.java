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
	private BarChartModel barra;
	private PieChartModel torta;
	
	@Inject
	private EquiposServices equipoS;
	
	public BarChartModel graficar() throws EquiposException {
		barra = new BarChartModel();
		laboratorios = equipoS.consultarLaboratorios();
		for(Laboratorio la:laboratorios) {
			ChartSeries serie = new BarChartSeries();
			serie.setLabel(la.getNombre());
			serie.set(la.getNombre(), equipoS.cantidadEquiposLab(la.getNombre()));
			barra.addSeries(serie);
		}
		barra.setTitle("Cantidad de equipos por laboratorios");
		barra.setLegendPosition("ne");
		barra.setAnimate(true);
		Axis xAxis=barra.getAxis(AxisType.X);
		xAxis.setLabel("Laboratorios");
		Axis yAxis=barra.getAxis(AxisType.Y);
		yAxis.setLabel("Cantidad Equipos de laboratorio");
		yAxis.setMin(0);
		yAxis.setMax(20);
		return barra;
	}
	
	public PieChartModel generarEstadistica() throws EquiposException {
        torta = new PieChartModel();
        laboratorios = equipoS.consultarLaboratorios();

        for (Laboratorio laboratory : laboratorios) {
            torta.set(laboratory.getNombre(),equipoS.cantidadEquiposLab(laboratory.getNombre()));
        }
        torta.setTitle("Cantidad de equipos por laboratorio");
        torta.setShowDataLabels(true);
        torta.setDataLabelFormatString("%dK");
        torta.setLegendPosition("e");
        torta.setShowDatatip(true);
        torta.setShowDataLabels(true);
        torta.setDataFormat("value");
        torta.setDataLabelFormatString("%d");
        torta.setSeriesColors("006600,FFFF00,000099,990000");
        return torta;
    }
	
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

	public BarChartModel getBarra() {
		return barra;
	}

	public void setBarra(BarChartModel barra) {
		this.barra = barra;
	}
	
	
}
