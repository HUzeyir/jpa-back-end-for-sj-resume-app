package com.mycompany.daoImpl;

import com.mycompany.daoInter.PhoneDaoInter;
import com.mycompany.entity.Phone;
import com.mycompany.jpaFactory.JpaFactory;
import java.util.List;
import javax.persistence.RollbackException;

public class PhoneDaoImple extends JpaFactory implements PhoneDaoInter {

    @Override
    public List<Phone> getAllPhone() {
        System.err.println("not writed inside this method, you can use logger instide it");
        return null;
    }

    @Override
    public Phone addPhone(Phone phone) {
        try {
            if (phone != null) {
                getManager().getTransaction().begin();
                getManager().persist(phone);
                getManager().getTransaction().commit();
                return phone;
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
    public Phone findPhone(Integer id) {

        try {
            Phone lang = getManager().find(Phone.class, id);
            return lang;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Phone updatePhone(Phone phone) {

        try {
            if (phone != null) {
                getManager().getTransaction().begin();
                getManager().merge(phone);
                getManager().flush();
                getManager().getTransaction().commit();
                return phone;
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
    public Phone removePhone(Phone phone) {

        try {
            if (phone != null) {
                getManager().getTransaction().begin();
                getManager().remove(phone);
                getManager().getTransaction().commit();
                return phone;
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
