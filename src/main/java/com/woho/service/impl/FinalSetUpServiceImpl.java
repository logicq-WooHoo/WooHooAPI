package com.woho.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woho.dao.UserInformationDao;
import com.woho.service.FinalSetUpService;
import com.woho.service.RegistrationService;
import com.woho.vo.FinalSetUpVO;

@Service
@Transactional
public class FinalSetUpServiceImpl implements FinalSetUpService{

	
	@Autowired
	RegistrationService registrationService;
	@Autowired
	UserInformationDao userInformationDao;
	
	@Override
	public void finalRestaurentSetup(FinalSetUpVO finalSetUpVO) throws Exception {

		
		//Adding User Information in Db
		if(null!=finalSetUpVO.getUserInformation())
			finalSetUpVO.setUserInformation(userInformationDao.addUser(finalSetUpVO.getUserInformation()));
		
		
		//Adding Restaurent Detail in Db
		if(null!=finalSetUpVO.getRestaurantDetails()){
			
			if (registrationService.isRestaurantDetailsExist(finalSetUpVO.getRestaurantDetails())) {
				System.out.println("A RestaurantDetails with registrationNumber "
						+ finalSetUpVO.getRestaurantDetails().getRegistrationNumber() + " already exist");
				
			}else{
				//Adding UserInformation to Restaurent Detail 
				finalSetUpVO.getRestaurantDetails().setUserInformation(finalSetUpVO.getUserInformation());
				
				finalSetUpVO.setRestaurantDetails(registrationService.saveRestaurantDetails(finalSetUpVO.getRestaurantDetails()));
			}

		}
		
		//Adding Restaurent SetUp
		if(null!=finalSetUpVO.getRestaurantSetupVO()){
		//Adding Restaurent Detail in Set up the Restaurent	
		finalSetUpVO.getRestaurantSetupVO().setRestaurantDetails(finalSetUpVO.getRestaurantDetails());
		
		registrationService.registerRestaurantSetup(finalSetUpVO.getRestaurantSetupVO());
		}
		
		
		//Adding Restaurent Menu
		if(null!=finalSetUpVO.getRestaurantMenuVO()){
		registrationService.registerRestaurantMenu(finalSetUpVO.getRestaurantMenuVO());
		}
	
	}

}
