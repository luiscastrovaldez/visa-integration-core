package com.visa.services;

import java.util.List;

import com.visa.domain.Carrera;
import com.visa.domain.Concepto;

public interface VisaIntegration {

  List<Carrera> obtenerCarrerasPostgrado(String psAlumno) throws Exception;

  List<Carrera> obtenerCarrerasPostulante(String psPostulante) throws Exception;

  List<Carrera> obtenerCarrerasProspecto(String psProspecto, Integer psAtencion) throws Exception;

  List<Concepto> obtenerCuotasActuales(String codigoAlumno, String codigoCarrera) throws Exception;

  List<Concepto> obtenerListarCuotasPostulante(String psPostulante) throws Exception;

  List<Concepto> obtenerListarCuotasProspecto(String psProspecto, Integer psAtencion) throws Exception;

  Integer verificaUsuarioExiste(String nombreUsuario, String usuarioClave) throws Exception;

}
