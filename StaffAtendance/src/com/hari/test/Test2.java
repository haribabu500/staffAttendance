package com.hari.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hari.model.Test;

public class Test2 {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("STAFF_ATTENDANCE").createEntityManager();
		Test test=new Test();
		test.setName("babu");
		em.getTransaction().begin();
		em.persist(test);
		em.getTransaction().commit();
		System.out.println("done");
	}
}
