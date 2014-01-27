package com.hari.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EasServiceManager {
	static EntityManager entityManager=Persistence.createEntityManagerFactory("STAFF_ATTENDANCE").createEntityManager();
	public static void save(Object object){
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
	}
	public static List<Object> select(String query,Class clasz){
		return entityManager.createQuery(query,clasz).getResultList();
	}
}
