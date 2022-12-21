package com.UserManagementApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserManagementApp.entities.UserAccountEntity;


@Repository
public interface UserRepository extends JpaRepository<UserAccountEntity, Integer>{

	public UserAccountEntity findByEmailAndPassword(String email, String password);

	public UserAccountEntity findByEmail(String email);

}
