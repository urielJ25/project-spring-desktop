/**
 * 
 */
package com.devpredator.projectspringdesktop.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.devpredator.projectspringdesktop.dao.DisqueraDAO;
import com.devpredator.projectspringdesktop.dao.impl.DisqueraDAOImpl;

/**
 * @author cesarjimenez
 * 
 * CLASE DE PRUEBA UNITARIA QUE PERMITE REALIZAR PRUEBAS EN SPRING
 * 
 */
class SpringDesktopTest {

	@Test
	void testContext() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");// prueba para xml
		assertNotNull(context);// Verificar el contexto llegue con información
	
		DisqueraDAO disqueraDAO = (DisqueraDAO) context.getBean("disqueraDAO");
		assertNotNull(disqueraDAO);
		
		DisqueraDAO disqueraDAONuevo = (DisqueraDAO) context.getBean("disqueraDAO");
		
		DisqueraDAO disqueraDAO2inSpringDao = new DisqueraDAOImpl();
		DisqueraDAO disqueraDAO2inSpringDaoNuevo = new DisqueraDAOImpl();
		
		System.out.println("Contexto cargado correctamente");
		System.out.println(disqueraDAO);
		System.out.println(disqueraDAONuevo);
		
		System.out.println(disqueraDAO2inSpringDao);
		System.out.println(disqueraDAO2inSpringDaoNuevo);
	
		// PROPERTIES
		
		Properties properties = (Properties) context.getBean("properties");
		
		System.out.println(properties.get("spring-username"));
	}

}
