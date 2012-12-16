package com.visa.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class NombreConcepto implements RowMapper<Object> {

	private String nombre;

	public NombreConcepto() {
	}

	public NombreConcepto(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		NombreConcepto concepto = new NombreConcepto(rs.getString(1));
		return concepto;
	}
}
