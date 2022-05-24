package com.ty.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDeletePersonAcc {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Person person=entityManager.find(Person.class, 2);
	List<BankAccount> accounts=person.getAccount();
	entityTransaction.begin();
	for(BankAccount bankAccount:accounts)
	{
		entityManager.remove(bankAccount);
	}
	
	entityManager.remove(person);
	entityTransaction.commit();
}
}
