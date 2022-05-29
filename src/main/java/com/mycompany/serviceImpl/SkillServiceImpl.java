package com.mycompany.serviceImpl;

import com.mycompany.daoImpl.SkillDaoImpl;
import com.mycompany.daoInter.SkillDaoInter;
import com.mycompany.entity.Skill;
import com.mycompany.service.SkillService;
import java.util.List;

public class SkillServiceImpl implements SkillService {

    private SkillDaoInter sdi = new SkillDaoImpl();

    @Override
    public Skill addSkills(Skill skill) {
        return sdi.addSkills(skill);
    }

    @Override
    public List<Skill> addSkillsBatch(List<Skill> skill) {
        return sdi.addSkillsBatch(skill);
    }

    @Override
    public Skill updateSkills(Skill skill) {
        return sdi.updateSkills(skill);
    }

    @Override
    public Skill getSkillByName(String name) {

        return sdi.getSkillByName(name);
    }

    @Override
    public Skill getSkillById(int id) {
        return sdi.getSkillById(id);
    }

    @Override
    public List<Skill> getAllSkills() {
        return sdi.getAllSkills();
    }

    @Override
    public Skill removeSkillsByName(Skill skill) {
        return sdi.removeSkillsByName(skill);
    }

    @Override
    public List<Skill> getSkillsByUserId(int id) {
        return sdi.getSkillsByUserId(id);
    }

    @Override
    public Skill removeSkillById(Skill skill) {
        return sdi.removeSkillById(skill);
    }

}
