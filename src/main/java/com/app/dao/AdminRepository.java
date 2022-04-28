package com.app.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Admin;


public interface AdminRepository extends JpaRepository<Admin, String> {

	Admin findByEmailAndPassword(String email, String password);
	
	Admin findByEmail(String email);

	//Admin findByEmailAndAdminPassword(String email, String password);






	

	
	

}
