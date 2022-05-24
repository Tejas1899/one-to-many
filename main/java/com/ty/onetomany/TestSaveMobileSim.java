package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobileSim {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Mobile mobile=new Mobile();
	mobile.setName("Samsung");
	mobile.setCost(70000);
	
	Sim sim1=new Sim();
	sim1.setProvider("Airtel");
	sim1.setType("3G");
	Sim sim2=new Sim();
	sim2.setProvider("BSNL");
	sim2.setType("4G");
	List<Sim> list=new ArrayList<Sim>();
	list.add(sim1);
	list.add(sim2);
	mobile.setSim(list);
	
	entityTransaction.begin();
	entityManager.persist(mobile);
	entityManager.persist(sim1);
	entityManager.persist(sim2);
	entityTransaction.commit();
	System.out.println("------------");
}
}
