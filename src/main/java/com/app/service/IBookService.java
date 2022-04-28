package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.enums.Category;
import com.app.pojos.Book;

import com.app.pojos.Issue;
import com.app.pojos.User;


public interface IBookService {

	
   List<Book> getAllBooks();
   List<Book> findByAuthor(String author);  //added
   List<Book> findByTitle(String title);//done
   Book addOrUpdateBookDetails(Book e);
   //List<Book> searchByCategory(String category);
   List<Book> searchByCategory(Category category);
     

    
    

}
