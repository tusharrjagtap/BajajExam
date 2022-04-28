package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.app.enums.StaffDept;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="lab_staff")
@Data
public class Staff extends BaseEntity {
	@Column(length = 30)
	private String first_name;
	
	@Column(length = 30)
	private String middle_name;
	
	@Column(length = 30)
	private String last_name;

	@Column(length = 30)
	private String gender;
	
	@Column(length = 30)
	private String address;
	
	@Column(length=20)
	private long mobile;
	
	@Column(length = 30)
	@Enumerated(EnumType.STRING)
//JsonProperty("department")
	private StaffDept dept;
	
	@Column(length=20)
	private LocalDate dob;
	
	@Column(length=20)
	private LocalDate join_date;
	
	@Column(length=20)
	private double yr_experience;

	@Column(length=20)
	private double salary;
	
	
	@Column(length=20)
	private double bonus;
	
	@Column(length=20)
	private LocalDate leaving_date;
	
	@Column(length = 30)
	private String email;
	
	@Column(length = 12)
	private Long addhar;
	
	@Column(length = 30)
	private String password;


	public Staff() {
		
		// TODO Auto-generated constructor stub
	}

	public Staff(String first_name, String middle_name, String last_name, String gender, String address, long mobile,
			StaffDept dept, LocalDate dob, LocalDate join_date, double yr_experience, double salary, double bonus,
			LocalDate leaving_date) {
		super();
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.gender = gender;
		this.address = address;
		this.mobile = mobile;
		this.dept = dept;
		this.dob = dob;
		this.join_date = join_date;
		this.yr_experience = yr_experience;
		this.salary = salary;
		this.bonus = bonus;
		this.leaving_date = leaving_date;
	}
	public Staff(String email, Long addhar, String password) {
		super();
		this.email = email;
		this.addhar = addhar;
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public StaffDept getDept() {
		return dept;
	}

	public void setDept(StaffDept dept) {
		this.dept = dept;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getJoin_date() {
		return join_date;
	}

	public void setJoin_date(LocalDate join_date) {
		this.join_date = join_date;
	}

	public double getYr_experience() {
		return yr_experience;
	}

	public void setYr_experience(double yr_experience) {
		this.yr_experience = yr_experience;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public LocalDate getLeaving_date() {
		return leaving_date;
	}

	public void setLeaving_date(LocalDate leaving_date) {
		this.leaving_date = leaving_date;
	}


	public String getEmail() {
		return email;
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



	public String toString1() {
		return "FacultyLogin [email=" + email + ", addhar=" + addhar + ", password=" + password + "]";
	}
	
	
	@Override
	public String toString() {
		return "Staff [first_name=" + first_name + ", middle_name=" + middle_name + ", last_name=" + last_name
				+ ", gender=" + gender + ", address=" + address + ", mobile=" + mobile + ", dept=" + dept + ", dob="
				+ dob + ", join_date=" + join_date + ", yr_experience=" + yr_experience + ", salary=" + salary
				+ ", bonus=" + bonus + ", leaving_date=" + leaving_date + "]";
	}

	
	
	
}
