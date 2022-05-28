package com.mycompany.jpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JpaFactory {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");

    public EntityManager getManager() {

        return factory.createEntityManager();
    }

}
