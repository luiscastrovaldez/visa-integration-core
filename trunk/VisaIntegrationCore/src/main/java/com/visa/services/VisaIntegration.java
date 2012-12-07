package com.visa.services;

import java.io.Serializable;

import com.visa.domain.LogTransaction;

public interface VisaIntegration {

	LogTransaction findById(Serializable id);

}
