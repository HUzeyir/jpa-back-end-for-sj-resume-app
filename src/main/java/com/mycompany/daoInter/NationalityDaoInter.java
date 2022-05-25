/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.daoInter;

import com.mycompany.entity.Nationality;
import java.util.List;

/**
 *
 * @author user
 */
public interface NationalityDaoInter {

    public List<Nationality> getAllNationality();
    
    public boolean addNationality(Nationality n);
    
    public boolean deleteNationality(String NatName);
    
    public boolean updateNationality(Nationality n);
    
    public Nationality getNationalityById(int id);

}
