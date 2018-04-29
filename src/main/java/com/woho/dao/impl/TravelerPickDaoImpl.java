package com.woho.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.woho.dao.AbstractDAO;
import com.woho.dao.TravelerPickDao;
import com.woho.model.TravelerPick;

@Repository
public class TravelerPickDaoImpl extends AbstractDAO<TravelerPick> implements TravelerPickDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 24314898890151325L;

	@Override
	public List<TravelerPick> list() {
		return (List<TravelerPick>) loadClass(TravelerPick.class);
	}

	@Override
	public List<TravelerPick> getByEntityAndCity(String entity, String city) throws Exception {
		StringBuilder selectQuery = new StringBuilder();
		selectQuery.append("from TravelerPick t ");

		StringBuilder whereQuery = new StringBuilder();

		whereQuery.append("where ");
		if (!StringUtils.isEmpty(city)) {
			whereQuery.append("t.city='").append(city + "'");
		} else {
			throw new Exception("city can not be Null");
		}

		if (!StringUtils.isEmpty(entity)) {
			whereQuery.append(" and t.entity='").append(entity + "'");
		} else {
			throw new Exception("entity can not be Null");
		}

		selectQuery.append(whereQuery);

		return executeQuery(selectQuery.toString());
	}
}
