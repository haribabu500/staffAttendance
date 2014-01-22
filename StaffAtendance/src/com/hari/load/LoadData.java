package com.hari.load;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.hari.model.StaffType;

public class LoadData {

	public static void main(String[] args) {
		String[] type={"partTime","fullTime","admin"};
		for (int i = 0; i < type.length; i++) {
			StaffType staffType=new StaffType();
			staffType.setType(type[i]);
			save(staffType);
		}
	}
	public static void save(Object object){
		EntityManager entityManager=Persistence.createEntityManagerFactory("STAFF_ATTENDANCE").createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
	}

}
