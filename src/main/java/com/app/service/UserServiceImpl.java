package com.app.service;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.UserRepository;
import com.app.pojos.Book;
import com.app.pojos.Issue;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	//dependency : dao layer i/f
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private SessionFactory sf;

	@Override
	public List<User> getAll() {
		// Method of JpaRepository : super i/f dao layer i/f
		//Inherited API : public List<T> findAll();
		return userRepo.findAll();
	}

	@Override
	public User addOrUpdateUserDetails(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
		//CrudRepository Methd : save(T entity)
		//Checks if id == null => transient entity , will fire insert upon commit
		//if id != null => detached entity , will fire update upon commit
	}// what will method ret ? DETACHED emp ---> to the controller

	@Override
	public String deleteUserDetails(int id) {
		// service layer invokes dao's method
		userRepo.deleteById(id);
		return "User Details with ID " + id + " deleted successfuly... ";
	}

	@Override
	public User fetchUserDetails(int userId) {
		// invoke dao's method
		// Optional<Employee> optional = employeeRepo.findById(empId);
		return userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Emp by ID " + userId + " not found!!!!"));
	}

	
	@Override
	public Issue issueBook(int uid, Issue issueRecord, int bid) 
	{
		User u = sf.openSession().get(User.class, uid);
		
		u.addIssueRecord(issueRecord);
		u.setCountOfIssues(u.getCountOfIssues()+1);
		Book b = sf.openSession().get(Book.class, bid);
		b.setNoOfCopies(b.getNoOfCopies()-1);
		return null;
	}
	
	
	@Override
	public Issue returnBook(int iid)
	{
		Date returnDate = new Date();
		Issue issue = sf.openSession().get(Issue.class, iid);
		User u = sf.openSession().get(User.class, issue.getUser_id().getId());
		u.removeIssueRecord(issue);
		u.setCountOfIssues(u.getCountOfIssues()-1);
		if(issue.getDue_date().after(returnDate))
		{
			System.out.println("Tushar...");
			System.out.println(returnDate.compareTo(issue.getDue_date()));
			long diff = issue.getDue_date().getTime() - returnDate.getTime();
			int diffDays = (int)(diff / (24*60*60*1000));
			int fineDays = diffDays - 7;
			System.out.println(fineDays);
			if(fineDays > 0)
				u.setFine(fineDays*3);
		}
		Book b = sf.openSession().get(Book.class, issue.getBook_id());
		b.setNoOfCopies(b.getNoOfCopies()+1);
		return null;
	}

	
	@Override
	public List<Issue> getlistIssued() 
	{
		String jpql = "select i from Issue i";
		return sf.openSession().createQuery(jpql, Issue.class).getResultList();
	}


	@Override
	public List<Issue> getIsuuesById(int id) 
	{
		String jpql = "select u from User u join fetch u.issuedBooks where u.id = :id";
		User u = sf.openSession().createQuery(jpql,User.class).setParameter("id", id).getSingleResult();
		return u.getIssuedBooks();
	}
	
	
}
