package com.mycompany.daoImpl;

import com.mycompany.daoInter.EducationDaoInter;
import com.mycompany.entity.Education;
import com.mycompany.jpaFactory.JpaFactory;
import java.util.List;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

public class EducationDaoImple extends JpaFactory implements EducationDaoInter {

    @Override
    public List<Education> getAllEducation() {
        try {
            TypedQuery<Education> typedQuery = getManager().createNamedQuery("Education.getAllEducation", Education.class);
            return typedQuery.getResultList();
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
    public Education addEducation(Education education) {

        try {
            if (education != null) {
                getManager().getTransaction().begin();
                getManager().persist(education);
                getManager().getTransaction().commit();
                return education;
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
    public Education findEducationById(Integer id) {

        try {
            if (id != null) {
                Education edu = getManager().find(Education.class, id);
                return edu;
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public Education removeEducatin(Education education) {

        try {
            if (education != null) {
                int id = education.getId();
                Education edu = findEducationById(new Integer(id));
                getManager().remove(edu);
                return edu;
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
    public Education updateEducation(Education education) {

        if (education != null && getManager().contains(education)) {
            try {
                getManager().getTransaction().begin();
                getManager().merge(education);
                getManager().flush();
                getManager().getTransaction().commit();
                return education;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                try {
                    getManager().getTransaction().rollback();
                } catch (RollbackException e2) {
                    System.out.println(e2.getMessage());
                }
            }
        }
        return null;

    }

}
