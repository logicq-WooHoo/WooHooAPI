package com.woho.dao;

import java.util.List;
import java.util.Set;

import com.woho.model.DeliveryPartner;

public interface DeliveryPartnerDao {
	Set<DeliveryPartner> getDeliveryPartnersByID(Set<String> ids);

	void addDeliveryPartner(DeliveryPartner deliveryPartner);

	void deleteDeliveryPartner(DeliveryPartner deliveryPartner);

	void updateDeliveryPartner(DeliveryPartner deliveryPartner);

	List<DeliveryPartner> list();
}
