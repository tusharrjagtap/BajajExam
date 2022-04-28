package com.app.pojos;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.app.enums.Category;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer bid;
	
    @Column(name = "title")
    private String title;

    
    @Column(name = "no_of_copies")
    private Integer noOfCopies;

    @Column(name = "author")
    private String  author;

    @Column(name = "publisher")
    private String  publisher;
    
    @Column(name = "language")
    private String  language;
    
    @Enumerated(EnumType.STRING)
    private Category  category;
    
    
    @UpdateTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @LastModifiedDate    
    @Column(name = "updated_at")
    private Date updatedAt;

	public Book() {
		
		// TODO Auto-generated constructor stub
	}

	public Book(String title, Integer noOfCopies, String author, String publisher, String language,
			 Category category, Date createdAt, Date updatedAt) {
		
		this.title = title;
		this.noOfCopies = noOfCopies;
		this.author = author;
		this.publisher = publisher;
		this.language = language;
		
		this.category = category;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid+"title=" + title + ", noOfCopies=" + noOfCopies + ", author=" + author
				+ ", publisher=" + publisher + ", language=" + language +  ", category="
				+ category + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
	
	
	
	
}
	