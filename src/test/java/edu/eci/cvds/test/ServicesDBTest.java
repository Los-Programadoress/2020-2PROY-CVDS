package edu.eci.cvds.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.eci.cvds.services.EquiposException;

/**
 * Testing con la base de datos
 *
 */
public class ServicesDBTest {

	public ServicesDBTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        stmt.execute("DELETE FROM EQUIPO");
        stmt.execute("DELETE FROM USUARIO");
        conn.commit();
        conn.close();
    }

    /**
     * Obtiene una conexion a la base de datos de prueba
     * @return
     * @throws SQLException 
     */
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=PostgreSQL", "anonymous", "");        
    }
    
    /**
     * Realiza operaciones con la base de datos
     * @throws SQLException
     * @throws EquiposException
     */
    @Test
    public void pruebaCeroTest() throws SQLException, EquiposException {
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();
        //Insertar datos en la base de datos de pruebas
        stmt.execute("INSERT INTO `USUARIO` (`idCorreo`, `correo`, `nombre` , `estado`, `contrasena`) VALUES('maria.alfaro','maria.alfaro@mail.escuelaing.edu.co', 'Angelica Alfaro','Activo','44f632480c49db38c4d0cbc2bea2384049c74a689baf5bf576163455787185a3')"); 
        stmt.execute("INSERT INTO `EQUIPO` (`marca`, `usuario_idcorreo`) VALUES('LG','maria.alfaro')"); 
        conn.commit();
        conn.close();
	
        //Realizar la operacion de la logica y la prueba
        
        //Assert.fail("Pruebas no implementadas aun...");
        
    }    

}
