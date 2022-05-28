
package com.mycompany.daoInter;

import com.mycompany.entity.Phone;
import java.util.List;


public interface PhoneDaoInter {

    List<Phone> getAllPhone();

    Phone addPhone(Phone phone);

    Phone findPhone(Integer id);

    Phone updatePhone(Phone phone);

    Phone removePhone(Phone phone);

}
