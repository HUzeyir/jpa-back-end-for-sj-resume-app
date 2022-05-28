/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoInter;

import com.mycompany.entity.Experience;
import java.util.List;

/**
 *
 * @author user
 */
public interface ExperienceDaoInter {

    List<Experience> getAllEcperience();

    List<Experience> getExperienceByUserId(final Integer id);

    Experience addExperience(final Experience experience);

    Experience findExperienceById(final Integer id);

    Experience updateExperience(final Experience experience);

    Experience removeExperience(final Experience experience);

    boolean removeExperienceById(final Integer id);

}
