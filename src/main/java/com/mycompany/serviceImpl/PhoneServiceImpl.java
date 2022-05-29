package com.mycompany.serviceImpl;

import com.mycompany.daoImpl.PhoneDaoImple;
import com.mycompany.daoInter.PhoneDaoInter;
import com.mycompany.entity.Phone;
import com.mycompany.service.PhoneService;
import java.util.List;

public class PhoneServiceImpl implements PhoneService {

    private PhoneDaoInter pdi = new PhoneDaoImple();

    @Override
    public List<Phone> getAllPhone() {
        return pdi.getAllPhone();
    }

    @Override
    public Phone addPhone(Phone phone) {
        return pdi.addPhone(phone);
    }

    @Override
    public Phone findPhone(Integer id) {
        return pdi.findPhone(id);
    }

    @Override
    public Phone updatePhone(Phone phone) {
        return pdi.updatePhone(phone);
    }

    @Override
    public Phone removePhone(Phone phone) {
        return pdi.removePhone(phone);
    }

}
