package com.mycompany.daoImpl;

import com.mycompany.daoInter.UserSkillDaoInter;
import com.mycompany.entity.UserSkill;
import com.mycompany.jpaFactory.JpaFactory;
import java.util.List;
import javax.persistence.RollbackException;

public class UserSkillDaoImple extends JpaFactory implements UserSkillDaoInter {

    @Override
    public List<UserSkill> getAllUserSkill() {
        System.err.println("not writed inside this method, you can use logger instide it");
        return null;
    }

    @Override
    public UserSkill addUserSkill(UserSkill uskill) {
        try {
            if (uskill != null) {
                getManager().getTransaction().begin();
                getManager().persist(uskill);
                getManager().getTransaction().commit();
                return uskill;
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
    public UserSkill findUserSkill(Integer id) {
        try {
            UserSkill lang = getManager().find(UserSkill.class, id);
            return lang;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public UserSkill updateUserSkill(UserSkill uskill) {
        try {
            if (uskill != null) {
                getManager().getTransaction().begin();
                getManager().merge(uskill);
                getManager().getTransaction().commit();
                return uskill;
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
    public UserSkill removeUserSkill(UserSkill uskill) {
        try {
            if (uskill != null) {
                getManager().getTransaction().begin();
                getManager().remove(uskill);
                getManager().getTransaction().commit();
                return uskill;
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
