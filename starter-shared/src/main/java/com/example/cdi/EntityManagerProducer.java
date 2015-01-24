package com.example.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;


/**
 * CDI Producer to expose the entity manager
 */
@ApplicationScoped
public class EntityManagerProducer {
    @PersistenceUnit(unitName = "primary")
    private EntityManagerFactory emf;

    @Produces
    @Default
    @RequestScoped
    public EntityManager create() {
        return this.emf.createEntityManager();
    }

    public void close(@Disposes @Default EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }


}
