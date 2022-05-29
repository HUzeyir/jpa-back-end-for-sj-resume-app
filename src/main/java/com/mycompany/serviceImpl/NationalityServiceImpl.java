package com.mycompany.serviceImpl;

import com.mycompany.daoImpl.NationalityDaoImpl;
import com.mycompany.daoInter.NationalityDaoInter;
import com.mycompany.entity.Nationality;
import com.mycompany.service.NationalityService;
import java.util.List;

public class NationalityServiceImpl implements NationalityService {

    private NationalityDaoInter ndi = new NationalityDaoImpl();

    @Override
    public List<Nationality> getAllNationality() {
        return ndi.getAllNationality();
    }

    @Override
    public Nationality addNationality(Nationality n) {
        return ndi.addNationality(n);
    }

    @Override
    public Nationality removeNationality(Nationality NatName) {
        return ndi.removeNationality(NatName);
    }

    @Override
    public Nationality updateNationality(Nationality n) {

        return ndi.updateNationality(n);
    }

    @Override
    public Nationality getNationalityById(int id) {
        return ndi.getNationalityById(id);
    }

}
