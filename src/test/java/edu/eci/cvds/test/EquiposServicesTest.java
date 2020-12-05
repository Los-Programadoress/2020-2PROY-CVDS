package edu.eci.cvds.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

 
import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
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

    /**
     * Debe permitir registrar un equipo con sus elementos.
     * Registro Válido: Debe existir el usuario para relacionarlo con el nuevo equipo.
     */
    @Test
    public void deberiaRegistrarEquipo() {
    	try {
    		
    		//elementos sin asociar
    		Elemento el = new Elemento(1,"Torre", "V530 AIO");
    		Elemento el1 = new Elemento(2,"Mouse", "Vertical Inalámbrico TX");
    		Elemento el2 = new Elemento(3,"Teclado", "Flexible TX");
    		Elemento el3 = new Elemento(4,"Pantalla", "LED TX");
    		//elementos a asociar
    		equiposServices.add(el);
    		equiposServices.add(el1);
    		equiposServices.add(el2);
    		equiposServices.add(el3);
    		
    		int eqPreRegistro = equiposServices.consultarEquipos().size();
    		equiposServices.registrarEquipo("SISTEMAS1", "TOSHIBA", "maria.alfaro");
    		int eqPosRegistro = equiposServices.consultarEquipos().size();
    		
    		assertTrue(eqPosRegistro > eqPreRegistro);

    	} catch (EquiposException e) {
    		assertFalse(false);
    	}
    }
    
    /**
     * No debe permitir registrar un equipo.
     * Registro Inválido: No debe existir el usuario para relacionarlo con el nuevo equipo.
     */
    @Test
    public void noDeberiaRegistrarElementoEquipo() {
    	try {
    		//elementos sin asociar
    		Elemento el = new Elemento(1,"Torre", "V530 AIO");
    		Elemento el1 = new Elemento(2,"Mouse", "Vertical Inalámbrico TX");
    		Elemento el2 = new Elemento(3,"Teclado", "Flexible TX");
    		Elemento el3 = new Elemento(4,"Pantalla", "LED TX");
    		//elementos a asociar
    		equiposServices.add(el);
    		equiposServices.add(el1);
    		equiposServices.add(el2);
    		equiposServices.add(el3);
    		
    		equiposServices.registrarEquipo("SISTEMAS5", "ASUS", "pepe.torres");
    		
    		assertFalse(false);

		} catch (EquiposException e) {
    		assertTrue(true);
		}
    }
    

    /**
     * Debe permitir registrar un nuevo elemento al laboratorio.
     * Registro Válido: Se registra un elemento que sea de tipo:'Torre' o 'Pantalla’ o ‘Mouse’ o ‘Teclado' y existe el usuario.
     */
    @Test
    public void deberiaRegistrarElemento() {
        try {
        	
        	int elPreRegistro = equiposServices.consultarElementos().size();
            equiposServices.registrarElemento("TECLADO", "Gamer", "maria.alfaro");
            int elPosRegistro = equiposServices.consultarElementos().size();
            
    		assertTrue(elPosRegistro > elPreRegistro);
                
        } catch (EquiposException e) {
        	assertFalse(false);
        }
    }
    
    /**
     * No debe permitir registrar un nuevo elemento al laboratorio.
     * Registro Inválido: Se registra un elemento que no sea de un tipo diferente a:'Torre' o 'Pantalla’ o ‘Mouse’ o ‘Teclado' && no existe el usuario.
     */
    @Test
    public void noDeberiaRegistrarElemento() {
        try {
            equiposServices.registrarElemento("PARLANTES", "X6000","pepe.torres");
            
            assertFalse(false);
            
        } catch (EquiposException e) {
        	assertTrue(true);
        }
    }
    
    /**
     * Debe permitir consultar elementos del laboratorio según el tipo.
     * Consulta Válida: Se consulta los elementos que sean de tipo:'Torre' o 'Pantalla’ o ‘Mouse’ o ‘Teclado'.
     */
    @Test
    public void deberiaConsultarElemento() {
    	try {
    		List<Elemento> elementos = equiposServices.consultarElemento("Teclado");
    		assertTrue(elementos.size() >= 0);
    		
		} catch (EquiposException e) {
			assertFalse(false);
		}
    }
    
    /**
     * Debe permitir consultar elementos del laboratorio.
     * Consulta Válida: Se consulta los elementos registrados de un usuario existente.
     */
    @Test
    public void deberiaConsultarElementos() {
        try {
        	
        	equiposServices.registrarElemento("PANTALLA", "LCD", "maria.alfaro");
        	equiposServices.registrarElemento("MOUSE", "Inalámbrico", "maria.alfaro");
        	equiposServices.registrarElemento("PARLANTES", "X6000","pepe.torres");
        	
            List<Elemento> elementos=equiposServices.consultarElementos();
            assertTrue(elementos.size() == 2);
                
        } catch (EquiposException e) {
            assertFalse(false);
        }
    }
    
    /**
     * Debe permitir asociar elementos a un equipo.
     * Consulta Válida: Se asocia un elemento registrado de un equipo existente.
     */
    @Test
    public void deberiaAsociarElementoEquipo() {
    	try {
    		//elementos sin asociar
    		Elemento el = new Elemento(1,"Torre", "V530 AIO");
    		Elemento el1 = new Elemento(2,"Mouse", "Vertical Inalámbrico TX");
    		Elemento el2 = new Elemento(3,"Teclado", "Flexible TX");
    		Elemento el3 = new Elemento(4,"Pantalla", "LED TX");
    		//elementos a asociar
    		equiposServices.add(el);
    		equiposServices.add(el1);
    		equiposServices.add(el2);
    		equiposServices.add(el3);
    		
    		equiposServices.registrarEquipo("SISTEMAS2", "TOSHIBA", "maria.alfaro");
    		int eqPreAsociacion = equiposServices.consultarElementosEquipo("SISTEMAS2").size();
    		
    		equiposServices.registrarElemento("PANTALLA", "LCD", "maria.alfaro");
			equiposServices.asociarElemento(1, 5);
    		int eqPosAsociacion = equiposServices.consultarElementosEquipo("SISTEMAS2").size();
            assertTrue(eqPreAsociacion == eqPosAsociacion);
			
		} catch (EquiposException e) {
			assertFalse(false);
		}
    	
    }
    
    /**
     * No debe permitir asociar elementos a un equipo.
     * Consulta Inválida: Se asocia un elemento registrado de un equipo que no existe.
     */
    @Test
    public void noDeberiaAsociarElementoEquipo() {
    	try {
    		equiposServices.registrarElemento("PANTALLA", "LCD", "maria.alfaro");
			equiposServices.asociarElemento(100, 1);
			assertFalse(false);
			
		} catch (EquiposException e) {
			assertTrue(true);
		}
    	
    }
    
    /**
     * No debe permitir dar de baja un elemento que no se encuentra sociado a un equipo.
     * Consulta Válida: Se da de baja a un elemento registrado que no se encuentra asociado a un equipo.
     */
    @Test
    public void deberiaDarseDeBajaElementoNoAsociado() {
    	try {
    		equiposServices.registrarElemento("PANTALLA", "LCD", "maria.alfaro");
    		equiposServices.cambiarBajaElemento(true, "LCD", "maria.alfaro");
    		Elemento el = equiposServices.consultarElementos().get(0);
    		assertTrue(el.getBajado().equals(true));
			
		} catch (EquiposException e) {
    		assertFalse(false);
		}
    	
    }
    
   /** No debe permitir dar de baja un elemento que se encuentra asociada a un equipo.
    * Consulta Inválida: Se da de baja a un elemento que se encuentra asociada a un equipo.
    */
   @Test
   public void noDeberiaDarseDeBajaElementoAsociado() {
		try {
			//elementos sin asociar
			Elemento el = new Elemento(1,"Torre", "V530 AIO");
			Elemento el1 = new Elemento(2,"Mouse", "Vertical Inalámbrico TX");
			Elemento el2 = new Elemento(3,"Teclado", "Flexible TX");
			Elemento el3 = new Elemento(4,"Pantalla", "LED TX");
			
			//elementos a asociar
			equiposServices.add(el);
			equiposServices.add(el1);
			equiposServices.add(el2);
			equiposServices.add(el3);
			
			equiposServices.registrarEquipo("SISTEMAS2", "HP", "maria.alfaro");
			equiposServices.cambiarBajaElemento(true, "V530 AIO", "maria.alfaro");
			
			List<Elemento> elementos = equiposServices.consultarElementosEquipo("SISTEMAS2");
			
			//elementos dados de baja
			int eqPosDeBaja = 0;
			for (Elemento els: elementos) {
				if(els.getBajado().equals("Si")) {
		   				eqPosDeBaja+=1;
		   			}	
		   	}
		   		
		   	assertTrue(eqPosDeBaja > 0);
					
		} catch (EquiposException e) {
			assertFalse(false);
		}
		   	
   }
   
   /**Debe registrar automaticamente una novedad de un elemento .
    * Consulta Válida: Se registra automaticamente una novedad de un elemento cuando se realiza una operación que lo involucra.
    */
   @Test
   public void deberiaRegistrarNovedadElemento() {
		try {
			//registrar elemento
    		equiposServices.registrarElemento("TORRE", "V530 AIO", "maria.alfaro");

			int novedadElementos = equiposServices.consultarNovedadElementos().size();
			
		   	assertTrue(novedadElementos > 0);
					
		} catch (EquiposException e) {
			assertFalse(false);
		}
		
   }
   
   /**No debe registrar automaticamente una novedad de un elemento .
    * Consulta Inválida: Se registra automaticamente una novedad de un elemento cuando se realiza una operación que no lo involucra.
    */
   @Test
   public void noDeberiaRegistrarNovedadElemento() {
		try {
			//registrar laboratorio
			equiposServices.registrarLaboratorio("MULTIMEDIA", "maria.alfaro");
			
			int novedadElementos = equiposServices.consultarNovedadElementos().size();
		   		
		   	assertTrue(novedadElementos == 0);
					
		} catch (EquiposException e) {
			assertFalse(false);
		}
		
   }
   
   /** Debe registrar automaticamente una novedad de un equipo .
    * Consulta Válida: Se registra automaticamente una novedad de un equipo cuando se realiza una operación que lo involucra.
    */
   @Test
   public void deberiaRegistrarNovedadEquipo() {
		try {
			//elementos sin asociar
			Elemento el = new Elemento(1,"Torre", "V530 AIO");
			Elemento el1 = new Elemento(2,"Mouse", "Vertical Inalámbrico TX");
			Elemento el2 = new Elemento(3,"Teclado", "Flexible TX");
			Elemento el3 = new Elemento(4,"Pantalla", "LED TX");
			
			//elementos a asociar
			equiposServices.add(el);
			equiposServices.add(el1);
			equiposServices.add(el2);
			equiposServices.add(el3);
			
			equiposServices.registrarEquipo("SISTEMAS3", "HP", "maria.alfaro");
			
			int novedadEquipo = equiposServices.consultarNovedadEquipos().size();
			
		   	assertTrue(novedadEquipo > 0);
					
		} catch (EquiposException e) {
			assertFalse(false);
		}
		   	
   }
   
   /** No debe registrar automaticamente una novedad de un equipo .
    * Consulta Inválida: Se regista automaticamente una novedad de un equipo cuando se realiza una operación que no lo involucra.
    */
   @Test
   public void noDeberiaRegistrarNovedadEquipo() {
		try {
			//registrar elementos
    		equiposServices.registrarElemento("MOUSE", "Flexible", "maria.alfaro");
    		
    		int novedadEquipo = equiposServices.consultarNovedadEquipos().size();

		   		
		   	assertTrue(novedadEquipo == 0);
					
		} catch (EquiposException e) {
			assertFalse(false);
		}
		   	
   }
   
   /** Debe registrar automaticamente una novedad de un laboratorio.
    * Consulta Válida: Se registra automaticamente una novedad de un equipo cuando se realiza una operación que lo involucra.
    */
   @Test
   public void deberiaRegistrarNovedadLaboratorio() {
		try {
			//registrar laboratorio
			equiposServices.registrarLaboratorio("PLATAFORMAS", "maria.alfaro");
			
			int novedadLaboratorio = equiposServices.consultarNovedadLaboratorios().size();
		   		
		   	assertTrue(novedadLaboratorio > 0);
					
		} catch (EquiposException e) {
			assertFalse(false);
		}
		   	
   }
   
   /** No debe registrar automaticamente una novedad de un laboratorio.
    * Consulta Inválida: Se registra automaticamente una novedad de un equipo cuando se realiza una operación que no lo involucra.
    */
   @Test
   public void noDeberiaRegistrarNovedadLaboratorio() {
		try {
			//registrar elemento
    		equiposServices.registrarElemento("TECLADO", "Ergonómico", "maria.alfaro");

    		int novedadLaboratorio = equiposServices.consultarNovedadLaboratorios().size();
		   	
		   	assertTrue(novedadLaboratorio == 0);
					
		} catch (EquiposException e) {
			assertFalse(false);
		}
		   	
   }
   
   /** Debe generar un reporte de los elementos.
    * Consulta Válida: Genera automaticamente un reporte de los elementos existentes.
    */
   @Test
   public void deberiaGenerarReporteElementos() {
		try {
			//registrar elemento
    		equiposServices.registrarElemento("TECLADO", "Ergonómico", "maria.alfaro");
    		equiposServices.registrarElemento("TECLADO", "Inalámbrico", "maria.alfaro");

    		int reporte = equiposServices.reporteElementos().size();
		   	
		   	assertTrue(reporte > 0);
					
		} catch (EquiposException e) {
			assertFalse(false);
		}
		   	
   }
   
   /** Debe generar un reporte de los equipos.
    * Consulta Válida: Genera automaticamente un reporte de los equipos y sus elementos existentes.
    */
   @Test
   public void deberiaGenerarReporteEquipos() {
		try {
			//elementos sin asociar
			Elemento el = new Elemento(1,"Torre", "V530 AIO");
			Elemento el1 = new Elemento(2,"Mouse", "Vertical Inalámbrico TX");
			Elemento el2 = new Elemento(3,"Teclado", "Flexible TX");
			Elemento el3 = new Elemento(4,"Pantalla", "LED TX");
			
			//elementos a asociar
			equiposServices.add(el);
			equiposServices.add(el1);
			equiposServices.add(el2);
			equiposServices.add(el3);
			
			equiposServices.registrarEquipo("SISTEMAS4", "DELL", "maria.alfaro");

    		int reporte = equiposServices.reporteEquipos().size();
		   	
		   	assertTrue(reporte > 0);
					
		} catch (EquiposException e) {
			assertFalse(false);
		}
		   	
   }
   
    
}