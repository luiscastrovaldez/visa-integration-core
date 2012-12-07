package com.visa.jdbc;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.visa.domain.Carrera;

public class ExecuteProcedure extends StoredProcedure {

	public ExecuteProcedure(DataSource ds, String storeProcedureName,
			List<SqlParameter> paramsInput, List<SqlOutParameter> paramsOutput) {

		setDataSource(ds);

		setSql(storeProcedureName);
		for (Iterator<SqlParameter> iterator = paramsInput.iterator(); iterator
				.hasNext();) {
			SqlParameter sqlParameter = iterator.next();
			declareParameter(sqlParameter);
		}

		for (Iterator<SqlOutParameter> iterator = paramsOutput.iterator(); iterator
				.hasNext();) {
			SqlOutParameter sqlOutParameter = iterator.next();
			declareParameter(sqlOutParameter);
		}

		compile();
	}

	public Map executeSp(Map inputs) {
		return execute(inputs);
	}
	
	
	
	public static List retornaLista(Map map) {

		Iterator it = map.entrySet().iterator();
		List list = null;
		while (it.hasNext()) {

			Map.Entry entry = (Map.Entry) it.next();

			String key = (String) entry.getKey();

			list = (List) entry.getValue();

			break;

		}
		return list;

	}

}
