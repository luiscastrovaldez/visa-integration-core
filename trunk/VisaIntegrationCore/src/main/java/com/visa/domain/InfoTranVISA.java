package com.visa.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class InfoTranVISA {

	private Date fechaTran;
	private BigDecimal monto;
	private List<NombreConcepto> listaConceptos;

	
	public InfoTranVISA(Date fechaTran, BigDecimal monto, List<NombreConcepto> listaConceptos) {
		this.fechaTran = fechaTran;
		this.monto = monto;
		this.listaConceptos = listaConceptos;
	}

	public Date getFechaTran() {
		return fechaTran;
	}

	public void setFechaTran(Date fechaTran) {
		this.fechaTran = fechaTran;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public List<NombreConcepto> getListaConceptos() {
		return listaConceptos;
	}

	public void setListaConceptos(List<NombreConcepto> listaConceptos) {
		this.listaConceptos = listaConceptos;
	}

}
