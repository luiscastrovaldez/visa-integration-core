package com.visa.util.services;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.visa.VisaCoreTest;
import com.visa.beans.DatosCorreo;

public class EmailServicesTest extends VisaCoreTest {

	@Autowired
	private EmailServices emailServices;
	
	@Test
	public void sendEmailNuevoAlumnoTest() {
		try {
			DatosCorreo datosCorreo = new DatosCorreo();
			datosCorreo.setAddressTo("gluiscastro@gmail.com");
			datosCorreo.setNuevoAlumno(true);
			datosCorreo.setNombre("Luis Castro");
			datosCorreo.setUsuario("lcastro");
			datosCorreo.setClave("clave");
			emailServices.sendEmail(datosCorreo);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void sendEmailConfirmacionPagoTest() {
		try {
			DatosCorreo datosCorreo = new DatosCorreo();
			datosCorreo.setAddressTo("gluiscastro@gmail.com");
			datosCorreo.setConfirmacion(true);
			datosCorreo.setNombre("Luis Castro");
			datosCorreo.setIdCliente("999");
			datosCorreo.setIdTransferencia("888");
			datosCorreo.setMonto("100");
			datosCorreo.setConcepto("Pago Semestre");
			emailServices.sendEmail(datosCorreo);
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
