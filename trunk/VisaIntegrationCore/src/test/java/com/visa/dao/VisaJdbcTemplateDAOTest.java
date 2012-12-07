package com.visa.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.visa.VisaCoreTest;
import com.visa.domain.Carrera;

public class VisaJdbcTemplateDAOTest extends VisaCoreTest {

	@Autowired
	com.visa.dao.jdbc.VisaJdbcTemplateDAO visaJdbcTemplateDAO;

	@Test
	public void obtenerCarrerasPostgradoTest() {
		List<Carrera> carreras;
		try {
			carreras = visaJdbcTemplateDAO.obtenerCarrerasPostgrado("CL20031506");
			Assert.assertNotNull(carreras);
			Assert.assertTrue(carreras.size() != 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	@Test
	public void obtenerCarrerasPostulanteTest() {
		List<Carrera> carreras;
		try {
			carreras = visaJdbcTemplateDAO.obtenerCarrerasPostulante("PA20032038");
			Assert.assertNotNull(carreras);
			Assert.assertTrue(carreras.size() != 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	@Test
	public void obtenerCarrerasProspectoTest() {
		
		List<Carrera> carreras;
		try {
			carreras = visaJdbcTemplateDAO.obtenerCarrerasProspecto("0001174", new Integer(1));
			Assert.assertNotNull(carreras);
			Assert.assertTrue(carreras.size() != 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		

	}
	
}