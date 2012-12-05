package com.visa.dao.jdbc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.visa.commons.Constants;

@Repository
public class VisaJdbcTemplateDAOImpl extends HibernateDaoSupport implements
		VisaJdbcTemplateDAO {

	@Autowired
	public VisaJdbcTemplateDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private DataSource dataSource;


	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	private static void printMap(Map results) {
		for (Iterator it = results.entrySet().iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}

	private class ExecuteProcedure extends StoredProcedure {

		public ExecuteProcedure(DataSource ds) {
			setDataSource(ds);
			// setFunction(true);
			setSql(Constants.PROCEDURE);
			declareParameter(new SqlParameter("p_account_number", Types.VARCHAR));
			// declareParameter(new SqlOutParameter("date", Types.DATE));
			compile();
		}

		public Map execute() {
			// the 'sysdate' sproc has no input parameters, so an empty Map is
			// supplied...

			Map inputs = new HashMap();
			inputs.put("p_account_number", "09080");

			// return execute(new HashMap());
			return execute(inputs);
		}
	}

	public void callStoreProcedure() {
		// TODO Auto-generated method stub
		
		this.dataSource = SessionFactoryUtils.getDataSource(getSession()
				.getSessionFactory());
		ExecuteProcedure sproc = new ExecuteProcedure(dataSource);
		Map results = sproc.execute();
		
	}

}
