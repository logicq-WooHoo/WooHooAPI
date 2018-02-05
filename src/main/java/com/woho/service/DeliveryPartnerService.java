package com.woho.service;

import java.util.Set;

import com.woho.model.DeliveryPartner;

public interface DeliveryPartnerService {
	
	Set<DeliveryPartner> getDeliveryPartnersByID(Set<String> ids);

	void addDeliveryPartner(DeliveryPartner deliveryPartner);
	
	void deleteDeliveryPartner(DeliveryPartner deliveryPartner);
	
	void updateDeliveryPartner(DeliveryPartner deliveryPartner);
}
