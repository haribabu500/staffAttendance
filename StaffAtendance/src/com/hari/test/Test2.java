package com.hari.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hari.model.Staff;
import com.hari.model.Test;
import com.hari.service.EasServiceManager;

public class Test2 {
	//hari krishna shrestha
	public static void main(String[] args) {
		EntityManager entityManager=Persistence.createEntityManagerFactory("STAFF_ATTENDANCE").createEntityManager();
		entityManager.getTransaction().begin();
		List<Staff> list=entityManager.createQuery("select s from Staff s").getResultList();
		System.out.println(EasServiceManager.getStaffTable(list));
		for (Staff object : list) {
			System.out.println((object.getStartDate()));
		}
		Staff staff=entityManager.find(Staff.class, 255);
		System.out.println(staff.getFirstName());
	}
}
