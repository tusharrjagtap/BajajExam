package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.app.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Table(name="lab_user")
@Data

public class User extends BaseEntity  {

	@Length(min = 4,max=20,message = "Invalid First Name length!!!!")
	@Column(length = 30)
	private String first_name;
	
	@Column(length = 20)
	//@NotEmpty(message ="Last Name can't be blank")
	
	
	@Length(min = 4,max=20,message = "Invalid Last Name length!!!!")	
	private String lastName;
	
	@Column(length = 60)
	//@NotEmpty(message="location must be supplied")
	private String address;
	
	@Column(length = 10)
	private long mobile;
	
	//@NotEmpty(message = "date of birthday must be Enter....")
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	@Enumerated(EnumType.STRING)
	private UserType role;
	
	@Column(length = 30)
	//@NotEmpty(message="College ID must be supplied")
	private String collegeId;
	
	@Column(name = "count_of_issue",length = 30)
     private Integer countOfIssues = 0;
    
	@Column(name = "fine",length = 30)
    private Integer fine;
	
	@Column(length = 30)
	private String email;
	
	@Column(length = 12)
	private Long addhar;
	
	@Column(length = 30)
	private String password;
	
	@ElementCollection
	private List<Issue> issuedBooks = new ArrayList<Issue>(); 
	

	public User() {
		
		// TODO Auto-generated constructor stub
	}

	public User(@Length(min = 4, max = 20, message = "Invalid First Name length!!!!") String first_name,
			@Length(min = 4, max = 20, message = "Invalid Last Name length!!!!") String lastName, String address,
			long mobile, LocalDate dob, UserType role, String collegeId, Integer fine,
			String email, Long addhar, String password) {
		super();
		this.first_name = first_name;
		this.lastName = lastName;
		this.address = address;
		this.mobile = mobile;
		this.dob = dob;
		this.role = role;
		this.collegeId = collegeId;
		
		this.fine = fine;
		this.email = email;
		this.addhar = addhar;
		this.password = password;
	}
	
	
	public Integer getFine() {
		return fine;
	}

	public void setFine(Integer fine) {
		this.fine = fine;
	}



	public String getEmail() {
		return email;
	}

	public Integer getCountOfIssues() {
		return countOfIssues;
	}

	public void setCountOfIssues(Integer countOfIssues) {
		this.countOfIssues = countOfIssues;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getAddhar() {
		return addhar;
	}

	public void setAddhar(Long addhar) {
		this.addhar = addhar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy = "user_id",
			cascade = CascadeType.ALL,fetch=FetchType.LAZY, orphanRemoval = true)
	@JsonIgnore
	public List<Issue> getIssuedBooks() {
		return issuedBooks;
	}
	public void setIssuedBooks(List<Issue> issuedBooks) {
		this.issuedBooks = issuedBooks;
	}

	public void addIssueRecord(Issue issueRecord)
	{
		this.issuedBooks.add(issueRecord);
		issueRecord.setUser_id(this);
	}

	public void removeIssueRecord(Issue issueRecord)
	{
		this.issuedBooks.remove(issueRecord);
		issueRecord.setUser_id(null);
	}
	
	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", lastName=" + lastName + ", address=" + address + ", mobile="
				+ mobile + ", dob=" + dob + ", role=" + role + ", collegeId=" + collegeId + ", CountOfIssued="
				+ countOfIssues + ", fine=" + fine + ", email=" + email + ", addhar=" + addhar + ", password="
				+ password + "]";
	}



	














	




	
	
	
	
}