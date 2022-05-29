package com.mycompany.service;

import com.mycompany.entity.UserSkill;
import java.util.List;

public interface UserSkillService {
    
     List<UserSkill> getAllUserSkill();

    UserSkill addUserSkill(UserSkill uskill);

    UserSkill findUserSkill(Integer id);

    UserSkill updateUserSkill(UserSkill uskill);

    UserSkill removeUserSkill(UserSkill uskill);
    
}
