package com.hari.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.hari.model.Staff;

public class EasServiceManager {
	static EntityManager entityManager=Persistence.createEntityManagerFactory("STAFF_ATTENDANCE").createEntityManager();
	public static void save(Object object){
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
	}
	public static void update(Object object){
		entityManager.getTransaction().begin();
		entityManager.merge(object);
		entityManager.getTransaction().commit();
	}
	public static List<Object> select(String query,Class clasz){
		return entityManager.createQuery(query,clasz).getResultList();
	}
	public static String printDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(date!=null)
				return sdf.format(date);
		else
				return "-";
	}
	public static String getStaffTable(List<Staff> staffs){
		String htmlTable="<table border='1' cellspacing='0' cellpadding='0' class='staffTable'><thead>";
		htmlTable=htmlTable.concat("<tr><th>Name</th><th>Contact</th><th>Address</th>" +
				"<th>Staff Type</th><th>Start Date</th><th>Left Date</th><th></th></tr></thead><tbody>");
		for (Staff staff: staffs) {
			htmlTable=htmlTable.concat("<tr name='"+staff.getId()+"'>");
				htmlTable=htmlTable.concat("<td>"+staff.getFirstName()+" "+staff.getLastName()+"</td>");
				htmlTable=htmlTable.concat("<td>"+staff.getContact()+"</td>");
				htmlTable=htmlTable.concat("<td>"+staff.getAddress()+"</td>");
//				htmlTable=htmlTable.concat("<td>"+staff.getUsernam()+"</td>");
				htmlTable=htmlTable.concat("<td>"+staff.getType().getType()+"</td>");
				htmlTable=htmlTable.concat("<td>"+EasServiceManager.printDate(staff.getStartDate())+"</td>");
				htmlTable=htmlTable.concat("<td>"+EasServiceManager.printDate(staff.getLeftDate())+"</td>");
				htmlTable=htmlTable.concat("<td><button class=' routine aqua small' name='"+staff+"'>Routine</button></td>");
			htmlTable=htmlTable.concat("</tr>");	
		}
		htmlTable=htmlTable.concat("</tbody></table>");
		return htmlTable;
	}
	public static String getRemoveStaffTable(List<Staff> staffs){
		String htmlTable="<table border='1' cellspacing='0' cellpadding='0' class='staffTable'><thead>";
		htmlTable=htmlTable.concat("<tr><th>Name</th><th>Contact</th><th>Address</th>" +
				"<th>Staff Type</th><th>Start Date</th><th>Left Date</th><th></th></tr></thead><tbody>");
		for (Staff staff: staffs) {
			htmlTable=htmlTable.concat("<tr>");
				htmlTable=htmlTable.concat("<td>"+staff.getFirstName()+" "+staff.getLastName()+"</td>");
				htmlTable=htmlTable.concat("<td>"+staff.getContact()+"</td>");
				htmlTable=htmlTable.concat("<td>"+staff.getAddress()+"</td>");
//				htmlTable=htmlTable.concat("<td>"+staff.getUsernam()+"</td>");
				htmlTable=htmlTable.concat("<td>"+staff.getType().getType()+"</td>");
				htmlTable=htmlTable.concat("<td>"+EasServiceManager.printDate(staff.getStartDate())+"</td>");
				htmlTable=htmlTable.concat("<td>"+EasServiceManager.printDate(staff.getLeftDate())+"</td>");
				htmlTable=htmlTable.concat("<td><button class='remove small remStaff' name='"+staff+"'>Remove</button></td>");
			htmlTable=htmlTable.concat("</tr>");	
		}
		htmlTable=htmlTable.concat("</tbody></table>");
		return htmlTable;
	}
	public static void remove(String oid){
		List list=select("select s from Staff s", Staff.class);
		for (Object staff : list) {
			if(staff.toString().equals(oid)){
				entityManager.getTransaction().begin();
				entityManager.remove(staff);
				entityManager.getTransaction().commit();
			}
		}
	}
	public static Staff getSingleStaff(int id){
		return entityManager.find(Staff.class, id);
	}
}
