package com.visa.services;

import java.io.Serializable;
import java.util.List;

import com.visa.domain.Carrera;
import com.visa.domain.LogTransaction;

public interface VisaIntegration {

	LogTransaction findById(Serializable id);
	
	List<Carrera> obtenerCarrerasPostgrado(String psAlumno) throws Exception;

}
