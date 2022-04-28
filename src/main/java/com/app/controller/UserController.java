package com.app.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Issue;
import com.app.pojos.User;
import com.app.service.IUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {
//	//dependency : service layer i/f
	@Autowired
	private IUserService userService;
	
	
	public UserController() {
		System.out.println("in ctor of " + getClass());
	}
	//add request handling method to send all emps to the caller(front end) : getting resources : GET

	@GetMapping
	public ResponseEntity<?> getAllUserDetails()
	{
		System.out.println("in get all users");
	return new ResponseEntity <> (userService.getAll(),HttpStatus.OK) ;
	}
	//add request handling method to insert new emp detaild(create a new resource) : POST
	
	@PostMapping
	public User addUserDetails(@RequestBody  User e) //de-serial (un marshalling)
	{
		
		System.out.println("in add User "+e);
		return userService.addOrUpdateUserDetails(e);
	}
	
	//add request handling method to delete emp details by emp id
	//Request URL  sent by front end : http://host:port/api/Users/1234 , method=DELETE
	@DeleteMapping("/{id}")
	public String deleteUserDetails(@PathVariable int id)
		{
	System.out.println("in del user dtls "+id);
		return userService.deleteUserDetails(id);
	}
	
//	//add req handling method to get selected emp details by id.
//	//URL : http://host:port/api/Users/1234 , method=GET
	@GetMapping("/details/{userId}")
	public ResponseEntity<?> getUserDetails(@PathVariable int userId)
	{
		System.out.println("in get user dtls "+userId);
//		//invoke service layer's method
		try {
			// invoke service layer's method
			return new ResponseEntity<>(userService.fetchUserDetails(userId), HttpStatus.OK);
		}catch (Exception e) {
			System.out.println("err in get user dtls"+e);
			return new ResponseEntity<> (e.getMessage(),HttpStatus.NOT_FOUND);
			
			
		}
//
	}
	
	
	//add request handling method to update existing emp details (update a  resource) : PUT
		@PutMapping
		public User updateUserDetails(@RequestBody  User e) //de-serial (un marshalling) 
		{
			//e : DETACHED POJO , containing updated state
			System.out.println("in putmapping user "+e);
			return userService.addOrUpdateUserDetails(e);
	}
		
		
		@PostMapping("/issue/{uid}/{bid}")
		public ResponseEntity<?> issueBook(@PathVariable int uid, @PathVariable int bid)
		{
			int days = 7;
			Date d = new Date();
//			System.out.println(d.getDate());
//			System.out.println(d.getMonth()+1);
//			System.out.println(d.getYear()+1900);
			Date dueDate = new Date();
			dueDate.setTime(d.getTime() + (days * 24 * 60 * 60 * 1000));
			System.out.println(dueDate);
			Issue issueRecord = new Issue(d,dueDate);
			issueRecord.setBook_id(bid);
			Issue issued = userService.issueBook(uid,issueRecord,bid);
			if (issued == null)
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<Issue>(issued, HttpStatus.OK);
		}
		
		@GetMapping("return/{iid}")
		public ResponseEntity<?> returnBook(@PathVariable int iid)
		{
			Issue issued = userService.returnBook(iid);
			return null;
//			if (issued == null)
//				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//			return new ResponseEntity<Issue>(issued, HttpStatus.OK);
		}
		
		@GetMapping("/issuedlist")
		public ResponseEntity<?> getIssuesdList()
		{
			List<Issue> issues = userService.getlistIssued();
			if (issues.size() == 0)
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<Issue>>(issues, HttpStatus.OK);
		}
		
		@GetMapping("/issuesbyid/{id}")
		public ResponseEntity<?> getIssuedBooksById(@PathVariable int id)
		{
			List<Issue> issues = userService.getIsuuesById(id);
			if (issues.size() == 0)
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<Issue>>(issues, HttpStatus.OK);
		}
		
		
		
		
}
