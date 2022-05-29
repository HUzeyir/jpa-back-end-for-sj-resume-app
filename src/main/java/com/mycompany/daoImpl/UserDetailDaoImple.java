package com.mycompany.daoImpl;

import com.mycompany.daoInter.UserDetailDaoInter;
import com.mycompany.entity.UserDetail;
import com.mycompany.jpaFactory.JpaFactory;
import java.util.List;
import javax.persistence.RollbackException;

public class UserDetailDaoImple extends JpaFactory implements UserDetailDaoInter {

    @Override
    public List<UserDetail> getAllUserDetail() {
        System.err.println("not writed inside this method, you can use logger instide it");
        return null;
    }

    @Override
    public UserDetail addUserDetail(UserDetail udetail) {

        try {
            if (udetail != null) {
                getManager().getTransaction().begin();
                getManager().persist(udetail);
                getManager().getTransaction().commit();
                return udetail;
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
    public UserDetail findUserDetail(Integer id) {
        try {
            UserDetail lang = getManager().find(UserDetail.class, id.longValue());
            return lang;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
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
                return udetail;
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
    public UserDetail removeUserDetail(UserDetail udetail) {
        try {
            if (udetail != null) {
                getManager().getTransaction().begin();
                getManager().remove(udetail);
                getManager().getTransaction().commit();
                return udetail;
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
