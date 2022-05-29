package com.mycompany.serviceImpl;

import com.mycompany.daoImpl.ExperienceDaoImple;
import com.mycompany.daoInter.ExperienceDaoInter;
import com.mycompany.entity.Experience;
import com.mycompany.service.ExperienceService;
import java.util.List;

public class ExperienceServiceImpl implements ExperienceService {

    private ExperienceDaoInter edi = new ExperienceDaoImple();

    @Override
    public List<Experience> getAllEcperience() {
        return edi.getAllEcperience();
    }

    @Override
    public List<Experience> getExperienceByUserId(Integer id) {
        return edi.getExperienceByUserId(id);
    }

    @Override
    public Experience addExperience(Experience experience) {
        return edi.addExperience(experience);
    }

    @Override
    public Experience findExperienceById(Integer id) {
        return edi.findExperienceById(id);
    }

    @Override
    public Experience updateExperience(Experience experience) {
        return edi.updateExperience(experience);
    }

    @Override
    public Experience removeExperience(Experience experience) {
        return edi.removeExperience(experience);
    }

    @Override
    public boolean removeExperienceById(Integer id) {
        return edi.removeExperienceById(id);
    }

}
