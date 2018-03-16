package com.woho.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class MenuItemServiceImpl implements MenuItemService{
	
	@Autowired
	MenuItemDao menuItemDao;

	@Override
	public MenuItem getByFoodCategory(String foodCategory) {
		return menuItemDao.getByFoodCategory(foodCategory);
	}

}
