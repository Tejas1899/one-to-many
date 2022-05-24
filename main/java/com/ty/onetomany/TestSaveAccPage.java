package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveAccPage {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	UserAccount account=new UserAccount();
	account.setEmail("raj@mail.com");
	account.setMobile("897976664");
	account.setName("raj");
	account.setPassword(" 777");
	
	Page page1=new Page();
	page1.setName("Vintage_Collection");
	page1.setTitle("Vintage Cars");
	page1.setDescription("About old vintage cars");
	Page page2=new Page();
	page2.setName("Reels page");
	page2.setTitle("Kannada reels");
	page2.setDescription("Aabout kannada reels");
	List<Page> list=new ArrayList<Page>();
	list.add(page2);
	list.add(page1);
	account.setPage(list);
	
	entityTransaction.begin();
	entityManager.persist(account);
	entityManager.persist(page1);
	entityManager.persist(page2);
	entityTransaction.commit();
}
}
