package com.service;

import java.util.List;

import com.Entity.Employeees;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Operations {
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("de");
	
	public boolean insert(Employeees e1) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		try {
			et.begin();
			em.persist(e1);
			et.commit();
			return true;	
		}catch(Exception e) {
			return false;
		}
		finally {
			em.close();
		}			
	}
	
	
	
	public List<Employeees> all(){
		
		EntityManager em=emf.createEntityManager();
		String str="from Employeees";
		Query q = em.createQuery(str,Employeees.class);
		List<Employeees> resultList = q.getResultList();
		return resultList;
	}
	
	
	
	public void update(Employeees e1) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(e1);
		et.commit();	
	}
	
	
	
	public void delete(int i) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Employeees e1=em.find(Employeees.class, i);
		et.begin();
		em.remove(e1);
		et.commit();	
	}
	
	
	
	
	public Employeees display(int i) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Employeees e1=em.find(Employeees.class, i);
		return e1;
	}
	

}
