package com.visa.dao.jdbc;

import java.util.List;
import java.util.Map;

import com.visa.domain.Carrera;

public interface VisaJdbcTemplateDAO {

	
	List<Carrera> obtenerCarrerasPostgrado(String psAlumno) throws Exception;
	List<Carrera> obtenerCarrerasPostulante(String psPostulante) throws Exception;
	List<Carrera> obtenerCarrerasProspecto(String psProspecto, Integer psAtencion) throws Exception;
}
