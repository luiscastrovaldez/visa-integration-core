package com.visa.util.services;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.visa.beans.DatosCorreo;
import com.visa.commons.Constants;

@Service("emailServices")
public class EmailServicesImpl implements EmailServices {

	private static final Logger LOGGER = Logger.getLogger(EmailServicesImpl.class);

	private VelocityEngineFactoryBean velocityEngineFactoryBean = null;
	private Properties velocityProperties = null;
	private VelocityEngine velocityEngine;

	@Value("#{propsEmail.from}")
	private String from;	
	@Value("#{propsEmail.servidor}")
	private String servidor;
	@Value("#{propsEmail.contentType}")
	private String contentType;
	@Value("#{propsEmail.mailTemplateNuevoAlumno}")
	private String mailTemplateNuevoAlumno;
	@Value("#{propsEmail.mailTemplateConfirmacionpago}")
	private String mailTemplateConfirmacionpago;
	@Value("#{propsEmail.subjectNuevoAlumno}")
	private String subjectNuevoAlumno;
	@Value("#{propsEmail.subjectConfirmacionPago}")
	private String subjectConfirmacionPago;
	@Value("#{propsEmail.logoUrl}")
	private String logoUrl;
	@Value("#{propsEmail.usuario}")
	private String usuario;
	@Value("#{propsEmail.clave}")
	private String clave;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getMailTemplateNuevoAlumno() {
		return mailTemplateNuevoAlumno;
	}

	public void setMailTemplateNuevoAlumno(String mailTemplateNuevoAlumno) {
		this.mailTemplateNuevoAlumno = mailTemplateNuevoAlumno;
	}

	public String getMailTemplateConfirmacionpago() {
		return mailTemplateConfirmacionpago;
	}

	public void setMailTemplateConfirmacionpago(String mailTemplateConfirmacionpago) {
		this.mailTemplateConfirmacionpago = mailTemplateConfirmacionpago;
	}

	public String getSubjectNuevoAlumno() {
		return subjectNuevoAlumno;
	}

	public void setSubjectNuevoAlumno(String subjectNuevoAlumno) {
		this.subjectNuevoAlumno = subjectNuevoAlumno;
	}

	public String getSubjectConfirmacionPago() {
		return subjectConfirmacionPago;
	}

	public void setSubjectConfirmacionPago(String subjectConfirmacionPago) {
		this.subjectConfirmacionPago = subjectConfirmacionPago;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public void sendEmail(DatosCorreo datosCorreo) {
		try {
			LOGGER.info("----Enviando Correo---");
			LOGGER.info(datosCorreo.getAddressTo());
			LOGGER.info(datosCorreo.getNombre());
			String body = "";
			String subject = "";
			String template = "";
			//logoUrl = new URL(bundle.getProperty("logo.html.url"));

			velocityEngineFactoryBean = new VelocityEngineFactoryBean();
			velocityProperties = new Properties();
			velocityProperties.put("resource.loader", "class");			
			velocityProperties.put("class.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			velocityEngineFactoryBean.setVelocityProperties(velocityProperties);

			velocityEngine = velocityEngineFactoryBean.createVelocityEngine();

			Map<String,String> velocityParams = new HashMap<String,String>();
			
			
			if (datosCorreo.isConfirmacion()){
				template = getMailTemplateConfirmacionpago();
				subject = getSubjectConfirmacionPago();
				
				velocityParams.put("nombre", datosCorreo.getNombre());					
				velocityParams.put("idCliente", datosCorreo.getIdCliente());
				velocityParams.put("idTransferencia", datosCorreo.getIdTransferencia());				
				velocityParams.put("concepto", datosCorreo.getConcepto());
				velocityParams.put("monto", datosCorreo.getMonto());
				
			} else if (datosCorreo.isNuevoAlumno()){
				template = getMailTemplateNuevoAlumno();
				subject = getSubjectNuevoAlumno();
				velocityParams.put("nombre", datosCorreo.getNombre());
				velocityParams.put("usuario", datosCorreo.getUsuario());
				velocityParams.put("clave", datosCorreo.getClave());
				
			}
			
			body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,template, velocityParams);

			sendEmail(getServidor(), getFrom(), datosCorreo.getAddressTo(), datosCorreo.getAddressCc(),datosCorreo.getAddressBcc(),
					subject, body, getContentType(), null,getUsuario(), getClave());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private static void sendEmail(String host, String addressFrom,
			String addressTo, String addressCc, String addressBcc,
			String subject, String body, String contentType, URL imageUrl, String usuario, String clave)
			throws Exception {
		Transport trans = null;

		try {
			LOGGER.info(":: sendEmail :: Starting execution...");
			if (host == null || "".equals(host)) {
				throw new Exception("Host parameter is required!");
			}
			if (addressFrom == null || "".equals(addressFrom)) {
				throw new Exception("From parameter is required!");
			}
			if (addressTo == null || "".equals(addressTo)) {
				throw new Exception("To parameter is required!");
			}
			if (subject == null) {
				subject = "";
			}
			if (body == null) {
				body = "";
			}

			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", ""+587);
			props.put("mail.smtp.auth", "true");
			
			
			Session session = Session.getInstance(props);

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(addressFrom));
			message.addRecipients(Message.RecipientType.TO, addressTo);
			if (addressCc!= null && !"".equals(addressCc)) {
				String[] addressesCc = addressCc
						.split(Constants.EMAIL_SEPARATOR);
				ArrayList internetAddressesCc = new ArrayList();
				for (int i = 0; i < addressesCc.length; i++) {
					internetAddressesCc
							.add(new InternetAddress(addressesCc[i]));
				}
				message
						.addRecipients(
								Message.RecipientType.CC,
								(InternetAddress[]) internetAddressesCc
										.toArray(new InternetAddress[internetAddressesCc
												.size()]));
			}
			if (addressBcc!= null && !"".equals(addressBcc)) {
				String[] addressesBcc = addressBcc
						.split(Constants.EMAIL_SEPARATOR);
				ArrayList internetAddressesBcc = new ArrayList();
				for (int i = 0; i < addressesBcc.length; i++) {
					internetAddressesBcc
							.add(new InternetAddress(addressesBcc[i]));
				}
				message
						.addRecipients(
								Message.RecipientType.BCC,
								(InternetAddress[]) internetAddressesBcc
										.toArray(new InternetAddress[internetAddressesBcc
												.size()]));
			}
			message.setSubject(subject);

			Multipart multipart = new MimeMultipart("related");
			BodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(body, contentType);
			multipart.addBodyPart(htmlPart);
			//BodyPart imgPart = new MimeBodyPart();
			// Loading the image
			//DataSource dataSource = new URLDataSource(imageUrl);
//			imgPart.setDataHandler(new DataHandler(dataSource));
			// Setting the header
			//imgPart.setHeader("Content-ID", CONTENT_ID);
			//multipart.addBodyPart(imgPart);

			// attaching the multi-part to the message
			message.setContent(multipart);

			trans = session.getTransport(Constants.SMTP);
			trans.connect(host, usuario,clave);
			
			trans.sendMessage(message, message.getAllRecipients());
			LOGGER.info(":: sendEmail :: Finishing execution...");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (trans != null) {
					trans.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}