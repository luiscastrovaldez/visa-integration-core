package com.visa.dao;

import java.io.Serializable;

import com.visa.domain.LogTransaction;

public interface LogTransactionDAO {

	public LogTransaction findById(Serializable id);

}
