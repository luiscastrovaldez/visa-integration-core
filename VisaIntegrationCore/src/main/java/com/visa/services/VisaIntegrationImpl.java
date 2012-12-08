package com.visa.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.dao.LogTransactionDAO;
import com.visa.dao.jdbc.VisaJdbcTemplateDAO;
import com.visa.domain.Carrera;
import com.visa.domain.LogTransaction;

@Service("visaIntegration")
public class VisaIntegrationImpl implements VisaIntegration {

	@Autowired
	LogTransactionDAO logTransactionDAO;
	
	
	@Autowired
	VisaJdbcTemplateDAO visaJdbcTemplateDAO;
	

	public LogTransaction findById(Serializable id) {
		return logTransactionDAO.findById(id);
	}
	
	public List<Carrera> obtenerCarrerasPostgrado(String psAlumno) throws Exception {
		return visaJdbcTemplateDAO.obtenerCarrerasPostgrado(psAlumno);
	}

}
