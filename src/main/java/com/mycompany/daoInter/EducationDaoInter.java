/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoInter;

import com.mycompany.entity.Education;
import java.util.List;

/**
 *
 * @author user
 */
public interface EducationDaoInter {

    List<Education>  getAllEducation();

    Education addEducation(final Education education);

    Education findEducationById(final Integer id);

    Education removeEducatin(final Education education);

    Education updateEducation(final Education education);

}
