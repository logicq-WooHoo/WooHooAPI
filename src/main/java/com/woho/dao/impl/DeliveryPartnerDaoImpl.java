package com.woho.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.woho.dao.AbstractDAO;
import com.woho.dao.DeliveryPartnerDao;
import com.woho.model.DeliveryPartner;

@Repository
public class DeliveryPartnerDaoImpl extends AbstractDAO<DeliveryPartner> implements DeliveryPartnerDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3140366659006554586L;

	@Override
	public Set<DeliveryPartner> getDeliveryPartnersByID(Set<String> ids) {

		StringBuilder selectQuery = new StringBuilder();
		StringBuilder whereQuery = new StringBuilder();
		selectQuery.append("from DeliveryPartner dp ");

		if (!ids.isEmpty()) {
			whereQuery.append(" where");
			whereQuery.append(" dp.id in( ");

			for (String id : ids) {
				whereQuery.append("" + Long.parseLong(id) + "");
				whereQuery.append(",");
			}
			whereQuery = whereQuery.deleteCharAt(whereQuery.length() - 1);
			whereQuery.append(")");
			selectQuery.append(whereQuery);
		}
		return new HashSet<DeliveryPartner>(executeQuery(selectQuery.toString()));
	}

	@Override
	public void addDeliveryPartner(DeliveryPartner deliveryPartner) {
		save(deliveryPartner);
	}

	@Override
	public void deleteDeliveryPartner(DeliveryPartner deliveryPartner) {
		delete(deliveryPartner);
	}

	@Override
	public void updateDeliveryPartner(DeliveryPartner deliveryPartner) {
		update(deliveryPartner);
	}

	@Override
	public List<DeliveryPartner> list() {
		return (List<DeliveryPartner>) loadClass(DeliveryPartner.class);
	}

}
