package com.visa.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.visa.VisaCoreTest;
import com.visa.dao.jdbc.VisaJdbcTemplateDAO;
import com.visa.domain.Carrera;
import com.visa.domain.Concepto;

public class VisaJdbcTemplateDAOTest extends VisaCoreTest {

  @Autowired
  VisaJdbcTemplateDAO visaJdbcTemplateDAO;

  @Test
  public void obtenerCarrerasPostgradoTest() {
    List<Carrera> carreras;
    try {
      carreras = visaJdbcTemplateDAO.obtenerCarrerasPostgrado("CL20031506");
      Assert.assertNotNull(carreras);
      Assert.assertTrue(carreras.size() != 0);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail();
    }

  }

  @Test
  public void obtenerCarrerasPostulanteTest() {
    List<Carrera> carreras;
    try {
      carreras = visaJdbcTemplateDAO.obtenerCarrerasPostulante("PA20032038");
      Assert.assertNotNull(carreras);
      Assert.assertTrue(carreras.size() != 0);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail();
    }

  }

  @Test
  public void obtenerCarrerasProspectoTest() {

    List<Carrera> carreras;
    try {
      carreras = visaJdbcTemplateDAO.obtenerCarrerasProspecto("0001174", new Integer(1));
      Assert.assertNotNull(carreras);
      Assert.assertTrue(carreras.size() != 0);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail();
    }

  }

  @Test
  public void obtenerCuotasActualesTest() {

    List<Concepto> conceptos;
    try {
      conceptos = visaJdbcTemplateDAO.obtenerCuotasActuales("W200932473", "113");
      Assert.assertNotNull(conceptos);
      Assert.assertTrue(conceptos.size() != 0);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail();
    }

  }

  @Test
  public void obtenerListarCuotasPostulanteTest() {

    List<Concepto> conceptos;
    try {
      conceptos = visaJdbcTemplateDAO.obtenerListarCuotasPostulante("PA20032038");
      Assert.assertNotNull(conceptos);
      Assert.assertTrue(conceptos.size() != 0);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail();
    }

  }

  // single-row subquery returns more than one row
  @Test
  public void obtenerListarCuotasProspectoTest() {

    List<Concepto> conceptos;
    try {
      conceptos = visaJdbcTemplateDAO.obtenerListarCuotasProspecto("0001174", new Integer(1));
      Assert.assertNotNull(conceptos);
      Assert.assertTrue(conceptos.size() != 0);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail();
    }

  }

  @Test
  public void verificaUsuarioExisteTest() {

    Integer flag;
    try {
      flag = visaJdbcTemplateDAO.verificaUsuarioExiste("twqwqweest", "tqeqwest");
      System.out.println(" flag " + flag);
      Assert.assertNotNull(flag);
      Assert.assertTrue(flag > 0);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail();
    }

  }
  
	@Test
	public void verificarPostulanteExisteTest() {

		Integer flag;
		try {
			flag = visaJdbcTemplateDAO.verificaPostulanteExiste("1", "1");
			System.out.println(" flag " + flag);
			Assert.assertNotNull(flag);
			Assert.assertTrue(flag == 0);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	@Test
	public void verificarProspectoExisteTest() {

		Integer flag;
		try {
			flag = visaJdbcTemplateDAO.verificaProspectoExiste("1", "1",Integer.valueOf(1));
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
			idTran = visaJdbcTemplateDAO.registraTransaccionVisa("001", "C2323", new BigDecimal(250), "2010", "1");
			System.out.println(" flag " + idTran);
			Assert.assertNotNull(idTran);
			//12732
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	@Test
	public void registraTransaccionVisaDetalleTest() {
		
		try {
			visaJdbcTemplateDAO.registraTransaccionVisaDetalle(12732, "eee", 4, new BigDecimal(200), "2012");			
			//12732
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	

}