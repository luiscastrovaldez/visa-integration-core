package com.visa.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.dao.LogTransactionDAO;
import com.visa.domain.LogTransaction;

@Service("visaIntegration")
public class VisaIntegrationImpl implements VisaIntegration {

	@Autowired
	LogTransactionDAO logTransactionDAO;

	public LogTransaction findById(Serializable id) {
		return logTransactionDAO.findById(id);
	}

}
