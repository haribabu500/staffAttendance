package com.hari.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String contact;
	private String address;
	private String usernam;
	private String password;
	private StaffType type;
	private Schedule schedule;
	@Temporal(value = TemporalType.DATE)
	private Date startDate;
	@Temporal(value = TemporalType.DATE)
	private Date leftDate;
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsernam() {
		return usernam;
	}
	public void setUsernam(String usernam) {
		this.usernam = usernam;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public StaffType getType() {
		return type;
	}
	public void setType(StaffType type) {
		this.type = type;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getLeftDate() {
		return leftDate;
	}
	public void setLeftDate(Date leftDate) {
		this.leftDate = leftDate;
	}
	
	
}
