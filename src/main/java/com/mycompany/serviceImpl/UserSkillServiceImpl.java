package com.mycompany.serviceImpl;

import com.mycompany.daoImpl.UserSkillDaoImple;
import com.mycompany.daoInter.UserSkillDaoInter;
import com.mycompany.entity.UserSkill;
import com.mycompany.service.UserSkillService;
import java.util.List;

public class UserSkillServiceImpl implements UserSkillService {

    private UserSkillDaoInter usdi = new UserSkillDaoImple();

    @Override
    public List<UserSkill> getAllUserSkill() {

        return usdi.getAllUserSkill();
    }

    @Override
    public UserSkill addUserSkill(UserSkill uskill) {
        return usdi.addUserSkill(uskill);
    }

    @Override
    public UserSkill findUserSkill(Integer id) {
        return usdi.findUserSkill(id);
    }

    @Override
    public UserSkill updateUserSkill(UserSkill uskill) {

        return usdi.updateUserSkill(uskill);
    }

    @Override
    public UserSkill removeUserSkill(UserSkill uskill) {

        return usdi.removeUserSkill(uskill);
    }

}
