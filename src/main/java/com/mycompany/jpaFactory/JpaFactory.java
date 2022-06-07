package com.mycompany.jpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JpaFactory {

    private static EntityManagerFactory factory;
    private EntityManager manager;

    public EntityManager getManager() {

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("pu");
        }
        manager = factory.createEntityManager();
        return manager;
    }

    public static void closeFactoryManager() {
        factory.close();
    }

}
