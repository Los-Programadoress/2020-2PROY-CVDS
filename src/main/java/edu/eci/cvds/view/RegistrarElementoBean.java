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
	 private List<Elemento> elementos;
	 
	 @Inject
	 private EquiposServices equipoS;

	public List<Elemento> consultarElementos(){
		System.out.println("entro al bean");
		try{
			elementos = equipoS.consultarElementos();
			System.out.println(elementos.size());
		}
		catch(EquiposException e){   
			System.out.println(elementos.size());
		}
		
		return elementos; 
	 }  
	 
	 public void registrarElementoEquipo(String tipo, String nombre, int nequipo) throws EquiposException{
    	try {
   		 equipoS.registrarElementoEquipo(tipo,nombre,nequipo);
 		}
 		catch (EquiposException e) {
   	 	}
	 }
	 
	 public void registrarElemento(String tipo, String nombre) throws EquiposException{
		try{
			equipoS.registrarElemento(tipo, nombre);
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
