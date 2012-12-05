package com.visa.domain;

import java.util.Date;

public class LogTransaction implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String entity;
	private String oldValue;
	private String newValue;
	private Date processDate;
	private String userName;
	private String operation;

	public LogTransaction() {
	}

	public LogTransaction(String entity, String oldValue,
			String newValue, Date processDate, String userName, String operation) {
		this.entity = entity;
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.processDate = processDate;
		this.userName = userName;
		this.operation = operation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
