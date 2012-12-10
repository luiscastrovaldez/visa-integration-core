package com.visa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.dao.jdbc.VisaJdbcTemplateDAO;
import com.visa.domain.Carrera;
import com.visa.domain.Concepto;

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


  public Integer verificarPostulanteExiste(String psCodigo, String psId) throws Exception {
	  return visaJdbcTemplateDAO.verificarPostulanteExiste(psCodigo, psId);
  }


  public Integer verificarProspectoExiste(String psCodigo, String psId,
			Integer psAtencion) throws Exception {
		return visaJdbcTemplateDAO.verificarProspectoExiste(psCodigo, psId,psAtencion);
  }

}
