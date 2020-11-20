package edu.eci.cvds.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

 
import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.EquiposException;
import edu.eci.cvds.services.EquiposServices;
import edu.eci.cvds.services.EquiposServicesFactory;
public class EquiposServicesTest {
    
    @Inject
    private SqlSession sqlSession;
    
    private EquiposServices equiposServices;
    
    private Usuario user;
    
    /**
     * Instancia los Servicios de EquiposServices.
     */
    public EquiposServicesTest() {
        equiposServices = EquiposServicesFactory.getInstance().getEquiposServicesTesting();
    }
    
    /**
     * Obtiene un usuario prueba de la base de datos
     */
    @Before
    public void Usuario(){
        try {
        	Usuario user = equiposServices.consultarUsuario("maria.alfaro");
            /*Usuario user = new Usuario("maria.alfaro","maria.alfaro@mail.escuelaing.edu.co", "Angelica Alfaro","Activo","44f632480c49db38c4d0cbc2bea2384049c74a689baf5bf576163455787185a3"); 
            equiposServices.registrarUsuario(user);*/
            
        } catch (EquiposException e) {
            assertFalse(false);
        }    
    }

    /**
     * Debe permitir registrar un equipo con sus elementos.
     * Registro Válido: Debe existir el usuario para relacionarlo con el nuevo equipo.
     */
    /*@Test
    public void deberiaRegistrarEquipo() {
    	try {
    		//elementos sin asociar
    		Elemento el = new Elemento(1,"Torre", "V530 AIO");
    		Elemento el1 = new Elemento(2,"Mouse", "Vertical Inalámbrico TX");
    		Elemento el2 = new Elemento(3,"Teclado", "Flexible TX");
    		Elemento el3 = new Elemento(4,"Pantalla", "LED TX");
    		//elementos a asociar
    		equiposServices.add(el);
    		equiposServices.add(el1);
    		equiposServices.add(el2);
    		equiposServices.add(el3);
    		
    		int eqPreRegistro = equiposServices.consultarEquipos().size();
    		equiposServices.registrarEquipo("SISTEMAS1", "TOSHIBA", "maria.alfaro");
    		int eqPosRegistro = equiposServices.consultarEquipos().size();
    		
    		assertTrue(eqPosRegistro > eqPreRegistro);

    	} catch (EquiposException e) {
    		assertFalse(false);
    	}
    }*/
    
    /**
     * No debe permitir registrar un equipo.
     * Registro Inválido: No debe existir el usuario para relacionarlo con el nuevo equipo.
     */
    /*@Test
    public void noDeberiaRegistrarElementoEquipo() {
    	try {
    		//elementos sin asociar
    		Elemento el = new Elemento(1,"Torre", "V530 AIO");
    		Elemento el1 = new Elemento(2,"Mouse", "Vertical Inalámbrico TX");
    		Elemento el2 = new Elemento(3,"Teclado", "Flexible TX");
    		Elemento el3 = new Elemento(4,"Pantalla", "LED TX");
    		//elementos a asociar
    		equiposServices.add(el);
    		equiposServices.add(el1);
    		equiposServices.add(el2);
    		equiposServices.add(el3);
    		
    		int eqPreRegistro = equiposServices.consultarEquipos().size();
    		equiposServices.registrarEquipo("SISTEMAS5", "ASUS", "pepe.torres");
    		
    		assertFalse(false);

		} catch (EquiposException e) {
    		assertTrue(true);
		}
    }*/
    
    /*@Test
    public void deberíaAsociar() {
    	try {
			//equiposServices.registrarLaboratorio("LABISW A", "maria.alfaro");
			//equiposServices.registrarLaboratorio("MULTIMEDIA A", "maria.alfaro");
			//equiposServices.registrarEquipo("SISTEMAS12", "HP", "cesar.ortiz");
			//equiposServices.asociacionEquipo("LABISW A", "SISTEMAS12");
			equiposServices.asociacionEquipo("MULTIMEDIA", "SISTEMAS1");
			assertTrue(true);
			
		} catch (EquiposException e) {
			assertFalse(false);
		}
    	
    }*/
}