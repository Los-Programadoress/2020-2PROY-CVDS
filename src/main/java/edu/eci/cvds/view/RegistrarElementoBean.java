package edu.eci.cvds.view;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.primefaces.PrimeFaces;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.services.EquiposException;
import edu.eci.cvds.services.EquiposServices;

@ManagedBean(name="registrarElementosBean")
@SessionScoped
public class RegistrarElementoBean extends BasePageBean{

	private List<Elemento> elementos = null;
	private String tipoBoton;
	private Elemento elementoSelec;
	private List<Elemento> elementoDispo = null;
	private String user;
	private List<Elemento> elementosSelec;
	 
	 @Inject
	 private EquiposServices equipoS;

	public List<Elemento> consultarElementos(){
		try{
			elementos = equipoS.consultarElementos();
		}catch(EquiposException e){   
			e.printStackTrace();
		}
		return elementos; 
	 }  
	
	 
	 public void registrarElementoEquipo(String tipo, String nombre, int nequipo) throws EquiposException{
    	try {
   		 	equipoS.registrarElementoEquipo(tipo,nombre,nequipo);
 		}catch (EquiposException e) {
 			e.printStackTrace();
   	 	}
	 }
	 
	 public void registrarElemento(String tipo, String nombre) throws EquiposException{
		try{
			Subject currentUser = SecurityUtils.getSubject();
			user = currentUser.getPrincipal().toString();
			
			if(this.tipoBoton==null) {
				equipoS.registrarElemento(tipo, nombre, user);
				List<Elemento> res = equipoS.consultarElementos();
				int pos = res.size() - 1;
				elementoSelec = new Elemento(res.get(pos).getId(), res.get(pos).getTipo(), res.get(pos).getNombre(), res.get(pos).isDisponible());
				add();
			}
			else {
				equipoS.registrarElemento(this.tipoBoton, nombre, user);
			}
			info();
		}catch (EquiposException e) {
 			e.printStackTrace();
   	 	}
	}
	 
	 public List<Elemento> consultarElemento(String tipo) throws EquiposException {
		try{
			elementos = equipoS.consultarElemento(tipo);
		}catch (EquiposException e) {
 			e.printStackTrace();          
		}
		return elementos;
	 }
	 
	 public void asociacionElemento(int id, int numero, String tipo, String equipoNombre, String elementoNombre) throws EquiposException{
		Subject currentUser = SecurityUtils.getSubject();
		user = currentUser.getPrincipal().toString();
		try {
			equipoS.asociacionElemento(id, numero, tipo, equipoNombre, elementoNombre, user);
			info3();
		}catch(EquiposException e){  
			e.printStackTrace();
		}	
	 }
	 
	 public void cambiarBajaElemento(List<Elemento> elemento) throws EquiposException{
		try{
			Subject currentUser = SecurityUtils.getSubject();
			user = currentUser.getPrincipal().toString();
			for(Elemento ele:elemento) {
				equipoS.cambiarBajaElemento(true, ele.getNombre(), user);
			}
			info2();
		}
		catch(EquiposException e){  
			e.printStackTrace();         
		}
	}
	 
	 public void desasociarElemento(List<Elemento> elemento)throws EquiposException{
		try {
			for(Elemento ele:elemento) {
				equipoS.desasociarElemento(true, equipoS.numEquipoDelElemento(ele.getNombre()), ele.getTipo());
			}
			info4();
		}catch(EquiposException e){  
			e.printStackTrace(); 
		}
	 }
	 
	 public List<Elemento> consultarElementosDisponibles() throws EquiposException{
		try {
			elementoDispo = equipoS.consultarElementosDisponibles();
		}
		catch(EquiposException e){  
			e.printStackTrace(); 
		}
		return elementoDispo;
	}
	 
	 public List<Elemento> reporteElementos() throws EquiposException{
   		try {
			 elementos = equipoS.reporteElementos();
		 }
   		catch(EquiposException e){  
			e.printStackTrace(); 
		}
   		return elementos;
   	}
	 
	 public void add() {		 
		 equipoS.add(getElementoSelec());
		 info();
	 }
	 
	 public void botonMouse() {
		 tipoBoton="Mouse";
	 }
	 
	 public void botonTorre() {
		 tipoBoton="Torre";
	 }

	 public void botonTeclado() {
		 tipoBoton="Teclado";
	 }

	 public void botonPantalla() {
		 tipoBoton="Pantalla";
	 }
	 
	 public void info() {
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro del elemento", "Se registró satisfactoriamente.");
         PrimeFaces.current().dialog().showMessageDynamic(message);
	 }
	 
	 public void info2() {
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Elemento dado de baja", "Se dió de baja al elemento satisfactoriamente.");
         PrimeFaces.current().dialog().showMessageDynamic(message);
	 }
	 
	 public void info3() {
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Asociación de Elemento", "Se asoció satisfactoriamente.");
		 PrimeFaces.current().dialog().showMessageDynamic(message);
	 }
	 
	 public void info4() {
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Asociación eliminada", "Se eliminó la asociación satisfactoriamente.");
		 PrimeFaces.current().dialog().showMessageDynamic(message);
	 }
	 
	 public List<Elemento> getElementos() {
		return elementos;
	 }

	 public void setElementos(List<Elemento> elementos) {
		this.elementos = elementos;
	 }

	 public String getTipoBoton() {
		return tipoBoton;
	 }

	 public void setTipoBoton(String tipoBoton) {
		this.tipoBoton = tipoBoton;
	 }

	public Elemento getElementoSelec() {
		return elementoSelec;
	}

	public void setElementoSelec(Elemento elementoSelec) {
		this.elementoSelec = elementoSelec;
	}


	public List<Elemento> getElementosSelec() {
		return elementosSelec;
	}


	public void setElementosSelec(List<Elemento> elementosSelec) {
		this.elementosSelec = elementosSelec;
	}
	
	
}
