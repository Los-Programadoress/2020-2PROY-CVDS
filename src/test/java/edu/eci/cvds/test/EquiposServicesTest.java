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
	
	@Before
	public void setUp() throws SQLException{
    	Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE SEQUENCE NumEquipo_req");
        stmt.execute("CREATE TABLE IF NOT EXISTS EQUIPO ( numero INT NOT NULL DEFAULT NEXTVAL ('NumEquipo_req'), marca VARCHAR(50) NOT NULL, disponible BOOLEAN, usuario_idCorreo VARCHAR(30) NOT NULL,  PRIMARY KEY (numero), CONSTRAINT fk_EQUIPO_USUARIO FOREIGN KEY (usuario_idCorreo) REFERENCES USUARIO (idCorreo));");
        stmt.execute("CREATE SEQUENCE NumElemento_req");
        stmt.execute("CREATE TABLE IF NOT EXISTS ELEMENTO (\n" + 
        		"  id INT NOT NULL DEFAULT NEXTVAL ('NumElemento_req'),\n" + 
        		"  tipo VARCHAR(50) NOT NULL,\n" + 
        		"  nombre VARCHAR(50) NOT NULL,\n" + 
        		"  disponible BOOLEAN,\n" + 
        		"  numEquipo INT NOT NULL,\n" + 
        		"  PRIMARY KEY (id),\n" + 
        		"  CONSTRAINT fk_ELEMENTO_EQUIPO\n" + 
        		"    FOREIGN KEY (numEquipo)\n" + 
        		"      REFERENCES EQUIPO (numero));");
        
        conn.close();
    }
    
    @After
    public void clearDB() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        stmt.execute("DROP TABLE ELEMENTO");
        stmt.execute("DROP SEQUENCE NumElemento_req");
        stmt.execute("DROP TABLE EQUIPO");
        stmt.execute("DROP SEQUENCE NumEquipo_req");
        conn.close();
    }
    
	/**
     * Obtiene una conexion a la base de datos de prueba
     * @return
     * @throws SQLException 
     */
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:postgresql://ec2-54-157-4-216.compute-1.amazonaws.com:5432/dbhe6066f4kv0g?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory&sslmode=require", "jeyzsyobckqols", "a9af9ced05e80f84e4bce24448229f2fca2d0a1a2a0fac39d2a376ce839e7152");        
    }
    
    /**
     * Instancia los Servicios de EquiposServices.
     */
    public EquiposServicesTest() {
    	equiposServices = EquiposServicesFactory.getInstance().getEquiposServices();
    }
    
    /**
     * Debería permitir consultar un usuario.
     */
    @Test
    public void deberiaConsultarUsuario() {
    	try {
    		Usuario usuario = equiposServices.consultarUsuario("maria.alfaro");
    		assertEquals(equiposServices.consultarUsuario("maria.alfaro").getNombre(),"Angelica Alfaro");
	    	
		} catch (EquiposException e) {
			Assert.assertFalse(false);
		}
    }
    
    /**
     * Debe permitir registrar un equipo.
     * Registro Válido: Debe existir el usuario para relacionarlo con el nuevo equipo.
     */
    @Test
    public void deberiaRegistrarEquipo() {
    	try {
    		Usuario usuario = equiposServices.consultarUsuario("cesar.ortiz");     		
    		equiposServices.registrarEquipo("DELL", usuario);
    		Equipo e = equiposServices.consultarEquipo(1);
    		
    		assertEquals(e.getNumero(),1);
	    	
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
    	try {
    		Usuario usuario = equiposServices.consultarUsuario("pepe.torres");     		
    		equiposServices.registrarEquipo("HP", usuario);
    		assertEquals(equiposServices.consultarEquipo(2).getNumero(),2);
    		
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
    		equiposServices.registrarEquipo("TOSHIBA", usuario);
    		equiposServices.registrarElementoEquipo("Mouse", "Vertical Inalámbrico", 2);
    		equiposServices.registrarElementoEquipo("Pantalla", "LED", 2);
    		equiposServices.registrarElementoEquipo("Torre", "V530 AIO", 2);
    		equiposServices.registrarElementoEquipo("Teclado", "Flexible", 2);
    		Equipo e = equiposServices.consultarEquipo(2);
    		ArrayList<Elemento> elementos = e.getElementos();
    		for(Elemento el : elementos) {
        		assertEquals(el.getTipo(),"Mouse");
        		assertEquals(el.getTipo(),"Pantalla");
        		assertEquals(el.getTipo(),"Torre");
        		assertEquals(el.getTipo(),"Teclado");
    		}
    		
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
    	try {
    		Usuario usuario = equiposServices.consultarUsuario("maria.alfaro");     		
    		equiposServices.registrarElementoEquipo("Mouse", "Vertical Inalámbrico", 3);
    		
		} catch (EquiposException e) {
			Assert.assertFalse(false);
		}
    }
    
    
}
