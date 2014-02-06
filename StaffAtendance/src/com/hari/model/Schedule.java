package com.hari.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String sundayFrom;
	private String mondayFrom;
	private String tuesdayFrom;
	private String wednesdayFrom;
	private String thursdayFrom;
	private String fridayFrom;
	private String saturdayFrom;
	private String sundayTo;
	private String mondayTo;
	private String tuesdayTo;
	private String wednesdayTo;
	private String thursdayTo;
	private String fridayTo;
	private String saturdayTo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSundayFrom() {
		return sundayFrom;
	}
	public void setSundayFrom(String sundayFrom) {
		this.sundayFrom = sundayFrom;
	}
	public String getMondayFrom() {
		return mondayFrom;
	}
	public void setMondayFrom(String mondayFrom) {
		this.mondayFrom = mondayFrom;
	}
	public String getTuesdayFrom() {
		return tuesdayFrom;
	}
	public void setTuesdayFrom(String tuesdayFrom) {
		this.tuesdayFrom = tuesdayFrom;
	}
	public String getWednesdayFrom() {
		return wednesdayFrom;
	}
	public void setWednesdayFrom(String wednesdayFrom) {
		this.wednesdayFrom = wednesdayFrom;
	}
	public String getThursdayFrom() {
		return thursdayFrom;
	}
	public void setThursdayFrom(String thursdayFrom) {
		this.thursdayFrom = thursdayFrom;
	}
	public String getFridayFrom() {
		return fridayFrom;
	}
	public void setFridayFrom(String fridayFrom) {
		this.fridayFrom = fridayFrom;
	}
	public String getSaturdayFrom() {
		return saturdayFrom;
	}
	public void setSaturdayFrom(String saturdayFrom) {
		this.saturdayFrom = saturdayFrom;
	}
	public String getSundayTo() {
		return sundayTo;
	}
	public void setSundayTo(String sundayTo) {
		this.sundayTo = sundayTo;
	}
	public String getMondayTo() {
		return mondayTo;
	}
	public void setMondayTo(String mondayTo) {
		this.mondayTo = mondayTo;
	}
	public String getTuesdayTo() {
		return tuesdayTo;
	}
	public void setTuesdayTo(String tuesdayTo) {
		this.tuesdayTo = tuesdayTo;
	}
	public String getWednesdayTo() {
		return wednesdayTo;
	}
	public void setWednesdayTo(String wednesdayTo) {
		this.wednesdayTo = wednesdayTo;
	}
	public String getThursdayTo() {
		return thursdayTo;
	}
	public void setThursdayTo(String thursdayTo) {
		this.thursdayTo = thursdayTo;
	}
	public String getFridayTo() {
		return fridayTo;
	}
	public void setFridayTo(String fridayTo) {
		this.fridayTo = fridayTo;
	}
	public String getSaturdayTo() {
		return saturdayTo;
	}
	public void setSaturdayTo(String saturdayTo) {
		this.saturdayTo = saturdayTo;
	}
}
