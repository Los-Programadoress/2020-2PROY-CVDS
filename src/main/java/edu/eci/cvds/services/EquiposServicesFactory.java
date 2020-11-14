package edu.eci.cvds.services;

import com.google.inject.Injector;
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
import edu.eci.cvds.services.impl.EquiposServicesImpl;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import java.util.Optional;
import static com.google.inject.Guice.createInjector;

/**
* Clase fábrica de los servicios
* @author: Angélica Alfaro - Laura Izquierdo - César Ortiz
* @version: 1.0
*/
public class EquiposServicesFactory {

	   private static EquiposServicesFactory instance = new EquiposServicesFactory();

	   private static Optional<Injector> optInjector;

	   private Injector myBatisInjector(String env, String pathResource) {
	       return createInjector(new XMLMyBatisModule() {
	           @Override
	           protected void initialize() {
	               setEnvironmentId(env);
	               setClassPathResource(pathResource);
	               bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
	               bind(EquipoDAO.class).to(MyBATISEquipoDAO.class);
	               bind(ElementoDAO.class).to(MyBATISElementoDAO.class);
	               bind(LaboratorioDAO.class).to(MyBATISLaboratorioDAO.class);
	               bind(NovedadDAO.class).to(MyBATISNovedadDAO.class);
	               bind(EquiposServices.class).to(EquiposServicesImpl.class);
	           }
	       });
	   }

	   private EquiposServicesFactory(){
	       optInjector = Optional.empty();
	   }

	   public EquiposServices getEquiposServices(){
	       if (!optInjector.isPresent()) {
	           optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
	       }

	       return optInjector.get().getInstance(EquiposServices.class);
	   }


	   public EquiposServices getEquiposServicesTesting(){
	       if (!optInjector.isPresent()) {
	    	   optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
	       }

	       return optInjector.get().getInstance(EquiposServices.class);
	   }


	   public static EquiposServicesFactory getInstance(){
	       return instance;
	   }
}
