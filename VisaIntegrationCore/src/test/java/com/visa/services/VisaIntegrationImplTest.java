package com.visa.services;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.visa.VisaCoreTest;
import com.visa.domain.Carrera;
import com.visa.domain.InfoTranVISA;
import com.visa.domain.TranVisaRespuesta;

public class VisaIntegrationImplTest extends VisaCoreTest {

  @Autowired
  VisaIntegration visaIntegration;

  @Test
  public void findLogTransactionByIdTest() {
    List<Carrera> carreras;
    try {
      carreras = visaIntegration.obtenerCarrerasPostgrado("CL20031506");
      Assert.assertNotNull(carreras);
      Assert.assertTrue(carreras.size() != 0);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail();
    }
  }
  
	@Test
	public void verificaUsuarioExisteTest() {
		Integer flag;
		try {
			flag = visaIntegration.verificaUsuarioExiste("a2012900222",	"bif87933");
			System.out.println(" flag " + flag);
			Assert.assertNotNull(flag);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	
	@Test
	public void registraTransaccionVisaTest() {

		Integer idTran;
		try {
			idTran = visaIntegration.registraTransaccionVisa("001", "C2323", new BigDecimal(250), "2010", "1",null);
			System.out.println(" flag " + idTran);
			Assert.assertNotNull(idTran);
			//12735
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	
	
	@Test
	public void obtenerMontoTransaccionVisaTest() {
		BigDecimal monto = null;
		try {
			monto = visaIntegration.obtenerMontoTransaccionVisa(12735);	
			Assert.assertNotNull(monto);			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	@Test
	public void actualizarEstadoTranVisaTest() {

		try {
			visaIntegration.actualizarEstadoTranVisa(12735,"P");			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	@Test
	public void registraTranVisaRespuestaTest() {

		try {
			TranVisaRespuesta tranVisaRespuesta = new TranVisaRespuesta();
			tranVisaRespuesta.setAlumno("a2010900216");
			tranVisaRespuesta.setCarrera("238");
			tranVisaRespuesta.setRespuesta("2");
			tranVisaRespuesta.setCodTienda("466246301");
			tranVisaRespuesta.setnOrdenT("5592999");
			tranVisaRespuesta.setCodAccion("420");
			tranVisaRespuesta.setPan("000000******0000");
			tranVisaRespuesta.setEci("");
			tranVisaRespuesta.setCodAutoriza("");
			tranVisaRespuesta.setOriTarjeta("S");
			tranVisaRespuesta.setNomEmisor("Luis Castro");
			tranVisaRespuesta.setDscEci("No se puede determin");
						
			visaIntegration.registraTranVisaRespuesta(tranVisaRespuesta, "T");		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	@Test
	public void obtenerInformacionTransaccionVisaTest() {

		try {
			InfoTranVISA infoTranVISA = visaIntegration.obtenerInformacionTransaccionVisa(160);
			System.out.println(infoTranVISA.getListaConceptos().size());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test 
	public void obtenerDatosVirtualTest() {
		Integer flag;
		try {
			flag = visaIntegration.obtenerDatosVirtual(Integer.valueOf("160"));
			System.out.println(" flag " + flag);
			Assert.assertNotNull(flag);			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	@Test
	public void obtenerDatosAlumnoVirtualTest() {
		Integer flag;
		try {
			flag = visaIntegration.obtenerDatosAlumnoVirtual(Integer.valueOf("160"));
			System.out.println(" flag " + flag);
			Assert.assertNotNull(flag);			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	@Test
	public void obtenerDatosPostulanteVirtualTest() {
		Integer flag;
		try {
			flag = visaIntegration.obtenerDatosPostulanteVirtual(Integer.valueOf("160")); 
			System.out.println(" flag " + flag);
			Assert.assertNotNull(flag);			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
	

	
	@Test
	public void verificaContratoActivoTest() {
		Integer flag;
		try {
			flag = visaIntegration.verificaContratoActivo("a2012900222","uwiener.edu.pe");
			System.out.println(" flag " + flag);
			Assert.assertNotNull(flag);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
	
}
