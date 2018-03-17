package com.woho.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woho.dao.RestaurantDetailsDao;
import com.woho.dao.RestaurantMenuDao;
import com.woho.dao.RestaurantSetupDao;
import com.woho.dao.UserInformationrDao;
import com.woho.model.Address;
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
import com.woho.service.StorageService;
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
	
	@Autowired
	StorageService storageService;
	
	@Override
	public void register(UserInformation userInformation) {
		userInformationrDao.addUser(userInformation);
	}

	@Override
	public void saveRestaurantDetails(RestaurantDetails restaurantDetails) {
		/*RestaurantDetails restaurantDetails = new RestaurantDetails();
		restaurantDetails.setAddress(restaurantDetailsVO.getAddress());
		storageService.store(restaurantDetailsVO.getFile());
		//storageService.loadFile(restaurantDetailsVO.getFile().getOriginalFilename());
		//String docmentPath = restaurantDetailsVO.getFile()
		restaurantDetails.setDocumentPath(restaurantDetailsVO.getFile().getOriginalFilename());
		restaurantDetails.setRegistrationNumber(restaurantDetailsVO.getRegistrationNumber());
		restaurantDetails.setRestaurantName(restaurantDetailsVO.getRestaurantName());
		restaurantDetails.setUserInformation(restaurantDetailsVO.getUserInformation());*/
		restaurantDetailsDao.addRestaurantDetails(restaurantDetails);
	}

	@Override
	public RestaurantDetails getRestaurantDetails(long id) {
		return restaurantDetailsDao.get(id);
	}

	@Override
	public RestaurantDetails getRestaurantDetailsByRegistrationNumber(String registrationNumber) {
		return restaurantDetailsDao.getByRegistrationNumber(registrationNumber);
	}
	
	@Override
	public List<RestaurantDetails> listAllRestaurantDetails() {
		return restaurantDetailsDao.list();
	}

	@Override
	public void deleteRestaurantDetails(long id) {
		restaurantDetailsDao.delete(id);
	}
	
	@Override
	public void updateRestaurantDetails(long id, RestaurantDetails restaurantDetails) {
		restaurantDetailsDao.update(id, restaurantDetails);
	}

	@Override
	public boolean isRestaurantDetailsExist(RestaurantDetails restaurantDetails) {
		return restaurantDetailsDao.isRestaurantDetailsExist(restaurantDetails);
	}
	
	@Override
	public List<RestaurantDetails> getByAddressList(List<Address> addresses) {
		return restaurantDetailsDao.getByAddressList(addresses);
	}
	
	@Override
	public void registerRestaurantDetailsUploadTest(MultipartFile file) {
		RestaurantDetails restaurantDetails = new RestaurantDetails();
		storageService.store(file);
		//storageService.loadFile(restaurantDetailsVO.getFile().getOriginalFilename());
		//String docmentPath = restaurantDetailsVO.getFile()
		restaurantDetails.setDocumentPath(file.getOriginalFilename());
		restaurantDetails.setRegistrationNumber("76998");
		restaurantDetails.setRestaurantName("Gandharva");
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