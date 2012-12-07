package com.visa.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.visa.VisaCoreTest;
import com.visa.jdbc.ExecuteProcedure;

public class VisaJdbcTemplateDAOTest extends VisaCoreTest {

	@Autowired
	com.visa.dao.jdbc.VisaJdbcTemplateDAO visaJdbcTemplateDAO;

	@Test
	public void obtenerCarrerasPostgradoTest() {
		Map results = new HashMap();
		results = visaJdbcTemplateDAO.obtenerCarrerasPostgrado("CL20031506");
		ExecuteProcedure.printMap(results);

	}
	@Test
	public void obtenerCarrerasPostulanteTest() {
		Map results = new HashMap();
		results = visaJdbcTemplateDAO.obtenerCarrerasPostulante("PA20032038");
		ExecuteProcedure.printMap(results);

	}
	@Test
	public void obtenerCarrerasProspectoTest() {
		Map results = new HashMap();
		results = visaJdbcTemplateDAO.obtenerCarrerasProspecto("0001174", new Integer(1));
		ExecuteProcedure.printMap(results);
		List lista = ExecuteProcedure.retornaLista(results);
		System.out.println(lista.size());

	}
	
}