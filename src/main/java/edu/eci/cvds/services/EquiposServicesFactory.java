package edu.eci.cvds.services;

import com.google.inject.Injector;

import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBATISUsuarioDAO;
import edu.eci.cvds.services.impl.EquiposServicesImpl;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import java.util.Optional;
import static com.google.inject.Guice.createInjector;

public class EquiposServicesFactory {

	private static EquiposServicesFactory instance = new EquiposServicesFactory();

	   private static Optional<Injector> optInjector;

	   private Injector myBatisInjector(String env, String pathResource, JdbcHelper jdbcHelper) {
	       return createInjector(new XMLMyBatisModule() {
	           @Override
	           protected void initialize() {
	               setEnvironmentId(env);
	               install(jdbcHelper);
	               setClassPathResource(pathResource);
	               bind(EquiposServices.class).to(EquiposServicesImpl.class);
	               bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
	           }
	       });
	   }

	   private EquiposServicesFactory(){
	       optInjector = Optional.empty();
	   }

	   public EquiposServices getEquiposServices(){
	       if (!optInjector.isPresent()) {
	           optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml", JdbcHelper.PostgreSQL));
	       }

	       return optInjector.get().getInstance(EquiposServices.class);
	   }


	   public EquiposServices getEquiposServicesTesting(){
	       if (!optInjector.isPresent()) {
	           optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml", JdbcHelper.PostgreSQL));
	       }

	       return optInjector.get().getInstance(EquiposServices.class);
	   }


	   public static EquiposServicesFactory getInstance(){
	       return instance;
	   }
}
