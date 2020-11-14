package edu.eci.cvds.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

@ManagedBean(name="registrarNovedadBean")
@SessionScoped
public class RegistrarNovedadBean extends BasePageBean{
	private Date fecha;
	private String f_seleccionada = "";
	
	public void actualizar_fecha(SelectEvent event) {
        SimpleDateFormat fecha1 = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
        StringBuilder cadena_fecha1_11 = new StringBuilder(fecha1.format(event.getObject()));
        f_seleccionada = cadena_fecha1_11.toString();
        
    }

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getF_seleccionada() {
		return f_seleccionada;
	}

	public void setF_seleccionada(String f_seleccionada) {
		this.f_seleccionada = f_seleccionada;
	}
	
	
}
