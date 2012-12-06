package com.visa.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.visa.VisaCoreTest;
import com.visa.domain.LogTransaction;

public class LogTransactionServicesTest extends VisaCoreTest{

	@Autowired
	VisaIntegration visaIntegration;
	
	@Test
	public void findLogTransactionByIdTest(){
		LogTransaction logTransaction = visaIntegration.findById(1L);
		if (logTransaction != null){
			System.out.println(" id = "+ logTransaction.getId());
		}
	}

}
