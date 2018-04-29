package com.woho.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woho.dao.TravelerPickDao;
import com.woho.model.TravelerPick;
import com.woho.service.TravelerPickService;

/**
 * 
 * @author Pankaj Labade
 *
 */

@Service
@Transactional
public class TravelerPickServiceImpl implements TravelerPickService {

	@Autowired
	TravelerPickDao travelerPickDao;

	@Override
	@Transactional(readOnly = true)
	public List<TravelerPick> list() {
		return travelerPickDao.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<TravelerPick> getByEntityAndCity(TravelerPick travelerPick) throws Exception {
		return travelerPickDao.getByEntityAndCity(travelerPick.getEntity(), travelerPick.getCity());
	}
}
