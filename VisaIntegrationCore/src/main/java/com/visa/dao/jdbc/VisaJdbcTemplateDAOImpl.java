package com.visa.dao.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.visa.commons.Constants;
import com.visa.domain.Carrera;
import com.visa.jdbc.ExecuteProcedure;

@Repository
public class VisaJdbcTemplateDAOImpl extends HibernateDaoSupport implements
		VisaJdbcTemplateDAO {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private DataSource dataSource;

	@Autowired
	public VisaJdbcTemplateDAOImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	public Map obtenerCarrerasPostgrado(String psAlumno) {
		// TODO Auto-generated method stub

		dataSource = SessionFactoryUtils.getDataSource(getSession()
				.getSessionFactory());
		List<SqlParameter> paramsInput = new ArrayList<SqlParameter>();
		paramsInput.add(new SqlParameter(Constants.PS_ALUMNO, OracleTypes.NVARCHAR));
		
		List<SqlOutParameter> paramsOutput = new ArrayList<SqlOutParameter>();
		paramsOutput.add(new SqlOutParameter(Constants.P_CURSOR, OracleTypes.CURSOR,new Carrera()));
		
		ExecuteProcedure sproc = new ExecuteProcedure(dataSource,Constants.SP_OBTENERCARRERASPOSTGRADO, paramsInput,paramsOutput);
		Map inputs = new HashMap();
		inputs.put(Constants.PS_ALUMNO,psAlumno);
		Map results = sproc.executeSp(inputs);
		
		return results;
 
	}
	
	public Map obtenerCarrerasPostulante(String psPostulante) {
		// TODO Auto-generated method stub

		dataSource = SessionFactoryUtils.getDataSource(getSession()
				.getSessionFactory());
		List<SqlParameter> paramsInput = new ArrayList<SqlParameter>();
		paramsInput.add(new SqlParameter(Constants.PS_POSTULANTE, OracleTypes.NVARCHAR));
		
		List<SqlOutParameter> paramsOutput = new ArrayList<SqlOutParameter>();
		paramsOutput.add(new SqlOutParameter(Constants.P_CURSOR, OracleTypes.CURSOR,new Carrera()));
		
		ExecuteProcedure sproc = new ExecuteProcedure(dataSource,Constants.SP_OBTENERCARRERASPOSTULANTE, paramsInput,paramsOutput);
		Map inputs = new HashMap();
		inputs.put(Constants.PS_POSTULANTE,psPostulante);
		Map results = sproc.executeSp(inputs);
		
		return results;
 
	}
	
	public Map obtenerCarrerasProspecto(String psProspecto, Integer psAtencion) {
		// TODO Auto-generated method stub

		dataSource = SessionFactoryUtils.getDataSource(getSession()
				.getSessionFactory());
		List<SqlParameter> paramsInput = new ArrayList<SqlParameter>();
		paramsInput.add(new SqlParameter(Constants.PS_PROSPECTO, OracleTypes.NVARCHAR));
		paramsInput.add(new SqlParameter(Constants.PS_ATENCION, OracleTypes.INTEGER));
		
		List<SqlOutParameter> paramsOutput = new ArrayList<SqlOutParameter>();
		paramsOutput.add(new SqlOutParameter(Constants.P_CURSOR, OracleTypes.CURSOR,new Carrera()));
		
		ExecuteProcedure sproc = new ExecuteProcedure(dataSource,Constants.SP_OBTENERCARRERASPROSPECTO, paramsInput,paramsOutput);
		Map inputs = new HashMap();
		inputs.put(Constants.PS_PROSPECTO,psProspecto);
		inputs.put(Constants.PS_ATENCION,psAtencion);
		Map results = sproc.executeSp(inputs);
		
		return results;
 
	}

}
