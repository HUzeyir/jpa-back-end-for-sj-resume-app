package com.mycompany.jpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class JpaFactory {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");

    EntityManager manager = factory.createEntityManager();

    public EntityManager getManager() {

        return manager;
    }

//    public EntityTransaction getTransaction() {
//
//        return manager.getTransaction();
//    }

}
