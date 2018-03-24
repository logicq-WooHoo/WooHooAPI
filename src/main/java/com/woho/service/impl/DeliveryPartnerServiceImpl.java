package com.woho.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woho.dao.DeliveryPartnerDao;
import com.woho.model.DeliveryPartner;
import com.woho.service.DeliveryPartnerService;

@Service
@Transactional
public class DeliveryPartnerServiceImpl implements DeliveryPartnerService {

	@Autowired
	DeliveryPartnerDao deliveryPartnerDao;

	@Override
	@Transactional(readOnly = true)
	public Set<DeliveryPartner> getDeliveryPartnersByID(Set<String> ids) {
		return deliveryPartnerDao.getDeliveryPartnersByID(ids);
	}

	@Override
	public void addDeliveryPartner(DeliveryPartner deliveryPartner) {

		deliveryPartnerDao.addDeliveryPartner(deliveryPartner);
	}

	@Override
	public void deleteDeliveryPartner(DeliveryPartner deliveryPartner) {
		deliveryPartnerDao.deleteDeliveryPartner(deliveryPartner);
	}

	@Override
	public void updateDeliveryPartner(DeliveryPartner deliveryPartner) {
		deliveryPartnerDao.updateDeliveryPartner(deliveryPartner);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeliveryPartner> list() {
		return deliveryPartnerDao.list();
	}

}
