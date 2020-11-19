package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import edu.eci.cvds.persistence.ElementoDAO;
import edu.eci.cvds.persistence.EquipoDAO;
import edu.eci.cvds.persistence.LaboratorioDAO;
import edu.eci.cvds.persistence.NovedadDAO;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBATISElementoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBATISEquipoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBATISLaboratorioDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBATISNovedadDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBATISUsuarioDAO;
import edu.eci.cvds.services.EquiposServices;
import edu.eci.cvds.services.impl.EquiposServicesImpl;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
* Clase que permite crear y configurar el inyector 
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                bind(EquipoDAO.class).to(MyBATISEquipoDAO.class);
                bind(ElementoDAO.class).to(MyBATISElementoDAO.class);
                bind(LaboratorioDAO.class).to(MyBATISLaboratorioDAO.class);
                bind(NovedadDAO.class).to(MyBATISNovedadDAO.class);
                bind(EquiposServices.class).to(EquiposServicesImpl.class);
            }
        });
        
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}