package tn.esprit.spring.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {
	
	private static final Logger logger = LogManager.getLogger(EmployeServiceImpl.class);
	
	public EmployeServiceImplTest() {
		logger.info(" Test : Classe EmployeServiceImplTest ...");
	}

	@Autowired
	IEmployeService employeServiceImpl ;
	
	@Test
	public void testAjouterEmployeSuccess() {
		logger.info(" testing methode testAjouterEmploye (Success) .... ");
		assertEquals(1, employeServiceImpl.ajouterEmploye(new Employe("testNom", "testPrenom", "test@ff.com", true, null)));
					
	}
	
	@Test
	public void testAjouterEmployeFailure() {
		logger.info(" testing methode testAjouterEmploye (Failure).... ");
		assertNotEquals(2, employeServiceImpl.ajouterEmploye(new Employe("testNom", "testPrenom", "test@ff.com", true, null)));
					
	}
	
	@Test
	public void testCountEmployeSuccess() {
		logger.info(" testing methode testCountEmploye (Success) .... ");
		assertEquals(1, employeServiceImpl.countEmploye());
						
	}
	
	@Test
	public void testCountEmployeFailure() {
		logger.info(" testing methode testCountEmploye (Failure) .... ");
		assertEquals(3, employeServiceImpl.countEmploye());
						
	}
	
	@Test
	public void testAjouterDepartement() {
		logger.info(" testing methode testAjouterDepartement .... ");
		assertEquals(1, employeServiceImpl.ajouterDepartement(new Departement("Departement xxx")));
						
	}
	
	@Test
	public void testAffecterEmployeADepartementSuccess() {
		logger.info(" testing methode testAffecterEmployeADepartement (Success) .... ");
		assertTrue( "affectation reussi ", employeServiceImpl.affecterEmployeADepartement(1, 1));
						
	}
	
	@Test
	public void testAffecterEmployeADepartementFailure() {
		logger.info(" testing methode testAffecterEmployeADepartement (Failure) .... ");
		assertTrue( "affectation échoué ", employeServiceImpl.affecterEmployeADepartement(0,0));
						
	}
	

}
