package com.woho.service;

import java.util.List;

import com.woho.model.TravelerPick;

/**
 * 
 * @author Pankaj Labade
 *
 */
public interface TravelerPickService {
	List<TravelerPick> list();
	List<TravelerPick> getByEntityAndCity(TravelerPick travelerPick) throws Exception;
}
