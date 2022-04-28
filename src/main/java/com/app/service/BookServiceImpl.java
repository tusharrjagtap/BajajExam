package com.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.constant.Constants;
import com.app.custom_exception.DependanceyException;
import com.app.custom_exception.RecordNotFound;
import com.app.dao.BookRepository;

import com.app.dao.UserRepository;
import com.app.enums.Category;
import com.app.pojos.Book;
import com.app.pojos.Issue;
import com.app.pojos.User;
@Service
@Transactional
public class BookServiceImpl implements IBookService{
	@Autowired 
	private BookRepository bookRepo;

//	@Autowired 
//	private IBookService bookService;
//	
//	@Autowired
//	private EntityManager manager;
	
	   
//	   @Autowired
//	   private UserRepository userRepo;
	
	
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public List<Book> findByAuthor(String author) {
		List<Book> book=bookRepo.findByAuthor(author);
		return book;
	}

	@Override
	public List<Book> findByTitle(String title) {
		List<Book> book =bookRepo.findByTitle(title);
		return book;
	}
	
	@Override
	public List<Book> searchByCategory(Category category) {
		// TODO Auto-generated method stub
		List<Book> book =bookRepo.findByCategory(category);
		return book;
	}
	@Override
	public Book addOrUpdateBookDetails(Book e) {
		// TODO Auto-generated method stub
		return bookRepo.save(e);
	}












}
