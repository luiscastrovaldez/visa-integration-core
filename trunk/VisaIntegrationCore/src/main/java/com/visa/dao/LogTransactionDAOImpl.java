package com.visa.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.visa.domain.LogTransaction;

@Repository
public class LogTransactionDAOImpl extends HibernateDaoSupport implements LogTransactionDAO {

	@Autowired
	public LogTransactionDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	public LogTransaction findById(Serializable id) {
		return getHibernateTemplate().get(LogTransaction.class, id);
	}

	
	
}
