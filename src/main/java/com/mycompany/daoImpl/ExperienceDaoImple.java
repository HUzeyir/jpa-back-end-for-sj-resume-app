package com.mycompany.daoImpl;

import com.mycompany.daoInter.ExperienceDaoInter;
import com.mycompany.entity.Experience;
import com.mycompany.jpaFactory.JpaFactory;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

public class ExperienceDaoImple extends JpaFactory implements ExperienceDaoInter {

    @Override
    public List<Experience> getAllEcperience() {
        try {
            TypedQuery<Experience> typedQuery = getManager().createNamedQuery("Experience.getAllExperince", Experience.class);
            return typedQuery.getResultList();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Experience addExperience(final Experience experience) {

        try {
            if (experience != null) {
                getManager().getTransaction().begin();
                getManager().persist(experience);
                getManager().getTransaction().commit();
                return experience;
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            try {
                getManager().getTransaction().rollback();
            } catch (RollbackException e2) {
                System.out.println(e2.getMessage());
            }
        }
        return null;
    }

    @Override
    public List<Experience> getExperienceByUserId(Integer id) {

        if (id != null) {
            TypedQuery typedQuery = getManager().createNamedQuery("Experinece.findExperiencesByUserId", Experience.class);
            typedQuery.setParameter("id", id);
            return typedQuery.getResultList();
        }
        return null;
    }

    @Override
    public Experience findExperienceById(Integer id) {

        try {
            if (id != null) {
                Experience experience2 = getManager().find(Experience.class, id);
                return experience2;
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public Experience updateExperience(Experience experience) {

        try {
            if (experience != null) {
                getManager().getTransaction().begin();
                getManager().merge(experience);
                getManager().flush();
                getManager().getTransaction().commit();
                return experience;
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            try {
                getManager().getTransaction().rollback();
            } catch (RollbackException e2) {
                System.out.println(e2.getMessage());
            }
        }
        return null;
    }

    @Override
    public Experience removeExperience(Experience experience) {

        try {
            if (experience != null) {
                getManager().getTransaction().begin();
                getManager().remove(experience);
                getManager().getTransaction().commit();
                return experience;
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            try {
                getManager().getTransaction().rollback();
            } catch (RollbackException e2) {
                System.out.println(e2.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean removeExperienceById(Integer id) {

        try {
            if (id != null) {
                Query query = getManager().createNamedQuery("Experience.removeExperienceById");
                query.setParameter("id", id);
                return true;
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
