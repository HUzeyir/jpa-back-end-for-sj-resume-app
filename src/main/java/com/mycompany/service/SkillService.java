
package com.mycompany.service;

import com.mycompany.entity.Skill;
import java.util.List;


public interface SkillService {

    public Skill addSkills(Skill skill);

    public List<Skill> addSkillsBatch(List<Skill> skill);

    public Skill updateSkills(Skill skill);

    public Skill getSkillByName(String name);

    public Skill getSkillById(int id);

    public List<Skill> getAllSkills();

    public Skill removeSkillsByName(Skill skill);

    List<Skill> getSkillsByUserId(int id);
    
    Skill removeSkillById(Skill skill);

}
