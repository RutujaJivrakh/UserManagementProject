package com.UserManagementApp.service;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserManagementApp.entities.City;
import com.UserManagementApp.entities.Country;
import com.UserManagementApp.entities.State;
import com.UserManagementApp.entities.UserAccountEntity;
import com.UserManagementApp.model.Login;
import com.UserManagementApp.model.UnlockAccount;
import com.UserManagementApp.model.User;
import com.UserManagementApp.repositories.CityRepository;
import com.UserManagementApp.repositories.CountryRepository;
import com.UserManagementApp.repositories.StateRepository;
import com.UserManagementApp.repositories.UserRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserServiceI{

	
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Country> getAllCountries() {
		List<Country> findAll = countryRepository.findAll();
		return findAll;
	}

	
	@Override
	public List<State> getAllStates(int countryId) {
		List<State> findBycountryId = stateRepository.findBycountryId(countryId);
		return findBycountryId;
	}

	
	@Override
	public List<City> getAllCities(int stateId) {
		List<City> findBystateId = cityRepository.findBystateId(stateId);
		return findBystateId;
	}


	@Override
	public boolean saveUser(User user) {
		
		user.setAccStatus("LOCKED");
		user.setPassword(generateRandomPassword());
		
		UserAccountEntity userAccountEntity=new UserAccountEntity();
		
		BeanUtils.copyProperties(user, userAccountEntity);
		
		UserAccountEntity entity = userRepository.save(userAccountEntity);
		
		if(entity != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	private String generateRandomPassword()
	{
		String randomAlphanumeric = RandomStringUtils.randomAlphanumeric(6);
		return randomAlphanumeric;
	}


	
	
	@Override
	public String loginCheck(Login login) {
		
		String email=login.getEmail();
		String password=login.getPassword();
		
		UserAccountEntity userAccountEntity = userRepository.findByEmailAndPassword(email, password);
		
		if(userAccountEntity !=null)
		{
		     if(userAccountEntity.getAccStatus().equals("UNLOCKED"))
		     {
			     return "Login Success";
	         }
		     else
		     {
		    	 return "Your Account Is Locked";
		     }
		}
		else
		{
			return "Invalid Credentials";
		}
		
	}


	
	
	@Override
	public boolean unlockAccount(UnlockAccount unlockAccount) {

		String tempPwd = unlockAccount.getTempPassword();
		String email = unlockAccount.getEmail();
		
		UserAccountEntity user = userRepository.findByEmailAndPassword(email, tempPwd);
		
		if(user !=null)
		{
			user.setAccStatus("UNLOCKED");
			user.setPassword(unlockAccount.getNewPassword());
		    userRepository.save(user);
		    return true;
		}
		else
		{
			return false;
		}
	}


	@Override
	public String forgotPassword(String email) {
		
		UserAccountEntity findByEmail = userRepository.findByEmail(email);
		
		if(findByEmail !=null)
		{
			return "Mail is sent to your registered mail id";
		}
		else
		{
		   return "Mail is not Registered Please Register First";
		}
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
}
