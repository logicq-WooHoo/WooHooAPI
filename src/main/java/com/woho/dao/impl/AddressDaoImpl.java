package com.woho.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.woho.dao.AbstractDAO;
import com.woho.dao.AddressDao;
import com.woho.model.Address;
import com.woho.vo.AddressVO;

@Repository
public class AddressDaoImpl extends AbstractDAO<Address> implements AddressDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8461110747009037390L;

	@Override
	public List<Address> searchAddress(AddressVO addressVO) throws Exception {
		StringBuilder selectQuery = new StringBuilder();
		selectQuery.append("from Address a ");

		StringBuilder whereQuery = new StringBuilder();

		if (null != addressVO) {
			whereQuery.append("where ");
			if (!StringUtils.isEmpty(addressVO.getCity())) {
				whereQuery.append("a.city='").append(addressVO.getCity() + "'");
			} else {
				throw new Exception("city can not be Null");
			}
			
			if (!StringUtils.isEmpty(addressVO.getArea())) {
				whereQuery.append(" and a.locality='")
						.append(addressVO.getArea() + "'");
			}
			
			if (!StringUtils.isEmpty(addressVO.getType())) {
				whereQuery.append(" and a.type='")
						.append(addressVO.getType() + "'");
			}
			selectQuery.append(whereQuery);
			
		}
		return executeQuery(selectQuery.toString());
	}
}
