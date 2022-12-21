package com.UserManagementApp.service;

import java.util.List;

import com.UserManagementApp.entities.City;
import com.UserManagementApp.entities.Country;
import com.UserManagementApp.entities.State;
import com.UserManagementApp.model.Login;
import com.UserManagementApp.model.UnlockAccount;
import com.UserManagementApp.model.User;

public interface UserServiceI {

	public List<Country> getAllCountries();
	
	public List<State> getAllStates(int countryId);

	public List<City> getAllCities(int stateId);

	public boolean saveUser(User user);
	
	public String loginCheck(Login login);

	public boolean unlockAccount(UnlockAccount unlockAccount);

    public String forgotPassword(String email);

}

