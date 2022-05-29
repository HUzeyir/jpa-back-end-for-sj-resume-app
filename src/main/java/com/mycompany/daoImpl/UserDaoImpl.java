package com.mycompany.daoImpl;

import com.mycompany.daoInter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.jpaFactory.JpaFactory;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.RollbackException;

public class UserDaoImpl extends JpaFactory implements UserDaoInter {

    @Override
    public List<User> getAllUser() {
        Query query = getManager().createNamedQuery("User.findAllUser");
        return query.getResultList();
    }

    @Override
    public User addUser(final User user) {
        try {
            if (user != null) {
                getManager().getTransaction().begin();
                getManager().persist(user);
                getManager().getTransaction().commit();
                return user;
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
    public User findUser(Integer id) {
        try {
            User lang = getManager().find(User.class, id.longValue());
            return lang;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        try {
            if (user != null) {
                getManager().getTransaction().begin();
                getManager().merge(user);
                getManager().flush();
                getManager().getTransaction().commit();
                return user;
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
    public User removeUser(User user) {
        try {
            if (user != null) {
                getManager().getTransaction().begin();
                getManager().remove(user);
                getManager().getTransaction().commit();
                return user;
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
    public User findUserFullById(Integer id) {
        Query query = getManager().createNamedQuery("User.findUserFullById");
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }

    @Override
    public User findUserByEmail(String email) {

        Query query = getManager().createNamedQuery("User.findUserFullById");
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }

}
