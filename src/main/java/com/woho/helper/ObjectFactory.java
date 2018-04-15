package com.woho.helper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectFactory {

	public static ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}

}