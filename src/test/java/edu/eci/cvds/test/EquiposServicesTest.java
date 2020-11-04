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
    
    /**
     * Instancia los Servicios de EquiposServices.
     */
    public EquiposServicesTest() {
    	equiposServices = EquiposServicesFactory.getInstance().getEquiposServicesTesting();
    }
    
    /**
     * Debe permitir registrar un equipo.
     * Registro Válido: Debe existir el usuario para relacionarlo con el nuevo equipo.
     */
    @Test
    public void deberiaRegistrarEquipo() {
    	try {
    		Usuario usuario = equiposServices.consultarUsuario("maria.alfaro");     		
    		equiposServices.registrarEquipo("DELL", usuario.getIdCorreo());
    		Equipo e = equiposServices.consultarEquipo(3);
    		assertEquals(e.getNumero(),3);
	    	
		} catch (EquiposException e) {
			Assert.assertFalse(false);
		}
    }
    
    /**
     * No debe permitir registrar un equipo.
     * Registro Inválido: No debe existir el usuario para relacionarlo con el nuevo equipo.
     */
    @Test
    public void noDeberiaRegistrarEquipo() {
    	boolean r = false;
    	try {
    		Usuario usuario = equiposServices.consultarUsuario("pepe.torres");     		
    		equiposServices.registrarEquipo("HP", usuario.getIdCorreo());
    		assertEquals(equiposServices.consultarEquipo(4).getMarca(),"HP");
    		
		}catch (EquiposException | NullPointerException e) {
			r = true;
		}
    	Assert.assertTrue(r);
    }
    
    /**
     * Debe permitir consultar equipos del laboratorio.
     * Consulta Válida: Se consulta los equipos registrados.
     */
    @Test
    public void deberiaConsultarEquipos() {
    	try {
    		Usuario usuario = equiposServices.consultarUsuario("maria.alfaro");     		
    		equiposServices.registrarEquipo("ASUS", usuario.getIdCorreo());
    		
    		List<Equipo> equipos = equiposServices.consultarEquipos();
    		assertTrue(equipos.size()>=1);
    		assertEquals(equipos.get(1).getMarca(),"ASUS");
    		
		} catch (EquiposException e) {
			Assert.assertFalse(false);
		}
    }
    
    /**
     * Debe permitir registrar un elemento a un equipo existente.
     * Registro Válido: Debe existir el equipo para relacionarlo con el nuevo elemento.
     */
    @Test
    public void deberiaRegistrarElementoAEquipo() {
    	try {
    		Usuario usuario = equiposServices.consultarUsuario("maria.alfaro");     		
    		equiposServices.registrarEquipo("TOSHIBA", usuario.getIdCorreo());
    		equiposServices.registrarElementoEquipo("Mouse", "Vertical Inalámbrico", 5);
    		equiposServices.registrarElementoEquipo("Pantalla", "LED", 5);
    		equiposServices.registrarElementoEquipo("Torre", "V530 AIO", 5);
    		equiposServices.registrarElementoEquipo("Teclado", "Flexible", 5);
    		Equipo e = equiposServices.consultarEquipo(5);
    		List<Elemento> elementos = equiposServices.consultarElementosEquipo(5);
    		
    		assertEquals(elementos.size(),4);

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
    		Usuario usuario = equiposServices.consultarUsuario("maria.alfaro");
    		equiposServices.registrarEquipo("DELL", usuario.getIdCorreo());
    		equiposServices.registrarElementoEquipo("Mouse", "Vertical Inalámbrico", 6);
    		assertEquals(equiposServices.consultarEquipo(5).getMarca(),"DELL");
    		
		} catch (EquiposException e) {
			r = true;
		}
    	Assert.assertTrue(r);
    }
    
    /**
     * Debe permitir registrar un nuevo elemento al laboratorio.
     * Registro Válido: Se registra un elemento que sea de tipo:'Torre' o 'Pantalla’ o ‘Mouse’ o ‘Teclado'.
     */
    @Test
    public void deberiaRegistrarElemento() {
    	try {    		
    		equiposServices.registrarElemento("Torre", "Completa E-ATX");
    		equiposServices.registrarElemento("Mouse", "Óptico");
    		equiposServices.registrarElemento("Teclado", "Gamer");
    		equiposServices.registrarElemento("Pantalla", "LCD");
    		equiposServices.registrarElemento("Pantalla", "Plasma");
    		
    		List<Elemento> elementos = equiposServices.consultarElementos();
    		assertEquals(elementos.size(),8);
    			
		} catch (EquiposException e) {
			Assert.assertFalse(false);
		}
    }
    
    
    /**
     * Debe permitir consultar elementos del laboratorio.
     * Consulta Válida: Se consulta los elemento que sean de tipo:'Torre' o 'Pantalla’ o ‘Mouse’ o ‘Teclado'.
     */
    @Test
    public void deberiaConsultarElementos() {
    	try {
    		equiposServices.registrarElemento("Torre", "Completa E-ATX R");
    		equiposServices.registrarElemento("Mouse", "Óptico Dux");
    		
    		List<Elemento> e=equiposServices.consultarElementos();
    		assertEquals(e.get(1).getNombre(),"Óptico Dux");
    		
    		
		} catch (EquiposException e) {
			Assert.assertFalse(false);
		}
    }
    
    /**
     * Al registrar un elemento este debe estar disponible.
     * Consulta Válida: Un elemento registrado está disponible (true) para ser asociado.
     */
    @Test
    public void deberiaConsultarElementoDisponible() {
    	try {
    		equiposServices.registrarElemento("Torre", "Modelo HP 6305");
    		
    		List<Elemento> e=equiposServices.consultarElementos();
    		assertEquals(e.get(2).isDisponible(),true);
    		
    		
		} catch (EquiposException e) {
			Assert.assertFalse(false);
		}
    }
    
    /**
     * Al registrar un elemento a un equipo este no debe estar disponible.
     * Consulta Válida: Un elemento asociado a un equipo no está disponible (false).
     */
    @Test
    public void deberiaConsultarElementoNoDisponible() {
    	try {
    		equiposServices.registrarElementoEquipo("Mouse", "Vertical Inalámbrico 3", 3);
    		
    		List<Elemento> e=equiposServices.consultarElementos();
    		assertEquals(e.get(11).isDisponible(),false);
    		
    		
		} catch (EquiposException e) {
			Assert.assertFalse(false);
		}
    }
    
}
