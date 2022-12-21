package com.UserManagementApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserManagementApp.entities.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

	public List<State> findBycountryId(int countryId);

}
