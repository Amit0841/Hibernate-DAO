package com.masai.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class connectionClass {
static EntityManagerFactory emf;

static{
	emf= Persistence.createEntityManagerFactory("Student_connect");
}
static EntityManager connectionget() {
	return emf.createEntityManager();
	
}
}
