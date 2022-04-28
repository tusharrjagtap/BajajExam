package com.app.service;

import java.util.List;

import com.app.pojos.Issue;
import com.app.pojos.User;

public interface IUserService {
	List<User> getAll();
	User addOrUpdateUserDetails(User transientUser);
	String deleteUserDetails(int id);
	User fetchUserDetails(int userId);
	Issue issueBook(int uid, Issue issueRecord, int bid);
	Issue returnBook(int iid);
	
	List<Issue> getIsuuesById(int id);
	List<Issue> getlistIssued();
}
