
package com.mycompany.service;

import com.mycompany.entity.Education;
import java.util.List;

public interface EducationService {

    List<Education>  getAllEducation();

    Education addEducation(final Education education);

    Education findEducationById(final Integer id);

    Education removeEducatin(final Education education);

    Education updateEducation(final Education education);

}
