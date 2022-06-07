package com.mycompany.daoImpl;

import com.mycompany.daoInter.UserDetailDaoInter;
import com.mycompany.entity.UserDetail;
import com.mycompany.jpaFactory.JpaFactory;
import java.util.List;
import javax.persistence.RollbackException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDetailDaoImple extends JpaFactory implements UserDetailDaoInter {

    private Logger log = LogManager.getLogger();

    @Override
    public List<UserDetail> getAllUserDetail() {
        log.warn("not writed inside this method!!!");
        return null;
    }

    @Override
    public UserDetail addUserDetail(UserDetail udetail) {

        try {
            if (udetail != null) {
                getManager().getTransaction().begin();
                getManager().persist(udetail);
                getManager().getTransaction().commit();
                getManager().close();
                return udetail;
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
    public UserDetail findUserDetail(Integer id) {
        try {
            UserDetail lang = getManager().find(UserDetail.class, id.longValue());
            log.info("user detail found with this id: " + id);
            getManager().close();
            return lang;
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public UserDetail updateUserDetail(UserDetail udetail) {
        try {
            if (udetail != null) {
                getManager().getTransaction().begin();
                getManager().merge(udetail);
                getManager().flush();
                getManager().getTransaction().commit();
                getManager().close();
                return udetail;
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
    public UserDetail removeUserDetail(UserDetail udetail) {
        try {
            if (udetail != null) {
                getManager().getTransaction().begin();
                getManager().remove(udetail);
                getManager().getTransaction().commit();
                getManager().close();
                return udetail;
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

}
