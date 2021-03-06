package com.woho.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.RestaurantTypeDao;
import com.woho.model.RestaurantType;

@Repository
public class RestaurantTypeDaoImpl extends AbstractDAO<RestaurantType> implements RestaurantTypeDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2372812212705368372L;

	@Override
	public Set<RestaurantType> getRestaurantTypeByID(Set<String> ids) {

		StringBuilder selectQuery = new StringBuilder();
		StringBuilder whereQuery = new StringBuilder();
		selectQuery.append("from RestaurantType rt ");

		if (!ids.isEmpty()) {
			whereQuery.append(" where");
			whereQuery.append(" rt.id in( ");

			for (String id : ids) {
				whereQuery.append(Long.parseLong(id));
				whereQuery.append(",");
			}
			whereQuery = whereQuery.deleteCharAt(whereQuery.length() - 1);
			whereQuery.append(")");
			selectQuery.append(whereQuery);
		}
		return new HashSet<RestaurantType>(executeQuery(selectQuery.toString()));
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

	@Override
	public RestaurantType getById(Long id) {
		String query = "from RestaurantType where id=" + id;
		return executeQueryForUniqueRecord(query);
	}

	@Override
	public List<RestaurantType> list() {
		return (List<RestaurantType>) loadClass(RestaurantType.class);
	}

}
