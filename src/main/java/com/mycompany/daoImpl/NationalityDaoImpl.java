package com.mycompany.daoImpl;

import com.mycompany.entity.Nationality;
import com.mycompany.daoInter.NationalityDaoInter;
import com.mycompany.jpaFactory.JpaFactory;
import java.util.List;
import javax.persistence.RollbackException;

public class NationalityDaoImpl extends JpaFactory implements NationalityDaoInter {

    @Override
    public List<Nationality> getAllNationality() {
        System.out.println("not writed inside this method");
        return null;
    }

    @Override
    public Nationality addNationality(final Nationality n) {

        try {
            if (n != null) {
                getManager().getTransaction().begin();
                getManager().persist(n);
                getManager().getTransaction().commit();
                return n;
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
    public Nationality removeNationality(Nationality nat) {
        try {
            if (nat != null) {
                getManager().getTransaction().begin();
                getManager().remove(nat);
                getManager().getTransaction().commit();
                return nat;
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
    public Nationality updateNationality(Nationality n) {

        try {
            if (n != null) {
                getManager().getTransaction().begin();
                getManager().merge(n);
                getManager().flush();
                getManager().getTransaction().commit();
                return n;
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
    public Nationality getNationalityById(int id) {

        try {
            Nationality nat = getManager().find(Nationality.class, id);
            return nat;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
