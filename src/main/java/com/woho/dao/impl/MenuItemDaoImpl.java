package com.woho.dao.impl;

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

	
}
