package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonBank {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Person person=new Person();
	person.setName("tej");
	person.setAddress("Nagarbhavi");
	
	BankAccount account1=new BankAccount();
	account1.setName("SBI");
	account1.setIfsc("kakban741");
	
	BankAccount account2=new BankAccount();
	account2.setName("Karnataka");
	account2.setIfsc("karb000914");
	List<BankAccount> list=new ArrayList<BankAccount>();
	list.add(account2);
	list.add(account1);
	person.setAccount(list);
	
	entityTransaction.begin();
	entityManager.persist(account2);
	entityManager.persist(account1);
	entityManager.persist(person);
	entityTransaction.commit();
	
}
}
