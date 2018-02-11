package com.woho.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woho.dao.RestaurantDetailsDao;
import com.woho.dao.RestaurantMenuDao;
import com.woho.dao.RestaurantSetupDao;
import com.woho.dao.UserInformationrDao;
import com.woho.model.DeliveryPartner;
import com.woho.model.FoodCategory;
import com.woho.model.FoodServiceType;
import com.woho.model.MenuItem;
import com.woho.model.RestaurantDetails;
import com.woho.model.RestaurantMenu;
import com.woho.model.RestaurantSetup;
import com.woho.model.RestaurantType;
import com.woho.model.UserInformation;
import com.woho.service.DeliveryPartnerService;
import com.woho.service.FoodCategoryService;
import com.woho.service.FoodServiceTypeService;
import com.woho.service.RegistrationService;
import com.woho.service.RestaurantTypeService;
import com.woho.vo.MenuItemVO;
import com.woho.vo.RestaurantMenuVO;
import com.woho.vo.RestaurantSetupVO;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService{
	
	private ObjectMapper mapper = new ObjectMapper();


	@Autowired
	UserInformationrDao userInformationrDao;
	
	@Autowired
	RestaurantSetupDao restaurantSetupDao;
	
	@Autowired
	RestaurantDetailsDao restaurantDetailsDao;
	
	@Autowired
	RestaurantTypeService restaurentTypeService;
	
	@Autowired
	DeliveryPartnerService deliveryPartnerService;
	
	@Autowired
	FoodCategoryService foodCategoryService;
	
	@Autowired
	FoodServiceTypeService foodServiceTypeService;
	
	@Autowired
	RestaurantMenuDao restaurantMenuDao;
	
	@Override
	public void register(UserInformation userInformation) {
		userInformationrDao.addUser(userInformation);
	}

	@Override
	public void registerRestaurantDetails(RestaurantDetails restaurantDetails) {
		restaurantDetailsDao.addRestaurantDetails(restaurantDetails);
	}

	@Override
	public void registerRestaurantSetup(RestaurantSetupVO restaurantSetupVO) throws JsonProcessingException {
		RestaurantSetup restaurantSetup=new RestaurantSetup();
		Set<RestaurantType> restaurentTypes=new HashSet<>();
		Set<DeliveryPartner> deliveryPartners=new HashSet<>();
		
		if(null!=restaurantSetupVO.getRestaurentTypes()  || !restaurantSetupVO.getRestaurentTypes().isEmpty()){
			restaurentTypes=restaurentTypeService.getRestaurantTypeByID(restaurantSetupVO.getRestaurentTypes() );
		}
		
		if(null!=restaurantSetupVO.getDeliveryPartners() || !restaurantSetupVO.getDeliveryPartners().isEmpty()){
		deliveryPartners=deliveryPartnerService.getDeliveryPartnersByID(restaurantSetupVO.getDeliveryPartners());
		}
		
		restaurantSetup.setRestTypes(restaurentTypes);
		restaurantSetup.setDeliveryPartners(deliveryPartners);
		
		restaurantSetup.setOperationTime(mapper.writeValueAsBytes(restaurantSetupVO.getOperationTime()));
		restaurantSetup.setDeliveryServices(mapper.writeValueAsBytes(restaurantSetupVO.getDeliveryServices()));
		
		restaurantSetupDao.addRestaurantSetup(restaurantSetup);
	}

	@Override
	public void registerRestaurantMenu(RestaurantMenuVO restaurantMenuVO) throws JsonProcessingException {
		
		RestaurantMenu restaurantMenu = new RestaurantMenu();
		
		Iterator<MenuItemVO> iterator = restaurantMenuVO.getMenuItems().iterator();
		
		while(iterator.hasNext()) {
			MenuItem menuItem = new MenuItem();
			MenuItemVO menuItemVO = (MenuItemVO) iterator.next();
			
			if(null!=menuItemVO.getFoodCategoryId()) {
				FoodCategory foodCategory = foodCategoryService.getFoodCategoryByID(menuItemVO.getFoodCategoryId());
				menuItem.setFoodCategory(foodCategory);
			}
			
			if(null!=menuItemVO.getFoodServiceTypeId()) {
				FoodServiceType foodServiceType = foodServiceTypeService.getFoodServiceTypeByID(menuItemVO.getFoodServiceTypeId());
				menuItem.setFoodServiceType(foodServiceType);
			}
			
			menuItem.setPrice(menuItemVO.getPrice());
			menuItem.setItemName(menuItemVO.getItemName());
			
			restaurantMenu.getMenuItems().add(menuItem);
		}
		
		restaurantMenuDao.addRestaurantMenu(restaurantMenu);
	}

}