package com.visa.services;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.dao.jdbc.VisaJdbcTemplateDAO;
import com.visa.domain.Carrera;
import com.visa.domain.Concepto;
import com.visa.domain.TranVisaRespuesta;

@Service("visaIntegration")
public class VisaIntegrationImpl implements VisaIntegration {

  @Autowired
  VisaJdbcTemplateDAO visaJdbcTemplateDAO;

  public List<Carrera> obtenerCarrerasPostgrado(String psAlumno) throws Exception {
    return visaJdbcTemplateDAO.obtenerCarrerasPostgrado(psAlumno);
  }

  public List<Carrera> obtenerCarrerasPostulante(String psPostulante) throws Exception {
    return visaJdbcTemplateDAO.obtenerCarrerasPostulante(psPostulante);
  }

  public List<Carrera> obtenerCarrerasProspecto(String psProspecto, Integer psAtencion) throws Exception {
    return visaJdbcTemplateDAO.obtenerCarrerasProspecto(psProspecto, psAtencion);
  }

  public List<Concepto> obtenerCuotasActuales(String codigoAlumno, String codigoCarrera) throws Exception {
    return visaJdbcTemplateDAO.obtenerCuotasActuales(codigoAlumno, codigoCarrera);
  }

  public List<Concepto> obtenerListarCuotasPostulante(String psPostulante) throws Exception {
    return visaJdbcTemplateDAO.obtenerListarCuotasPostulante(psPostulante);
  }

  public List<Concepto> obtenerListarCuotasProspecto(String psProspecto, Integer psAtencion) throws Exception {
    return visaJdbcTemplateDAO.obtenerListarCuotasProspecto(psProspecto, psAtencion);
  }

  public Integer verificaUsuarioExiste(String nombreUsuario, String usuarioClave) throws Exception {
    return visaJdbcTemplateDAO.verificaUsuarioExiste(nombreUsuario, usuarioClave);
  }

  public Integer verificaPostulanteExiste(String psCodigo, String psId) throws Exception {
	  return visaJdbcTemplateDAO.verificaPostulanteExiste(psCodigo, psId);
  }


  public Integer verificaProspectoExiste(String psCodigo, String psId,
			Integer psAtencion) throws Exception {
		return visaJdbcTemplateDAO.verificaProspectoExiste(psCodigo, psId,psAtencion);
  }

	public Integer registraTransaccionVisa(String psCarrera, String psCliente,
			BigDecimal psMonto, String periodoAcademico, String psAtencion,
			List<Concepto> conceptos) throws Exception {
		Integer idTran = visaJdbcTemplateDAO.registraTransaccionVisa(psCarrera,
				psCliente, psMonto, periodoAcademico, psAtencion);
		for (Iterator<Concepto> iterator = conceptos.iterator(); iterator.hasNext();) {
			Concepto concepto = (Concepto) iterator.next();
			visaJdbcTemplateDAO.registraTransaccionVisaDetalle(idTran, concepto
					.getCodigoServicio(),
					Integer.parseInt(concepto.getCuota()), new BigDecimal(
							concepto.getMonto()), concepto.getPeriodopago());
		}
		return idTran;
	}

  public BigDecimal obtenerMontoTransaccionVisa(Integer idTran) throws Exception {	
	return visaJdbcTemplateDAO.obtenerMontoTransaccionVisa(idTran);
  }

	public void actualizarEstadoTranVisa(Integer idTran, String estado) throws Exception {
		visaJdbcTemplateDAO.actualizarEstadoTranVisa(idTran, estado);
	}
	
	public void registraTranVisaRespuesta(TranVisaRespuesta tranVisaRespuesta, String estado) throws Exception {
		visaJdbcTemplateDAO.registraTranVisaRespuesta(tranVisaRespuesta);
		visaJdbcTemplateDAO.actualizarEstadoTranVisa(Integer.valueOf(tranVisaRespuesta.getnOrdenT()), estado);
	}

	
	public Map obtenerInformacionTransaccionVisa(Integer idTran)
			throws Exception {
		return visaJdbcTemplateDAO.obtenerInformacionTransaccionVisa(idTran);
		
	}
	
	

}
