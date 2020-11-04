package edu.eci.cvds.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.EquiposException;
import edu.eci.cvds.services.EquiposServices;

@ManagedBean(name="RegistrarElementoBean")
@SessionScoped
public class RegistrarElementoBean {
	 private List<Elemento> elementos= null;
	 
	 @Inject
	 private EquiposServices equipoS;

	public List<Elemento> consultarElementos(){
		try{
			elementos = equipoS.consultarElementos();
		}
		catch(EquiposException e){            
		}
		return elementos;
	 }  
	 
	 public void registrarElementoEquipo(int id, String tipo, String nombre, int nequipo) throws EquiposException{
    	try {
   		 equipoS.registrarElementoEquipo(id,tipo,nombre,nequipo);
 		}
 		catch (EquiposException e) {
   	 	}
	 }
	 
	 public void registrarElemento(int id, String tipo, String nombre) throws EquiposException{
		try{
			equipoS.registrarElemento(id, tipo, nombre);
		}
		catch(EquiposException e){           
		}
	 }
	 
	 public List<Elemento> getElementos() {
		return elementos;
	 }

	 public void setElementos(List<Elemento> elementos) {
		this.elementos = elementos;
	 }
}
