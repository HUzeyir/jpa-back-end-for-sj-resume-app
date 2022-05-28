package com.mycompany.daoImpl;

import com.mycompany.entity.Skill;
import com.mycompany.daoInter.SkillDaoInter;
import com.mycompany.jpaFactory.JpaFactory;
import java.util.List;
import javax.persistence.RollbackException;

public class SkillDaoImpl extends JpaFactory implements SkillDaoInter {

    @Override
    public Skill addSkills(final Skill skill) {
        try {
            if (skill != null) {
                getManager().getTransaction().begin();
                getManager().persist(skill);
                getManager().getTransaction().commit();
                return skill;
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
    public List<Skill> addSkillsBatch(final List<Skill> skill) {
        System.err.println("not writed inside this method, you can use logger instide it");
        return null;
    }

    @Override
    public Skill updateSkills(final Skill skill) {
        try {
            if (skill != null) {
                getManager().getTransaction().begin();
                getManager().merge(skill);
                getManager().getTransaction().commit();
                return skill;
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
    public Skill getSkillByName(final String name) {
        System.err.println("not writed inside this method, you can use logger instide it");
        return null;
    }

    @Override
    public Skill getSkillById(final int id) {
        try {
            Skill lang = getManager().find(Skill.class, id);
            return lang;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Skill> getAllSkills() {
        System.err.println("not writed inside this method, you can use logger instide it");
        return null;
    }

    @Override
    public Skill removeSkillsByName(final Skill skill) {
        System.err.println("not writed inside this method, you can use logger instide it");
        return null;
    }

    @Override
    public List<Skill> getSkillsByUserId(final int id) {
        System.err.println("not writed inside this method, you can use logger instide it");
        return null;
    }

    @Override
    public Skill removeSkillById(Skill skill) {
        try {
            if (skill != null) {
                getManager().getTransaction().begin();
                getManager().remove(skill);
                getManager().getTransaction().commit();
                return skill;
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
