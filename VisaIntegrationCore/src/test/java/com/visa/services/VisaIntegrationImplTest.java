package com.visa.services;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.visa.VisaCoreTest;
import com.visa.domain.Carrera;

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
			Assert.assertTrue(flag > 0);
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
}
