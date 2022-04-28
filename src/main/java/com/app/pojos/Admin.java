package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.app.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="admin")
@Data

public class Admin extends BaseEntity{
	@Column(length = 30)
	private String first_name;
	
	@Column(length = 30)
	private String middle_name;
	
	@Column(length = 30)
	private String last_name;

	@Column(length = 30)
	private String email;
	
	@Column(length = 12)
	private long addhar;
	
	@Column(length = 30)
	private String username;
	
	@Column(length = 30)
	private String password;
	
	@Column(length = 10)
	private long mobile;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String first_name, String middle_name, String last_name, String email, long addhar, String username,
			String password, long mobile, Role role) {
		super();
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.email = email;
		this.addhar = addhar;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.role = role;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getAddhar() {
		return addhar;
	}

	public void setAddhar(long addhar) {
		this.addhar = addhar;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Admin [first_name=" + first_name + ", middle_name=" + middle_name + ", last_name=" + last_name
				+ ", email=" + email + ", addhar=" + addhar + ", username=" + username + ", password=" + password
				+ ", mobile=" + mobile + ", role=" + role + "]";
	}


	
	
}
