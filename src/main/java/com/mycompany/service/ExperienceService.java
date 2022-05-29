
package com.mycompany.service;

import com.mycompany.entity.Experience;
import java.util.List;


public interface ExperienceService {

    List<Experience> getAllEcperience();

    List<Experience> getExperienceByUserId(final Integer id);

    Experience addExperience(final Experience experience);

    Experience findExperienceById(final Integer id);

    Experience updateExperience(final Experience experience);

    Experience removeExperience(final Experience experience);

    boolean removeExperienceById(final Integer id);

}
