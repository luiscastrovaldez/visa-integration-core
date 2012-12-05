package com.visa.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.visa.VisaCoreTest;

public class LogTransactionDAOTest extends VisaCoreTest{

	@Autowired
	LogTransactionDAO logTransactionDAO;
	
	@Test
	public void findLogTransactionByIdTest(){
		logTransactionDAO.findById(1L);
	}

}
