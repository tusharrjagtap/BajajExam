package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.enums.Role;
import com.app.pojos.Admin;
import com.app.service.IAdminService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	public AdminController() {
		System.out.println("in ctor of " + getClass());
	}
	
	@GetMapping
	public ResponseEntity<?> getAllAdminDetails()
	{
		System.out.println("in get all admin details");
	return new ResponseEntity <> (adminService.getAll(),HttpStatus.OK) ;
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Admin admin){
		Map<String,String> map = new HashMap<>();
		try {
			Admin adminByEmailAndPassword = adminService.findByEmailAndPassword(admin.getEmail(), admin.getPassword());
			if (adminByEmailAndPassword!=null) {
				map.put("adminID", adminByEmailAndPassword.getId().toString());
				map.put("email", adminByEmailAndPassword.getEmail());
				map.put("token", "123456");
				map.put("name", adminByEmailAndPassword.getFirst_name());
				map.put("role", (adminByEmailAndPassword.getRole()).toString());
				//map.put("role", admin.getRole());//adminByEmailAndPassword.getRole()
				//map.put("role", (admin.getRole()).toString());
			
				//return new ResponseEntity<>(map,HttpStatus.OK);
				return new ResponseEntity<>(map,HttpStatus.OK);
			} else {
				map.clear();
				map.put("message","Invalid admin");
				map.put("Token",null);
				return new ResponseEntity<>(map,HttpStatus.UNAUTHORIZED);
				//return "/admin/login";
			}
		} catch (Exception e) {
			map.clear();
			map.put("message",e.getMessage());
			map.put("Token",null);
			return new ResponseEntity<>(map,HttpStatus.UNAUTHORIZED);
			//return "/admin/login";
		}
	}
	

	@GetMapping("/{email}")
	public ResponseEntity<Admin> getadminByEmail(@PathVariable String email) {
			Admin admin = adminService.findByEmail(email);
		return new ResponseEntity<Admin>(admin, HttpStatus.CREATED);
	}
	
//	@GetMapping("/login")
//	public String showLoginFrom() {
//		System.out.println("in show login form");
//		return "/admin/login";
//	}
//
//	@PostMapping("/login") // @RequestMapping + method=POST
//	public String processLoginForm(@RequestParam(value="email") String email, @RequestParam(value="password") String password, Model map,
//			HttpSession session) {
//		System.out.println(" in login page ...............");
//		System.out.println("in process login form " + email + " " + password + " " + map);
//		try {
//			// controller has to invoke service layer method --for exec of B.L
//			
//			Admin admin = adminService.authenticate(email, password);// in case of success : DETACHED pojo
//			// in case of invalid login :
//			System.out.println("login successful...............");
//			// => valid login
//			// add validated user details , under Model map
//			session.setAttribute("admin_details", admin);
//			if (admin.getRole() == Role.Admin) {
//				
//			
//				System.out.println("login successful...............");
//				// map.addAttribute("topic_list", topicService.getAllTopics());
//				return "redirect:/admin/welcome";// UserController sends to D.S : redirect view name
//				// skips V.R ,
//				
//				// JSESSIONID : dfgsdf546735, | Body : EMPTY
//				// clnt browser : sends new request :
//				// http://host:port/day16_spring_mvc/customer/
//			}
//			System.out.println("login successful...............");
//			// admin login :
//			return "/admin/authenticate";// redirect view name , D.S skips  V.R --sends temp redirect resp
//			//next request will be sent form clnt browser : http://host:port/spring-mvc-boot/admin/welcome
//			//method = GET
//
//		} catch (RuntimeException e) {
//			System.out.println("err in class " + getClass() + "in  process login form " + e);// NoResultExc
//			// add err mesg in the model map
//			map.addAttribute("message", "Invalid Login , Please retry.....");
//			return "/admin/login";// in case of invalid login ---> forward clnt to login page + err mesg
//			// implicitly : map --model attr : message
//		}
//
//	}
	
}
