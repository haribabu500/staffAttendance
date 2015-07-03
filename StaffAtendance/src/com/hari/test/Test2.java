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
//		List<Staff> list=entityManager.createQuery("select s from Staff s where s.firstName like '%h%' or s.lastName like '%h%'").getResultList();
//		System.out.println(EasServiceManager.getStaffTable(list));
		for (Staff object : list) {
			System.out.println((">>>>>"+object.getUsernam()+">>>"+object.getPassword()+">>---"+object.getStartDate()));
		}
//		Staff staff=entityManager.find(Staff.class, 255);
//		System.out.println(staff.getFirstName());
		
//		EasServiceManager.remove("7402");
		System.out.println("done");
	}
	public static void main1(String[] args) {
		char arr[]={'a','b','c','d','e','f','g','h','i','j'};
		/*for(int i=0;i<arr.length;i=i+3){
			for(int j=i;j<i+3;j++){
				System.out.print(arr[j]);
			}
			System.out.println();
		}*/
		System.out.println(arr[9]);
		
	}
}
