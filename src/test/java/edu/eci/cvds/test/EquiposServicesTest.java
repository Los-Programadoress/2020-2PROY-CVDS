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

    
}