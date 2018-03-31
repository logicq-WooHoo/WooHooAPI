package com.woho.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.woho.dao.AbstractDAO;
import com.woho.dao.AddressDao;
import com.woho.model.Address;

@Repository
public class AddressDaoImpl extends AbstractDAO<Address> implements AddressDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8461110747009037390L;

	@Override
	public List<Address> searchAddress(String city, String area, String type) throws Exception {
		StringBuilder selectQuery = new StringBuilder();
		selectQuery.append("from Address a ");

		StringBuilder whereQuery = new StringBuilder();

		whereQuery.append("where ");
		if (!StringUtils.isEmpty(city)) {
			whereQuery.append("a.city='").append(city + "'");
		} else {
			throw new Exception("city can not be Null");
		}

		if (!StringUtils.isEmpty(area)) {
			whereQuery.append(" and a.locality='").append(area + "'");
		}

		if (!StringUtils.isEmpty(type)) {
			whereQuery.append(" and a.type='").append(type + "'");
		}
		selectQuery.append(whereQuery);

		return executeQuery(selectQuery.toString());
	}

	@Override
	public List<Address> searchAddress(Double latitude, Double longitude) throws Exception {
		StringBuilder selectQuery = new StringBuilder();
		StringBuilder whereQuery = new StringBuilder();
		if (!StringUtils.isEmpty(latitude) && !StringUtils.isEmpty(longitude)) {
			//selectQuery.append("SELECT *");
			/*selectQuery.append("SELECT *, ACOS( SIN( RADIANS( `latitude` ) ) * SIN( RADIANS(");
			selectQuery.append(latitude);
			selectQuery.append(") ) + COS( RADIANS( `latitude` ) ) * COS( RADIANS(");
			selectQuery.append(latitude);
			selectQuery.append(")) * COS( RADIANS( `longitude` ) - RADIANS(");
			selectQuery.append(longitude);
			selectQuery.append("))) * 6380 AS `distance` from Address ");*/
			selectQuery.append(" from Address ");
			whereQuery.append("where ");

			whereQuery.append("ACOS( SIN( RADIANS(latitude) ) * SIN( RADIANS(");
			whereQuery.append(latitude);
			whereQuery.append(") ) + COS( RADIANS(latitude) ) * COS( RADIANS(");
			whereQuery.append(latitude);
			whereQuery.append(")) * COS( RADIANS(longitude) - RADIANS(");
			whereQuery.append(longitude);
			whereQuery.append("))) * 6380 < 5");
		} else {
			throw new Exception("Latitude/Longitude can not be Null");
		}
		selectQuery.append(whereQuery);
		return executeQuery(selectQuery.toString());
	}
}
