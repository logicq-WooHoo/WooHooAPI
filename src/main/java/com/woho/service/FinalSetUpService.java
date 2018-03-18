package com.woho.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.woho.vo.FinalSetUpVO;

public interface FinalSetUpService {
	
	void finalRestaurentSetup(FinalSetUpVO FinalSetUpVO) throws JsonProcessingException;
}
