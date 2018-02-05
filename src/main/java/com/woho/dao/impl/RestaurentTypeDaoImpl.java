package com.woho.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.RestaurentTypeDao;
import com.woho.model.RestaurentType;

@Repository
public class RestaurentTypeDaoImpl extends AbstractDAO<RestaurentType> implements RestaurentTypeDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4357273112572537417L;

	@Override
	public Set<RestaurentType> getRestaurantTypeByID(Set<String> ids) {

		StringBuilder selectQuery = new StringBuilder();
		StringBuilder whereQuery = new StringBuilder();
		selectQuery.append("from RestaurentType rt ");

		if (!ids.isEmpty()) {
			whereQuery.append(" where");
			whereQuery.append(" rt.id in( ");
			
			for (String id : ids) {
				whereQuery.append("" + Long.parseLong(id) + "");
				whereQuery.append(",");
			}
			whereQuery=whereQuery.deleteCharAt( whereQuery.length()-1);
			whereQuery.append(")");
			selectQuery.append(whereQuery);
		}	
		return new HashSet<RestaurentType>( executeQuery(selectQuery.toString()));
	}

}
