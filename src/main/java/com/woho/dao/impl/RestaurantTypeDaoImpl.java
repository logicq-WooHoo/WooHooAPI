package com.woho.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.RestaurantTypeDao;
import com.woho.model.RestaurantType;

@Repository
public class RestaurantTypeDaoImpl extends AbstractDAO<RestaurantType> implements RestaurantTypeDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4357273112572537417L;

	@Override
	public Set<RestaurantType> getRestaurantTypeByID(Set<String> ids) {

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
		return new HashSet<RestaurantType>( executeQuery(selectQuery.toString()));
	}
	

	@Override
	public void addRestaurentType(RestaurantType restaurentType) {
		save(restaurentType);
		
	}

	@Override
	public void deleteRestaurentType(RestaurantType restaurentType) {
		delete(restaurentType);
		
	}

	@Override
	public void updateRestaurentType(RestaurantType restaurentType) {
		update(restaurentType);
		
	}

}
