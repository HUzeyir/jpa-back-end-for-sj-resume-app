/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoInter;

import com.mycompany.entity.UserSkill;
import java.util.List;

/**
 *
 * @author user
 */
public interface UserSkillDaoInter {
    
     List<UserSkill> getAllUserSkill();

    UserSkill addUserSkill(UserSkill uskill);

    UserSkill findUserSkill(Integer id);

    UserSkill updateUserSkill(UserSkill uskill);

    UserSkill removeUserSkill(UserSkill uskill);
    
}
