package com.app.service;

import java.util.List;

import com.app.pojos.Admin;
import com.app.pojos.Book;


public interface IAdminService {

	//Admin authenticateAdmin(String email, String password);

	List<Admin> getAll();

	Admin findByEmail(String email);
	Admin findByEmailAndPassword(String adminId, String password);
	

	Admin authenticate(String email, String password);

	


	
	
	
	
}
