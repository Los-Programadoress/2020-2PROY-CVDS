package edu.eci.cvds.services.client;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ElementoMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.EquipoMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;
import edu.eci.cvds.services.EquiposException;

public class MyBatisMain {
	/**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }
    
    /**
     * Programa que prueba sentencias SQL (mappers)
     * @throws SQLException 
     */
    public static void usingSQL() throws SQLException{
    	SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();
        
        //Consultar 
        /*UsuarioMapper cm=sqlss.getMapper(UsuarioMapper.class);
        System.out.println(cm.consultarUsuario("maria.alfaro")); */
        
        //Usuario usuario = new Usuario("maria.alfaro","maria.alfaro@mail.escuelaing.edu.co", "Angelica Alfaro","Activo","44f632480c49db38c4d0cbc2bea2384049c74a689baf5bf576163455787185a3");  		
		
        
        EquipoMapper cm2=sqlss.getMapper(EquipoMapper.class);
        /*UsuarioMapper cm2=sqlss.getMapper(UsuarioMapper.class);
        Usuario u = cm2.consultarUsuario("cesar.ortiz");
        cm.registrarEquipo("LG", true, u.getIdCorreo());*/
        
        //System.out.println(cm.consultarEquipo(1));
        ElementoMapper cm3=sqlss.getMapper(ElementoMapper.class);
        System.out.println(cm3.consultarElementos());
        //cm.registrarElemento("Torre", "Completa E-ATX", false);
        //System.out.println(cm.consultarElementosEquipo(6));
        /*UsuarioMapper cm=sqlss.getMapper(UsuarioMapper.class);
        Usuario u = cm.consultarUsuario("maria.alfaro");   		
		cm2.registrarEquipo("TOSHIBA", true, u.getIdCorreo());
		cm3.registrarElementoEquipo("Mouse", "Vertical Inalámbrico",false, 1);
		cm3.registrarElementoEquipo("Pantalla", "LED",false, 1);
		cm3.registrarElementoEquipo("Torre", "V530 AIO",false, 1);
		cm3.registrarElementoEquipo("Teclado", "Flexible",false, 1);
		Equipo e = cm2.consultarEquipo(1);
		System.out.println(cm2.consultarElementosEquipo(1));*/
        
        
        sqlss.commit();      
        sqlss.close();
    }
    
    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     * @throws EquiposException
     */
    public static void main(String args[]) throws  SQLException, EquiposException {
    	usingSQL();
    }
}
