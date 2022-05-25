/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.daoInter;

import com.mycompany.entity.Skill;
import java.util.List;

/**
 *
 * @author user
 */
public interface SkillDaoInter {

    public void addSkills(Skill skill);

    public void addSkillsBatch(List<Skill> skill);

    public void updateSkills(Skill skill);

    public Skill getSkillByName(String name);

    public Skill getSkillById(int id);

    public List<String> getAllSkills();

    public boolean deleteSkillsByName(String name);

    List<Skill> getSkillsByUserId(int id);

}
