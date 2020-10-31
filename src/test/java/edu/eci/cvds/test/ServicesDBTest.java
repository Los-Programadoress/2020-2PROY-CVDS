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
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=PostgreSQL", "anonymous", "");
        Statement stmt = conn.createStatement();
        stmt.execute("DELETE from usuario");
        stmt.execute("DELETE from rol");
        //stmt.execute("delete sequence ROL_seq");
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
    
    @Test
    public void pruebaCeroTest() throws SQLException, EquiposException {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        Connection conn=getConnection();
        Statement stmt=conn.createStatement(); 
        //stmt.execute("DELETE from usuario");
        //stmt.execute("DELETE from rol");
        //stmt.execute("CREATE SEQUENCE ROL_seq");
        stmt.execute("INSERT INTO `rol` (`id`,`nombreRol`) VALUES (1,'Administrativo')");
        //stmt.execute("INSERT INTO `USUARIO` (`idCorreo`, `correo`, `nombre` , `rol_id` , `estado`, `contrasena`) VALUES ('pelo.perez','pelo.perez@mail.escuelaing.edu.co','Pablo Perez', 2,'Inactivo','eciPablo')");
        conn.commit();
        conn.close();
	
        //Realizar la operacion de la logica y la prueba
        
        //Assert.fail("Pruebas no implementadas aun...");
        
    }    

}
