package com.visa.dao.jdbc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.visa.domain.Carrera;
import com.visa.domain.Concepto;
import com.visa.domain.TranVisaRespuesta;

public interface VisaJdbcTemplateDAO {

  List<Carrera> obtenerCarrerasPostgrado(String psAlumno) throws Exception;

  List<Carrera> obtenerCarrerasPostulante(String psPostulante) throws Exception;

  List<Carrera> obtenerCarrerasProspecto(String psProspecto, Integer psAtencion) throws Exception;

  List<Concepto> obtenerCuotasActuales(String codigoAlumno, String codigoCarrera) throws Exception;

  List<Concepto> obtenerListarCuotasPostulante(String psPostulante) throws Exception;

  List<Concepto> obtenerListarCuotasProspecto(String psProspecto, Integer psAtencion) throws Exception;

  Integer verificaUsuarioExiste(String nombreUsuario, String usuarioClave) throws Exception;
  
  Integer verificaPostulanteExiste(String psCodigo, String psId) throws Exception;
  
  Integer verificaProspectoExiste(String psCodigo, String psId, Integer psAtencion) throws Exception;
  
  Integer registraTransaccionVisa(String psCarrera,String psCliente, BigDecimal psMonto, String periodoAcademico, String psAtencion) throws Exception;
  
  void registraTransaccionVisaDetalle(Integer idTran, String psServicio, int cuota, BigDecimal monto, String periodoPago) throws Exception; 
  
  BigDecimal obtenerMontoTransaccionVisa(Integer idTran) throws Exception;
  
  void actualizarEstadoTranVisa(Integer idTran, String estado) throws Exception;
  
  void registraTranVisaRespuesta(TranVisaRespuesta tranVisaRespuesta) throws Exception;
  
  Map obtenerInformacionTransaccionVisa(Integer idTran) throws Exception;
  
  void registraTranVisaError(Integer idTran, BigDecimal valor) throws Exception;
}
