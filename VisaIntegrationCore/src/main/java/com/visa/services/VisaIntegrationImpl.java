package com.visa.services;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.dao.jdbc.VisaJdbcTemplateDAO;
import com.visa.domain.Carrera;
import com.visa.domain.Concepto;
import com.visa.domain.InfoTranVISA;
import com.visa.domain.TranVisaRespuesta;
import com.visa.domain.Usuario;

@Service("visaIntegration")
public class VisaIntegrationImpl implements VisaIntegration {

	private static final Logger LOGGER = Logger.getLogger(VisaIntegrationImpl.class);
	
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

	public Integer verificaProspectoExiste(String psCodigo, String psId, Integer psAtencion) throws Exception {
		return visaJdbcTemplateDAO.verificaProspectoExiste(psCodigo, psId, psAtencion);
	}

	public Integer registraTransaccionVisa(String psCarrera, String psCliente, BigDecimal psMonto, String periodoAcademico, String psAtencion,
			List<Concepto> conceptos) throws Exception {
		Integer idTran = visaJdbcTemplateDAO.registraTransaccionVisa(psCarrera, psCliente, psMonto, periodoAcademico, psAtencion);
		for (Iterator<Concepto> iterator = conceptos.iterator(); iterator.hasNext();) {
			Concepto concepto = (Concepto) iterator.next();
			visaJdbcTemplateDAO.registraTransaccionVisaDetalle(idTran, concepto.getCodigoServicio(), Integer.parseInt(concepto.getCuota()),
					new BigDecimal(concepto.getMonto()), concepto.getPeriodopago());
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

	public InfoTranVISA obtenerInformacionTransaccionVisa(Integer idTran) throws Exception {
		return visaJdbcTemplateDAO.obtenerInformacionTransaccionVisa(idTran);

	}

	public Integer obtenerFlagPostulante(String carrera) throws Exception {
		return visaJdbcTemplateDAO.obtenerFlagPostulante(carrera);
	}

	public Integer obtenerDatosVirtual(Integer nroTransaccion) throws Exception {
		return visaJdbcTemplateDAO.obtenerDatosVirtual(nroTransaccion);
	}

	public Integer obtenerDatosAlumnoVirtual(Integer nroTransaccion) throws Exception {
		return visaJdbcTemplateDAO.obtenerDatosAlumnoVirtual(nroTransaccion);
	}

	public Integer obtenerDatosPostulanteVirtual(Integer nroTransaccion) throws Exception {
		return visaJdbcTemplateDAO.obtenerDatosPostulanteVirtual(nroTransaccion);
	}

	public void actualizarDatosVirtual(int intNOrdenT, int intTipoUsuario) throws Exception {
		int intRpta = 666;
        int intFlagPos = 0;
        intFlagPos = visaJdbcTemplateDAO.obtenerFlagPostulante(Integer.toString(intNOrdenT));
        if (intFlagPos == 0) {
        	intRpta = visaJdbcTemplateDAO.obtenerDatosVirtual(intNOrdenT);
        } else {
        	if (intTipoUsuario == 0 || intTipoUsuario == 1) {
        		intRpta = visaJdbcTemplateDAO.obtenerDatosAlumnoVirtual(intNOrdenT);
        	} else if (intTipoUsuario == 2) {
        		intRpta = visaJdbcTemplateDAO.obtenerDatosPostulanteVirtual(intNOrdenT);
        	}
        }
        if (intRpta < 0 || intRpta == 666) {
        	visaJdbcTemplateDAO.registraTranVisaError(intNOrdenT, intRpta);
        }
	}

	public String obtenerNombreAlumnoPG(final String usuario) throws Exception {
		return visaJdbcTemplateDAO.obtenerNombreAlumnoPG(usuario);
	}

	public String obtenerNombrePostulante(final String idPostulante) throws Exception {
		return visaJdbcTemplateDAO.obtenerNombrePostulante(idPostulante);
	}

	public String obtenerNombreProspecto(final String cliente) throws Exception {
		return visaJdbcTemplateDAO.obtenerNombreProspecto(cliente);
	}

	public Usuario obtenerDatosNuevoAlumno(final String idPostulante, final String carrera) throws Exception {
		return visaJdbcTemplateDAO.obtenerDatosNuevoAlumno(idPostulante, carrera);
	}
	
	public int verificaAccesoUsuario(int intInstitucion, String usuario,
			String clave, int intPerfil, String strDominio) throws Exception {
		int intCodRpta = 0;
		Integer flag = visaJdbcTemplateDAO
				.verificaUsuarioExiste(usuario, clave);
		
		if (flag != null && flag.intValue() == 0) {
			intCodRpta = 1;
		} else {
			if (intPerfil == 2) {
				Integer resp = visaJdbcTemplateDAO.verificaIngresoAlumno(
						usuario, intInstitucion);
				
				if (resp != null && resp.intValue() <= 0) {
					intCodRpta = 2;
				}

			} else {
				Integer contratoActivo = visaJdbcTemplateDAO
						.verificaContratoActivo(usuario, strDominio);
				
				if (contratoActivo != null && contratoActivo.intValue() <= 0) {
					intCodRpta = 3;
				} else if (intPerfil == 3) {
					Integer prog = visaJdbcTemplateDAO
							.verificarProgramacionDocente(usuario,
									intInstitucion);
					
					if (prog != null && prog.intValue() <= 0) {
						intCodRpta = 4;
					}
				}
			}
		}

		return intCodRpta;
	}
	
	public Integer verificaIngresoAlumno(String psUsuario, int psInstitucion) throws Exception {
		return visaJdbcTemplateDAO.verificaIngresoAlumno(psUsuario, psInstitucion);
	}
	
	public Integer verificaContratoActivo(String psUsuario, String dominio) throws Exception {
		return visaJdbcTemplateDAO.verificaContratoActivo(psUsuario, dominio);
	}
	
	public Integer verificaProgramacionDocente(String psUsuario,
			int psInstitucion) throws Exception {
		return visaJdbcTemplateDAO.verificarProgramacionDocente(psUsuario, psInstitucion);
	}

	
	public Integer verificaDatosPostulante(String psCodigo, String psId)
			throws Exception {
		return verificaPostulanteExiste(psCodigo, psId);
	}

}
