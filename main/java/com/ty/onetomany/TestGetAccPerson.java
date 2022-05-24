package com.ty.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetAccPerson {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	
	Person person = entityManager.find(Person.class, 1);
	if (person != null) {
		System.out.println("The name is :" + person.getName());
		System.out.println("The cost is :" + person.getAddress());

		List<BankAccount> list = person.getAccount();
		for (BankAccount account : list) {
			System.out.println(account.getName());
			System.out.println(account.getIfsc());
			System.out.println("--------------------");
		}
	} else {
		System.out.println("Person does not exist");

	}
}
}

