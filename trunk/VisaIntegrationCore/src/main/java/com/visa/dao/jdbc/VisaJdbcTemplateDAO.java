package com.visa.dao.jdbc;

import java.util.List;
import java.util.Map;

import com.visa.domain.Carrera;
import com.visa.domain.Concepto;

public interface VisaJdbcTemplateDAO {

	
	List<Carrera> obtenerCarrerasPostgrado(String psAlumno) throws Exception;	
	List<Carrera> obtenerCarrerasPostulante(String psPostulante) throws Exception;
	List<Carrera> obtenerCarrerasProspecto(String psProspecto, Integer psAtencion) throws Exception;
	List<Concepto> obtenerCuotasActuales(String codigoAlumno,String codigoCarrera) throws Exception;
	List<Concepto> obtenerListarCuotasPostulante(String psPostulante) throws Exception;
	List<Concepto> obtenerListarCuotasProspecto(String psProspecto,Integer psAtencion) throws Exception;
}
