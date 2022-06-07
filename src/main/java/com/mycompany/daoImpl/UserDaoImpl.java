package com.mycompany.daoImpl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.daoInter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.jpaFactory.JpaFactory;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDaoImpl extends JpaFactory implements UserDaoInter {

    private Logger log = LogManager.getLogger();
    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public List<User> getAllUser() {
        Query query = getManager().createNamedQuery("User.findAllUser");
        return query.getResultList();
    }

    @Override
    public User addUser(final User user) {

        crypt.hashToChar(4, user.getPassword().toCharArray());
        try {
            if (user != null) {
                getManager().getTransaction().begin();
                getManager().persist(user);
                getManager().getTransaction().commit();
                getManager().close();
                log.info("User added successfully");
                return user;
            }
        } catch (RuntimeException e) {
            log.error("error in the addUser: " + e.getMessage());
            try {
                getManager().getTransaction().rollback();
            } catch (RollbackException e2) {
               log.error(e2.getMessage());
            }
        }
        return null;
    }

    @Override
    public User findUser(Integer id) {
        try {
            User user = getManager().find(User.class, id.longValue());
            log.info("User finded successfully: id-" + id);
            getManager().close();
            return user;
        } catch (RuntimeException e) {
            log.error(e.getMessage());
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
                getManager().close();
                log.info("User updated successfully");
                return user;
            }
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            try {
                getManager().getTransaction().rollback();
            } catch (RollbackException e2) {
                log.error(e2.getMessage());
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
                getManager().close();
                log.info("User removed successfully");
                return user;
            }
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            try {
                getManager().getTransaction().rollback();
            } catch (RollbackException e2) {
                log.error(e2.getMessage());
            }
        }
        return null;
    }

    @Override
    public User findUserFullById(Integer id) {
        if (id != null) {
            Query query = getManager().createNamedQuery("User.findUserFullById");
            query.setParameter("id", id);
            getManager().close();
            log.info("User found by id successfully");
            return (User) query.getSingleResult();
        }
        log.error("User not found: with this id: " + id);
        return null;

    }

    @Override
    public User findUserByEmail(String email) {

        if (email != null) {
            Query query = getManager().createNamedQuery("User.findUserFullById");
            query.setParameter("email", email);
            getManager().close();
            log.info("User found by email successfully");
            return (User) query.getSingleResult();
        }
        log.error("User not found by this email: " + email);

        return null;

    }

}
