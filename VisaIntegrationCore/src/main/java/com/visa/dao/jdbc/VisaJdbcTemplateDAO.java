package com.visa.dao.jdbc;

import java.util.Map;

public interface VisaJdbcTemplateDAO {

	
	Map obtenerCarrerasPostgrado(String psAlumno);
	Map obtenerCarrerasPostulante(String psPostulante);
	Map obtenerCarrerasProspecto(String psProspecto, Integer psAtencion);
}
