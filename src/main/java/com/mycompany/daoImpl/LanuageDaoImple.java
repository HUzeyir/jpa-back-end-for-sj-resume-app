package com.mycompany.daoImpl;

import com.mycompany.daoInter.LanguageDaoInter;
import com.mycompany.entity.Language;
import com.mycompany.jpaFactory.JpaFactory;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

public class LanuageDaoImple extends JpaFactory implements LanguageDaoInter {

    @Override
    public List<Language> getAllLanguage() {

        try {
            Query query = getManager().createNamedQuery("Language.findAllLanguage");
            return query.getResultList();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Language addLanguage(Language lang) {

        try {
            if (lang != null) {
                getManager().getTransaction().begin();
                getManager().persist(lang);
                getManager().getTransaction().commit();
                return lang;
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
    public Language findLanguage(Integer id) {
        try {

            Language lang = getManager().find(Language.class, id);
            return lang;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public Language updateLanguage(Language lang) {

        try {
            if (lang != null) {
                getManager().getTransaction().begin();
                getManager().merge(lang);
                getManager().getTransaction().commit();
                return lang;
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
    public Language removeLanguage(Language lang) {

        try {
            if (lang != null) {
                getManager().getTransaction().begin();
                getManager().remove(lang);
                getManager().getTransaction().commit();
                return lang;
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

}
