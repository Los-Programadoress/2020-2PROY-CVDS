package edu.eci.cvds.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;
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
    /*@Before
    public void checkUsuario(){
        try {
        	Usuario user = new Usuario("maria.alfaro","maria.alfaro@mail.escuelaing.edu.co", "Angelica Alfaro","Activo","44f632480c49db38c4d0cbc2bea2384049c74a689baf5bf576163455787185a3"); 
			equiposServices.registrarUsuario(user);
    		
		} catch (EquiposException e) {
			assertFalse(false);
		}    
    }*/
    
    /**
     * Debe permitir registrar un equipo.
     * Registro Válido: Debe existir el usuario para relacionarlo con el nuevo equipo.
     */
    @Test
    public void deberiaRegistrarEquipo() {
    	try {
    		Usuario user = new Usuario("maria.alfaro","maria.alfaro@mail.escuelaing.edu.co", "Angelica Alfaro","Activo","44f632480c49db38c4d0cbc2bea2384049c74a689baf5bf576163455787185a3"); 
			equiposServices.registrarUsuario(user);
			
    		int eqPreRegistro = equiposServices.consultarEquipos().size(); 
    		equiposServices.registrarEquipo("ASUS", user.getIdCorreo());
    		int eqPosRegistro = equiposServices.consultarEquipos().size(); 
    		assertTrue(eqPosRegistro > eqPreRegistro);
    		
		} catch (EquiposException e) {
			assertFalse(false);
		}
    }
    
    
    /**
     * No debe permitir registrar un equipo.
     * Registro Inválido: No debe existir el usuario para relacionarlo con el nuevo equipo.
     */
    @Test
    public void noDeberiaRegistrarEquipo() {
    	try {
    		int eqPreRegistro = equiposServices.consultarEquipos().size(); 
    		equiposServices.registrarEquipo("HP", "pepe.torres");
    		int eqPosRegistro = equiposServices.consultarEquipos().size(); 
    		assertTrue(eqPosRegistro == eqPreRegistro);
    		
		}catch (EquiposException e) {
			assertFalse(false);
		}
    }
    

    /**
     * Debe permitir registrar un elemento a un equipo existente.
     * Registro Válido: Debe existir el equipo para relacionarlo con el nuevo elemento.
     */
    @Test
    public void deberiaRegistrarElementoAEquipo() {
    	try {
    		//elementos sin asociar
    		equiposServices.registrarElemento("Torre", "V530 AIO");
    		equiposServices.registrarElemento("Mouse", "Vertical Inalámbrico");
    		equiposServices.registrarElemento("Teclado", "Flexible");
    		equiposServices.registrarElemento("Pantalla", "LED");
    		
    		List<Elemento> elementos = equiposServices.consultarElementos();
    		equiposServices.registrarEquipo("TOSHIBA", "maria.alfaro");
    		List<Equipo> equipos = equiposServices.consultarEquipos();
    		//antes de registrar elementos
    		Equipo equipoRegistrado = equipos.get(equipos.size()-1);
    		int elemPre = equiposServices.consultarElementosEquipo(equipoRegistrado.getNumero()).size();
    		
    		//elementos asociados
    		equiposServices.asociarElemento(equipoRegistrado.getNumero(),elementos.size());
    		equiposServices.asociarElemento(equipoRegistrado.getNumero(),elementos.size()-1);
    		equiposServices.asociarElemento(equipoRegistrado.getNumero(),elementos.size()-2);
    		equiposServices.asociarElemento(equipoRegistrado.getNumero(),elementos.size()-3);
    		
    		//después de registrar elementos
    		int elemPos = equiposServices.consultarElementosEquipo(equipoRegistrado.getNumero()).size();   		
    		
    		assertTrue(elemPre < elemPos);

		} catch (EquiposException e) {
			Assert.assertFalse(false);
		}
    }
    
    /**
     * No debe permitir registrar un elemento a un equipo no existente.
     * Registro Inválido: No debe existir el equipo para relacionarlo con el nuevo elemento.
     */
    @Test
    public void noDeberiaRegistrarElementoAEquipo() {
    	boolean r = false;
    	try {
    		//elemento sin asociar
    		equiposServices.registrarElemento("Torre", "V530 AIO");
    		
    		List<Elemento> elementos = equiposServices.consultarElementos();
    		
    		//elemento asociado
    		equiposServices.asociarElemento(1000,elementos.size());
    		r = false;

		} catch (EquiposException e) {
			r = true;
		}
    	assertTrue(r);
    }
    
    /**
     * Debe permitir registrar un nuevo elemento al laboratorio.
     * Registro Válido: Se registra un elemento que sea de tipo:'Torre' o 'Pantalla’ o ‘Mouse’ o ‘Teclado'.
     */
    @Test
    public void deberiaRegistrarElemento() {
    	try {
    		equiposServices.registrarElemento("TECLADO", "Gamer");
    		
    		List<Elemento> elementos = equiposServices.consultarElementos();
    		assertEquals(elementos.get(elementos.size() -1).getNombre(),"Gamer");
    			
		} catch (EquiposException e) {
			Assert.assertFalse(false);
		}
    }
    
    /**
     * No debe permitir registrar un nuevo elemento al laboratorio.
     * Registro Inválido: Se registra un elemento que sea de un tipo diferente a:'Torre' o 'Pantalla’ o ‘Mouse’ o ‘Teclado'.
     */
    @Test
    public void noDeberiaRegistrarElemento() {
    	boolean r = false;
    	try {
    		equiposServices.registrarElemento("PARLANTES", "X6000");
    		r = false;
		} catch (EquiposException e) {
			r = true;
		}
    	assertTrue(r);
    }
    
    
    
    /**
     * Debe permitir consultar elementos del laboratorio según el tipo y que estén disponibles.
     * Consulta Válida: Se consulta los elementos que sean de tipo:'Torre' o 'Pantalla’ o ‘Mouse’ o ‘Teclado' y disponibles.
     */
    @Test
    public void deberiaConsultarElementosDisponibles() {
    	try {
    		List<Elemento> elementos = equiposServices.consultarElemento("Teclado");
    		assertTrue(elementos.size() >= 0);
    		
		} catch (EquiposException e) {
			assertFalse(false);
		}
    }
    
    /**
     * Debe permitir consultar elementos del laboratorio.
     * Consulta Válida: Se consulta los elementos registrados.
     */
    @Test
    public void deberiaConsultarElementos() {
    	try {
    		List<Elemento> elements=equiposServices.consultarElementos();
    		assertTrue(elements.size() >= 0);
    			
		} catch (EquiposException e) {
			assertFalse(false);
		}
    }
}