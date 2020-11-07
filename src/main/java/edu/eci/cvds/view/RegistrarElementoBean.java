package edu.eci.cvds.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.EquiposException;
import edu.eci.cvds.services.EquiposServices;

@ManagedBean(name="registrarElementosBean")
@SessionScoped
public class RegistrarElementoBean extends BasePageBean{
	 
	private static final long serialVersionUID = 328623664005639438L;

	private List<Elemento> elementos = null;
	 
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
			equipoS.registrarElemento(tipo, nombre);
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
	 
	 public void asociacionElemento(int id,int numero,String tipo) throws EquiposException{
		try {
			equipoS.asociacionElemento(id, numero, tipo);
		}catch(EquiposException e){  
			e.printStackTrace();
		}	
	}
	 
	 public List<Elemento> getElementos() {
		return elementos;
	 }

	 public void setElementos(List<Elemento> elementos) {
		this.elementos = elementos;
	 }
}
