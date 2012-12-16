package com.visa.beans;

public class DatosCorreo {

	private String addressTo;
	private String addressCc;
	private String addressBcc;

	private boolean isConfirmacion;
	private boolean isNuevoAlumno;

	private String nombre;
	private String usuario;
	private String clave;

	private String idCliente;
	private String idTransferencia;
	private String monto;
	private String concepto;

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdTransferencia() {
		return idTransferencia;
	}

	public void setIdTransferencia(String idTransferencia) {
		this.idTransferencia = idTransferencia;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getAddressTo() {
		return addressTo;
	}

	public void setAddressTo(String addressTo) {
		this.addressTo = addressTo;
	}

	public String getAddressCc() {
		return addressCc;
	}

	public void setAddressCc(String addressCc) {
		this.addressCc = addressCc;
	}

	public String getAddressBcc() {
		return addressBcc;
	}

	public void setAddressBcc(String addressBcc) {
		this.addressBcc = addressBcc;
	}

	public boolean isConfirmacion() {
		return isConfirmacion;
	}

	public void setConfirmacion(boolean isConfirmacion) {
		this.isConfirmacion = isConfirmacion;
	}

	public boolean isNuevoAlumno() {
		return isNuevoAlumno;
	}

	public void setNuevoAlumno(boolean isNuevoAlumno) {
		this.isNuevoAlumno = isNuevoAlumno;
	}

}
