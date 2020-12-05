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

    
}