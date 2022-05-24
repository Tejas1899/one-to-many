package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetMobileSim {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Mobile mobile = entityManager.find(Mobile.class, 1);
		if (mobile != null) {
			System.out.println("The mob name is :" + mobile.getName());
			System.out.println("The mob cost is :" + mobile.getCost());

			List<Sim> list = mobile.getSim();
			for (Sim sim : list) {
				System.out.println(sim.getProvider());
				System.out.println(sim.getType());
				System.out.println("--------------------");
			}
		} else {
			System.out.println("mobile does not exist");

		}
	}
}
