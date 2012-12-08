package com.visa.dao.jdbc;

import java.util.List;

import com.visa.domain.Carrera;
import com.visa.domain.Concepto;

public interface VisaJdbcTemplateDAO {

  List<Carrera> obtenerCarrerasPostgrado(String psAlumno) throws Exception;

  List<Carrera> obtenerCarrerasPostulante(String psPostulante) throws Exception;

  List<Carrera> obtenerCarrerasProspecto(String psProspecto, Integer psAtencion) throws Exception;

  List<Concepto> obtenerCuotasActuales(String codigoAlumno, String codigoCarrera) throws Exception;

  List<Concepto> obtenerListarCuotasPostulante(String psPostulante) throws Exception;

  List<Concepto> obtenerListarCuotasProspecto(String psProspecto, Integer psAtencion) throws Exception;

  Integer verificaUsuarioExiste(String nombreUsuario, String usuarioClave) throws Exception;
  
  Integer verificarPostulanteExiste(String psCodigo, String psId) throws Exception;
  
  Integer verificarProspectoExiste(String psCodigo, String psId, Integer psAtencion) throws Exception;
}
