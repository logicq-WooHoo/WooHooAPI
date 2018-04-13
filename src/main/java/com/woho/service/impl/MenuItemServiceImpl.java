package com.woho.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woho.dao.MenuItemDao;
import com.woho.model.MenuItem;
import com.woho.service.MenuItemService;

/**
 * 
 * @author Pankaj Labade
 *
 */

@Service
@Transactional
public class MenuItemServiceImpl implements MenuItemService {
	
	@Autowired
	MenuItemDao menuItemDao;

	@Override
	@Transactional(readOnly = true)
	public MenuItem getByFoodCategory(String foodCategory) {
		return menuItemDao.getByFoodCategory(foodCategory);
	}

	@Override
	public List<MenuItem> getByFoodServiceTypes(List<String> foodServiceTypes) {
		return menuItemDao.getByFoodServiceTypes(foodServiceTypes);
	}

	@Override
	public List<MenuItem> findByMenuItem(String menuItem) {
		return menuItemDao.findByMenuItem(menuItem);
	}

}
