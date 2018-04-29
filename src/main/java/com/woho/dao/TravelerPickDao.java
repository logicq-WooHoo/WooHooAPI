package com.woho.dao;

import java.util.List;

import com.woho.model.TravelerPick;

public interface TravelerPickDao {
	List<TravelerPick> list();
	List<TravelerPick> getByEntityAndCity(String entity, String city) throws Exception;
}
