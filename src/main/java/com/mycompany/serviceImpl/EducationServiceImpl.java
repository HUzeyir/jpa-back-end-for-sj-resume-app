package com.mycompany.serviceImpl;

import com.mycompany.daoImpl.EducationDaoImple;
import com.mycompany.daoInter.EducationDaoInter;
import com.mycompany.entity.Education;
import com.mycompany.service.EducationService;
import java.util.List;

public class EducationServiceImpl implements EducationService {

    private EducationDaoInter edi = new EducationDaoImple();

    @Override
    public List<Education> getAllEducation() {
        return edi.getAllEducation();
    }

    @Override
    public Education addEducation(Education education) {
        return edi.addEducation(education);
    }

    @Override
    public Education findEducationById(Integer id) {
        return edi.findEducationById(id);
    }

    @Override
    public Education removeEducatin(Education education) {
        return edi.removeEducatin(education);
    }

    @Override
    public Education updateEducation(Education education) {
        return edi.updateEducation(education);
    }

}
