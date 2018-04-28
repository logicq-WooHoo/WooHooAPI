package com.woho.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.MenuItemDao;
import com.woho.model.MenuItem;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Repository
public class MenuItemDaoImpl extends AbstractDAO<MenuItem> implements MenuItemDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -832170925570682162L;

	@Override
	public MenuItem getByFoodCategory(String foodCategory) {
		String sqlquery = "from MenuItem where foodCategory.category='" + foodCategory + "'"; 
		return executeQueryForUniqueRecord(sqlquery);
	}

	@Override
	public List<MenuItem> getByFoodServiceTypes(List<String> foodServiceTypes) {
		String hql = "from MenuItem where foodServiceType.serviceType in (:list)";
		return (List<MenuItem>) executeQueryWithList(hql, foodServiceTypes);
	}

	@Override
	public List<MenuItem> findByMenuItem(String itemName) {
		String hql = "from MenuItem where itemName like :itemName";
		return selectWithLikeClause(hql, "itemName", itemName);
	}

	@Override
	public List<MenuItem> getByIds(List<Long> ids) {
		String hql = "from MenuItem where id in (:list)";
		return (List<MenuItem>) executeQueryWithList(hql, ids);
	}

	
}
