package com.javacloud.assetmanagementsystem.cloud.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "userdetails")
public class UserBean implements Serializable {

	@Id
	@Column
	private int id;

	@Column(name = "first_name")
	@Size(min = 3, message = "First name should be greater than 2")
	@Pattern(regexp = "[A-Z a-z]*", message = "field acceps only alphabets")
	@NotNull(message = "field is mandatory")
	private String firstName;

	@Column(name = "last_name")
	@Size(min = 1, message = "Last name should have atleast one letter")
	@Pattern(regexp = "[A-Z a-z]*", message = "field acceps only alphabets")
	@NotNull(message = "field is mandatory")
	private String lastName;

	@Column
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "invalid email, email should look like eg: john@gmail.com")
	@NotNull(message = "field is mandatory")
	private String email;

	@Column
	@NotNull(message = "field is mandatory")
	private String password;

	@Column
	private String role;

	@OneToMany(mappedBy = "userBean", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<RequestAsset> request;

	public UserBean() {
	}

	public UserBean(int id ,String firstName, String lastName, String email, String password, String role,
			List<RequestAsset> request) {
		this.id= id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.request = request;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<RequestAsset> getRequest() {
		return request;
	}

	public void setRequest(List<RequestAsset> request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", request=" + request + "]";
	}
	
	

}
