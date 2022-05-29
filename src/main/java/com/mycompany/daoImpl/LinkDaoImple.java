package com.mycompany.daoImpl;

import com.mycompany.daoInter.LinkDaoInter;
import com.mycompany.entity.Link;
import com.mycompany.jpaFactory.JpaFactory;
import javax.persistence.RollbackException;

public class LinkDaoImple extends JpaFactory implements LinkDaoInter {

    @Override
    public Link addLink(Link link) {

        try {
            if (link != null) {
                getManager().getTransaction().begin();
                getManager().persist(link);
                getManager().getTransaction().commit();
                return link;
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
    public Link findLink(Integer id) {

        try {
            Link lang = getManager().find(Link.class, id);
            return lang;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Link updateLink(Link link) {

        try {
            if (link != null) {
                getManager().getTransaction().begin();
                getManager().merge(link);
                getManager().flush();
                getManager().getTransaction().commit();
                return link;
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
    public Link removeLink(Link link) {

        try {
            if (link != null) {
                getManager().getTransaction().begin();
                getManager().remove(link);
                getManager().getTransaction().commit();
                return link;
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
