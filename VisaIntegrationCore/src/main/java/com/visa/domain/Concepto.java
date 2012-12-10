package com.visa.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Concepto implements RowMapper<Object> {

  private String cuota;
  private String codigoServicio;
  private String nombreServicio;
  private String fechaVencimiento;
  private String periodoacademico;
  private String periodopago;
  private String monto;
  private String recibo;

  public Concepto() {

  }

  public Concepto(String cuota, String codigoServicio, String nombreServicio, String fechaVencimiento, String periodoacademico, String periodopago,
      String monto, String recibo) {
    super();
    this.cuota = cuota;
    this.codigoServicio = codigoServicio;
    this.nombreServicio = nombreServicio;
    this.fechaVencimiento = fechaVencimiento;
    this.periodoacademico = periodoacademico;
    this.periodopago = periodopago;
    this.monto = monto;
    this.recibo = recibo;
  }

  public String getCuota() {
    return cuota;
  }

  public void setCuota(String cuota) {
    this.cuota = cuota;
  }

  public String getCodigoServicio() {
    return codigoServicio;
  }

  public void setCodigoServicio(String codigoServicio) {
    this.codigoServicio = codigoServicio;
  }

  public String getNombreServicio() {
    return nombreServicio;
  }

  public void setNombreServicio(String nombreServicio) {
    this.nombreServicio = nombreServicio;
  }

  public String getFechaVencimiento() {
    return fechaVencimiento;
  }

  public void setFechaVencimiento(String fechaVencimiento) {
    this.fechaVencimiento = fechaVencimiento;
  }

  public String getPeriodoacademico() {
    return periodoacademico;
  }

  public void setPeriodoacademico(String periodoacademico) {
    this.periodoacademico = periodoacademico;
  }

  public String getPeriodopago() {
    return periodopago;
  }

  public void setPeriodopago(String periodopago) {
    this.periodopago = periodopago;
  }

  public String getMonto() {
    return monto;
  }

  public void setMonto(String monto) {
    this.monto = monto;
  }

  public String getRecibo() {
    return recibo;
  }

  public void setRecibo(String recibo) {
    this.recibo = recibo;
  }

  @Override
  public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
    Concepto concepto = new Concepto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
        rs.getString(7), rs.getString(8));
    return concepto;
  }

}
