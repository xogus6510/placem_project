package com.placem.phonebook.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "members")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column (name = "first_name")
	private String firstName;
	
	@Column (name = "last_name")
	private String lastName; 
	
	@Column (name = "email")
	private String email; 
	
	protected Member() {}
	
	public Member(String firstName, String lastName, String email) {
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.email = email; 
	}
	
	public long getId() {
		return id; 
	}
	
	public String getFirstName () {
		return firstName; 
	}
	
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName; 
	}
	
	public void setLastName (String lastName) {
		this.lastName = lastName; 
	}
	
	public String getEmail() {
		return email; 
	}
	
	public void setEmail(String email) {
		this.email = email; 
	}
	
	public String toString() {
		return String.format("Employee[id=%d, firstName='%s', lastName='%s', email='%s']", id, firstName, lastName, email);
	}
	
}
