package com.ty.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDeleteMobileSim {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Mobile mobile=entityManager.find(Mobile.class,1);
	List<Sim> list=mobile.getSim();
	
	entityTransaction.begin();
	entityManager.remove(mobile);
	for(Sim sim:list)
	{
		entityManager.remove(sim);
	}
	entityTransaction.commit();
}
}
