package com.visa.dao.jdbc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;
import oracle.sql.TIMESTAMP;

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
import com.visa.domain.TranVisaRespuesta;
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

    } catch ( Exception e) {
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
	public Integer verificaPostulanteExiste(String psCodigo, String psId)
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
	public Integer verificaProspectoExiste(String psCodigo, String psId, Integer psAtencion)
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
	
	
    @SuppressWarnings("unchecked")
    public Integer registraTransaccionVisa(String psCarrera,String psCliente, BigDecimal psMonto, String periodoAcademico, String psAtencion) throws Exception {
      List<SqlParameter> paramsInput = null;
      List<SqlOutParameter> paramsOutput = null;
      Map<String, Object> inputs = null;
      Map<String, Object> results = null;
      Object retorno;
      Integer idTran = null;
      try {
        dataSource = SessionFactoryUtils.getDataSource(getSession().getSessionFactory());
        paramsInput = new ArrayList<SqlParameter>();
        paramsInput.add(new SqlParameter(Constants.PS_CARRERA, OracleTypes.NVARCHAR));
        paramsInput.add(new SqlParameter(Constants.PS_CLIENTE, OracleTypes.NVARCHAR));
        paramsInput.add(new SqlParameter(Constants.PN_MONTO, OracleTypes.NVARCHAR));
        paramsInput.add(new SqlParameter(Constants.PS_PERIODOAC, OracleTypes.NVARCHAR));
        paramsInput.add(new SqlParameter(Constants.PN_ATENCION, OracleTypes.NVARCHAR));

        paramsOutput = new ArrayList<SqlOutParameter>();
        paramsOutput.add(new SqlOutParameter(Constants.PN_IDTRAN, OracleTypes.INTEGER));

        execSp = new ExecuteProcedure(dataSource, Constants.SPI_REGISTRATRANVISA, paramsInput, paramsOutput);
        inputs = new HashMap<String, Object>();
        inputs.put(Constants.PS_CARRERA, psCarrera);
        inputs.put(Constants.PS_CLIENTE, psCliente);
        inputs.put(Constants.PN_MONTO, psMonto);
        inputs.put(Constants.PS_PERIODOAC, periodoAcademico);
        inputs.put(Constants.PN_ATENCION, psAtencion);
        results = execSp.executeSp(inputs);
        retorno = ExecuteProcedure.retornaValue(results);
        
        if (retorno != null) {
        	idTran = (Integer) retorno;
		}
        
        
      } catch (Exception e) {
        throw e;
      }

      return idTran;

    }
    
  
    
	@SuppressWarnings("unchecked")
	public void registraTransaccionVisaDetalle(Integer idTran,
			String psServicio, int cuota, BigDecimal monto, String periodoPago)
			throws Exception {
		List<SqlParameter> paramsInput = null;
		List<SqlOutParameter> paramsOutput = null;
		Map<String, Object> inputs = null;
		Map<String, Object> results = null;
		Object retorno;

		try {
			dataSource = SessionFactoryUtils.getDataSource(getSession()
					.getSessionFactory());
			paramsInput = new ArrayList<SqlParameter>();
			paramsInput.add(new SqlParameter(Constants.PN_IDTRAN,
					OracleTypes.INTEGER));
			paramsInput.add(new SqlParameter(Constants.PS_SERVICIO,
					OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PN_CUOTA,
					OracleTypes.INTEGER));
			paramsInput.add(new SqlParameter(Constants.PN_MONTO,
					OracleTypes.DECIMAL));
			paramsInput.add(new SqlParameter(Constants.PS_PERIODOPAGO,
					OracleTypes.NVARCHAR));

			 paramsOutput = new ArrayList<SqlOutParameter>();
			
			execSp = new ExecuteProcedure(dataSource,
					Constants.SPI_REGISTRATRANVISADET, paramsInput,
					paramsOutput);
			inputs = new HashMap<String, Object>();
			inputs.put(Constants.PN_IDTRAN, idTran);
			inputs.put(Constants.PS_SERVICIO, psServicio);
			inputs.put(Constants.PN_CUOTA, cuota);
			inputs.put(Constants.PN_MONTO, monto);
			inputs.put(Constants.PS_PERIODOPAGO, periodoPago);
			results = execSp.executeSp(inputs);

		} catch (Exception e) {
			throw e;
		}

	}
	
	@SuppressWarnings("unchecked")
    public BigDecimal obtenerMontoTransaccionVisa(Integer idTran) throws Exception {
      List<SqlParameter> paramsInput = null;
      List<SqlOutParameter> paramsOutput = null;
      Map<String, Object> inputs = null;
      Map<String, Object> results = null;
      Object retorno;
      BigDecimal monto = null;
      try {
        dataSource = SessionFactoryUtils.getDataSource(getSession().getSessionFactory());
        paramsInput = new ArrayList<SqlParameter>();
        paramsInput.add(new SqlParameter(Constants.PN_IDTRAN, OracleTypes.INTEGER));
        

        paramsOutput = new ArrayList<SqlOutParameter>();
        paramsOutput.add(new SqlOutParameter(Constants.PN_MONTO, OracleTypes.DECIMAL));

        execSp = new ExecuteProcedure(dataSource, Constants.SPS_OBTENERMONTOTRANVISA, paramsInput, paramsOutput);
        inputs = new HashMap<String, Object>();
        inputs.put(Constants.PN_IDTRAN, idTran);
        
        results = execSp.executeSp(inputs);
        retorno = ExecuteProcedure.retornaValue(results);
        
        if (retorno != null) {
        	monto = (BigDecimal) retorno;
		}
        
        
      } catch (Exception e) {
        throw e;
      }

      return monto;

    }
    

	 
	@SuppressWarnings("unchecked")
	public void actualizarEstadoTranVisa(Integer idTran, String estado)
			throws Exception {
		List<SqlParameter> paramsInput = null;
		List<SqlOutParameter> paramsOutput = null;
		Map<String, Object> inputs = null;

		try {
			dataSource = SessionFactoryUtils.getDataSource(getSession()
					.getSessionFactory());
			paramsInput = new ArrayList<SqlParameter>();
			paramsInput.add(new SqlParameter(Constants.PN_IDTRAN,
					OracleTypes.INTEGER));
			paramsInput.add(new SqlParameter(Constants.PS_ESTADO,
					OracleTypes.NVARCHAR));
			paramsOutput = new ArrayList<SqlOutParameter>();
			execSp = new ExecuteProcedure(dataSource,
					Constants.SPU_ACTUALIZARESTADOTRANVISA, paramsInput,
					paramsOutput);
			inputs = new HashMap<String, Object>();
			inputs.put(Constants.PN_IDTRAN, idTran);
			inputs.put(Constants.PS_ESTADO, estado);
			execSp.executeSp(inputs);

		} catch (Exception e) {
			throw e;
		}

	}
	
	
    
	@SuppressWarnings("unchecked")
	public Map obtenerInformacionTransaccionVisa(Integer idTran)
			throws Exception {
		List<SqlParameter> paramsInput = null;
		List<SqlOutParameter> paramsOutput = null;
		Map<String, Object> inputs = null;
		
		
		try {
			dataSource = SessionFactoryUtils.getDataSource(getSession()
					.getSessionFactory());
			paramsInput = new ArrayList<SqlParameter>();
			paramsInput.add(new SqlParameter(Constants.PN_IDTRAN,
					OracleTypes.INTEGER));
			

			paramsOutput = new ArrayList<SqlOutParameter>();
			paramsOutput.add(new SqlOutParameter(Constants.PD_FECHATRAN,OracleTypes.DATE));
			paramsOutput.add(new SqlOutParameter(Constants.PN_MONTO,OracleTypes.DECIMAL));
			paramsOutput.add(new SqlOutParameter(Constants.P_CURSOR,OracleTypes.CURSOR));

			execSp = new ExecuteProcedure(dataSource,
					Constants.SPS_OBTENERINFOTRANVISA, paramsInput,
					paramsOutput);
			inputs = new HashMap<String, Object>();
			inputs.put(Constants.PN_IDTRAN, idTran);
			
			return execSp.executeSp(inputs);
			
		} catch (Exception e) {
			throw e;
		}

	}
	
	@SuppressWarnings("unchecked")
	public void registraTranVisaRespuesta(TranVisaRespuesta tranVisaRespuesta)
			throws Exception {
		List<SqlParameter> paramsInput = null;
		List<SqlOutParameter> paramsOutput = null;
		Map<String, Object> inputs = null;
				
		try {
			dataSource = SessionFactoryUtils.getDataSource(getSession()
					.getSessionFactory());
			paramsInput = new ArrayList<SqlParameter>();
			
			paramsInput.add(new SqlParameter(Constants.PS_ALUMNO,OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PS_CARRERA,OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PS_RESPUESTA,OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PS_CODTIENDA,OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PS_NORDENT,OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PS_CODACCION,OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PS_PAN,OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PS_ECI,OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PS_CODAUTORIZA,OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PS_ORITARJETA,OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PS_NOMEMISOR,OracleTypes.NVARCHAR));
			paramsInput.add(new SqlParameter(Constants.PS_DESCECI,OracleTypes.NVARCHAR));
						
			paramsOutput = new ArrayList<SqlOutParameter>();
			

			execSp = new ExecuteProcedure(dataSource,
					Constants.SPI_REGISTRATRANVISARESPUESTA, paramsInput,
					paramsOutput);
			inputs = new HashMap<String, Object>();
			
			inputs.put(Constants.PS_ALUMNO,tranVisaRespuesta.getAlumno());
			inputs.put(Constants.PS_CARRERA,tranVisaRespuesta.getCarrera());
			inputs.put(Constants.PS_RESPUESTA,tranVisaRespuesta.getRespuesta());
			inputs.put(Constants.PS_CODTIENDA,tranVisaRespuesta.getCodTienda());
			inputs.put(Constants.PS_NORDENT,tranVisaRespuesta.getnOrdenT());
			inputs.put(Constants.PS_CODACCION,tranVisaRespuesta.getCodAccion());
			inputs.put(Constants.PS_PAN,tranVisaRespuesta.getPan());
			inputs.put(Constants.PS_ECI,tranVisaRespuesta.getEci());
			inputs.put(Constants.PS_CODAUTORIZA,tranVisaRespuesta.getCodAutoriza());
			inputs.put(Constants.PS_ORITARJETA,tranVisaRespuesta.getOriTarjeta());
			inputs.put(Constants.PS_NOMEMISOR,tranVisaRespuesta.getNomEmisor());
			inputs.put(Constants.PS_DESCECI,tranVisaRespuesta.getDscEci());
			
			execSp.executeSp(inputs);
			
		} catch (Exception e) {
			throw e;
		}

	}
	
	
	
	

}

