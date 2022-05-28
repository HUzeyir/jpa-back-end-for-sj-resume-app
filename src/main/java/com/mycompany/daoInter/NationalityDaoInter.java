
package com.mycompany.daoInter;

import com.mycompany.entity.Nationality;
import java.util.List;


public interface NationalityDaoInter {

    public List<Nationality> getAllNationality();
    
    public Nationality addNationality(Nationality n);
    
    public Nationality removeNationality(Nationality NatName);
    
    public Nationality updateNationality(Nationality n);
    
    public Nationality getNationalityById(int id);

}
