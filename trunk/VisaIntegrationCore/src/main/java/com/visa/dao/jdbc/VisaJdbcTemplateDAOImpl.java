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
import com.visa.domain.Concepto;
import com.visa.jdbc.ExecuteProcedure;

@Repository
public class VisaJdbcTemplateDAOImpl extends HibernateDaoSupport implements VisaJdbcTemplateDAO {

  private JdbcTemplate jdbcTemplate;
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  private DataSource dataSource;
  private ExecuteProcedure execSp;

  @Autowired
  public VisaJdbcTemplateDAOImpl(SessionFactory sessionFactory) {
    setSessionFactory(sessionFactory);
  }

  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  @SuppressWarnings("unchecked")
  public List<Carrera> obtenerCarrerasPostgrado(String psAlumno) throws Exception {
    List<SqlParameter> paramsInput = null;
    List<SqlOutParameter> paramsOutput = null;
    Map<String, Object> inputs = null;
    Map<String, Object> results = null;
    List<Carrera> lista = null;
    try {
      dataSource = SessionFactoryUtils.getDataSource(getSession().getSessionFactory());
      paramsInput = new ArrayList<SqlParameter>();
      paramsInput.add(new SqlParameter(Constants.PS_ALUMNO, OracleTypes.NVARCHAR));

      paramsOutput = new ArrayList<SqlOutParameter>();
      paramsOutput.add(new SqlOutParameter(Constants.P_CURSOR, OracleTypes.CURSOR, new Carrera()));

      execSp = new ExecuteProcedure(dataSource, Constants.SP_OBTENERCARRERASPOSTGRADO, paramsInput, paramsOutput);
      inputs = new HashMap<String, Object>();
      inputs.put(Constants.PS_ALUMNO, psAlumno);
      results = execSp.executeSp(inputs);
      lista = ExecuteProcedure.retornaLista(results);
    } catch (Exception e) {
      throw e;
    }

    return lista;

  }

  @SuppressWarnings("unchecked")
  public List<Carrera> obtenerCarrerasPostulante(String psPostulante) throws Exception {
    List<SqlParameter> paramsInput = null;
    List<SqlOutParameter> paramsOutput = null;
    Map<String, Object> inputs = null;
    Map<String, Object> results = null;
    List<Carrera> lista = null;
    try {
      dataSource = SessionFactoryUtils.getDataSource(getSession().getSessionFactory());
      paramsInput = new ArrayList<SqlParameter>();
      paramsInput.add(new SqlParameter(Constants.PS_POSTULANTE, OracleTypes.NVARCHAR));

      paramsOutput = new ArrayList<SqlOutParameter>();
      paramsOutput.add(new SqlOutParameter(Constants.P_CURSOR, OracleTypes.CURSOR, new Carrera()));

      execSp = new ExecuteProcedure(dataSource, Constants.SP_OBTENERCARRERASPOSTULANTE, paramsInput, paramsOutput);
      inputs = new HashMap<String, Object>();
      inputs.put(Constants.PS_POSTULANTE, psPostulante);
      results = execSp.executeSp(inputs);
      lista = ExecuteProcedure.retornaLista(results);

    } catch (Exception e) {
      throw e;
    }

    return lista;

  }

  @SuppressWarnings("unchecked")
  public List<Carrera> obtenerCarrerasProspecto(String psProspecto, Integer psAtencion) throws Exception {
    List<SqlParameter> paramsInput = null;
    List<SqlOutParameter> paramsOutput = null;
    Map<String, Object> inputs = null;
    Map<String, Object> results = null;
    List<Carrera> lista = null;
    try {
      dataSource = SessionFactoryUtils.getDataSource(getSession().getSessionFactory());
      paramsInput = new ArrayList<SqlParameter>();
      paramsInput.add(new SqlParameter(Constants.PS_PROSPECTO, OracleTypes.NVARCHAR));
      paramsInput.add(new SqlParameter(Constants.PS_ATENCION, OracleTypes.INTEGER));

      paramsOutput = new ArrayList<SqlOutParameter>();
      paramsOutput.add(new SqlOutParameter(Constants.P_CURSOR, OracleTypes.CURSOR, new Carrera()));

      execSp = new ExecuteProcedure(dataSource, Constants.SP_OBTENERCARRERASPROSPECTO, paramsInput, paramsOutput);
      inputs = new HashMap<String, Object>();
      inputs.put(Constants.PS_PROSPECTO, psProspecto);
      inputs.put(Constants.PS_ATENCION, psAtencion);
      results = execSp.executeSp(inputs);
      lista = ExecuteProcedure.retornaLista(results);
    } catch (Exception e) {
      throw e;
    }

    return lista;

  }

  @SuppressWarnings("unchecked")
  public List<Concepto> obtenerCuotasActuales(String codigoAlumno, String codigoCarrera) throws Exception {
    List<SqlParameter> paramsInput = null;
    List<SqlOutParameter> paramsOutput = null;
    Map<String, Object> inputs = null;
    Map<String, Object> results = null;
    List<Concepto> lista = null;
    try {
      dataSource = SessionFactoryUtils.getDataSource(getSession().getSessionFactory());
      paramsInput = new ArrayList<SqlParameter>();
      paramsInput.add(new SqlParameter(Constants.PS_ALUMNO, OracleTypes.NVARCHAR));
      paramsInput.add(new SqlParameter(Constants.PS_CARRERA, OracleTypes.NVARCHAR));

      paramsOutput = new ArrayList<SqlOutParameter>();
      paramsOutput.add(new SqlOutParameter(Constants.P_CURSOR, OracleTypes.CURSOR, new Concepto()));

      execSp = new ExecuteProcedure(dataSource, Constants.SPS_CUOTASACTUALES, paramsInput, paramsOutput);
      inputs = new HashMap<String, Object>();
      inputs.put(Constants.PS_ALUMNO, codigoAlumno);
      inputs.put(Constants.PS_CARRERA, codigoCarrera);
      results = execSp.executeSp(inputs);
      lista = ExecuteProcedure.retornaLista(results);

    } catch (Exception e) {
      throw e;
    }

    return lista;

  }

  @SuppressWarnings("unchecked")
  public List<Concepto> obtenerListarCuotasPostulante(String psPostulante) throws Exception {
    List<SqlParameter> paramsInput = null;
    List<SqlOutParameter> paramsOutput = null;
    Map<String, Object> inputs = null;
    Map<String, Object> results = null;
    List<Concepto> lista = null;
    try {
      dataSource = SessionFactoryUtils.getDataSource(getSession().getSessionFactory());
      paramsInput = new ArrayList<SqlParameter>();
      paramsInput.add(new SqlParameter(Constants.PS_POSTULANTE, OracleTypes.NVARCHAR));

      paramsOutput = new ArrayList<SqlOutParameter>();
      paramsOutput.add(new SqlOutParameter(Constants.P_CURSOR, OracleTypes.CURSOR, new Concepto()));

      execSp = new ExecuteProcedure(dataSource, Constants.SPS_LISTARCUOTASPOSTULANTE, paramsInput, paramsOutput);
      inputs = new HashMap<String, Object>();
      inputs.put(Constants.PS_POSTULANTE, psPostulante);
      results = execSp.executeSp(inputs);
      lista = ExecuteProcedure.retornaLista(results);

    } catch (Exception e) {
      throw e;
    }

    return lista;

  }

  @SuppressWarnings("unchecked")
  public List<Concepto> obtenerListarCuotasProspecto(String psProspecto, Integer psAtencion) throws Exception {
    List<SqlParameter> paramsInput = null;
    List<SqlOutParameter> paramsOutput = null;
    Map<String, Object> inputs = null;
    Map<String, Object> results = null;
    List<Concepto> lista = null;
    try {
      dataSource = SessionFactoryUtils.getDataSource(getSession().getSessionFactory());
      paramsInput = new ArrayList<SqlParameter>();
      paramsInput.add(new SqlParameter(Constants.PS_PROSPECTO, OracleTypes.NVARCHAR));
      paramsInput.add(new SqlParameter(Constants.PS_ATENCION, OracleTypes.INTEGER));

      paramsOutput = new ArrayList<SqlOutParameter>();
      paramsOutput.add(new SqlOutParameter(Constants.P_CURSOR, OracleTypes.CURSOR, new Concepto()));

      execSp = new ExecuteProcedure(dataSource, Constants.SPS_LISTARCUOTASPROSPECTO, paramsInput, paramsOutput);
      inputs = new HashMap<String, Object>();
      inputs.put(Constants.PS_PROSPECTO, psProspecto);
      inputs.put(Constants.PS_ATENCION, psAtencion);
      results = execSp.executeSp(inputs);
      lista = ExecuteProcedure.retornaLista(results);

    } catch (Exception e) {
      throw e;
    }

    return lista;

  }

  @SuppressWarnings("unchecked")
  public Integer verificaUsuarioExiste(String nombreUsuario, String usuarioClave) throws Exception {
    List<SqlParameter> paramsInput = null;
    List<SqlOutParameter> paramsOutput = null;
    Map<String, Object> inputs = null;
    Map<String, Object> results = null;
    Integer flagUsuario = null;
    try {
      dataSource = SessionFactoryUtils.getDataSource(getSession().getSessionFactory());
      paramsInput = new ArrayList<SqlParameter>();
      paramsInput.add(new SqlParameter(Constants.PS_USUARIO, OracleTypes.NVARCHAR));
      paramsInput.add(new SqlParameter(Constants.PS_CLAVE, OracleTypes.NVARCHAR));
      paramsInput.add(new SqlParameter(Constants.PS_DOMINIO, OracleTypes.NVARCHAR));

      paramsOutput = new ArrayList<SqlOutParameter>();
      paramsOutput.add(new SqlOutParameter(Constants.RETURN_VALUE, OracleTypes.INTEGER));

      execSp = new ExecuteProcedure(dataSource, Constants.SF_VERIFICAUSUARIOEXISTE, paramsInput, paramsOutput, Boolean.TRUE);
      inputs = new HashMap<String, Object>();
      inputs.put(Constants.PS_USUARIO, nombreUsuario);
      inputs.put(Constants.PS_CLAVE, usuarioClave);
      inputs.put(Constants.PS_DOMINIO, Constants.DOMINIO);

      results = execSp.executeSp(inputs);
      Object retorno = ExecuteProcedure.retornaValue(results);
      if (retorno != null) {
        flagUsuario = (Integer) retorno;
      }
    } catch (Exception e) {
      throw e;
    }

    return flagUsuario;

  }
  
	@SuppressWarnings("unchecked")
	public Integer verificarPostulanteExiste(String psCodigo, String psId)
			throws Exception {
		List<SqlParameter> paramsInput = null;
		List<SqlOutParameter> paramsOutput = null;
		Map<String, Object> inputs = null;
		Map<String, Object> results = null;
		Integer flagUsuario = null;
		try {
			dataSource = SessionFactoryUtils.getDataSource(getSession()
					.getSessionFactory());
			paramsInput = new ArrayList<SqlParameter>();
			paramsInput.add(new SqlParameter(Constants.PS_CODIGO,
					OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PS_ID,
					OracleTypes.NVARCHAR));

			paramsOutput = new ArrayList<SqlOutParameter>();
			paramsOutput.add(new SqlOutParameter(Constants.RETURN_VALUE,
					OracleTypes.INTEGER));

			execSp = new ExecuteProcedure(dataSource,
					Constants.SF_VERIFICARPOSTULANTEEXISTE, paramsInput,
					paramsOutput, Boolean.TRUE);
			inputs = new HashMap<String, Object>();
			inputs.put(Constants.PS_CODIGO, psCodigo);
			inputs.put(Constants.PS_ID, psId);

			results = execSp.executeSp(inputs);
			Object retorno = ExecuteProcedure.retornaValue(results);
			if (retorno != null) {
				flagUsuario = (Integer) retorno;
			}
		} catch (Exception e) {
			throw e;
		}

		return flagUsuario;

	}
	
	@SuppressWarnings("unchecked")
	public Integer verificarProspectoExiste(String psCodigo, String psId, Integer psAtencion)
			throws Exception {
		List<SqlParameter> paramsInput = null;
		List<SqlOutParameter> paramsOutput = null;
		Map<String, Object> inputs = null;
		Map<String, Object> results = null;
		Integer flagUsuario = null;
		try {
			dataSource = SessionFactoryUtils.getDataSource(getSession()
					.getSessionFactory());
			paramsInput = new ArrayList<SqlParameter>();
			paramsInput.add(new SqlParameter(Constants.PS_EMAIL,
					OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PS_ID,
					OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PS_ATENCION,
					OracleTypes.INTEGER));

			paramsOutput = new ArrayList<SqlOutParameter>();
			paramsOutput.add(new SqlOutParameter(Constants.RETURN_VALUE,
					OracleTypes.INTEGER));

			execSp = new ExecuteProcedure(dataSource,
					Constants.SF_VERIFICARPROSPECTOEXISTE, paramsInput,
					paramsOutput, Boolean.TRUE);
			inputs = new HashMap<String, Object>();
			inputs.put(Constants.PS_EMAIL, psCodigo);
			inputs.put(Constants.PS_ID, psId);
			inputs.put(Constants.PS_ATENCION, psAtencion);

			results = execSp.executeSp(inputs);
			Object retorno = ExecuteProcedure.retornaValue(results);
			if (retorno != null) {
				flagUsuario = (Integer) retorno;
			}
		} catch (Exception e) {
			throw e;
		}

		return flagUsuario;

	}

}
