/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.context;

import com.mycompany.entity.User;
import com.mycompany.daoImpl.AddressDaoIml;
import com.mycompany.daoImpl.SkillDaoImpl;
import com.mycompany.daoImpl.UserDaoImpl;
import com.mycompany.daoInter.AddressDaoInter;
import com.mycompany.daoInter.SkillDaoInter;
import com.mycompany.daoInter.UserDaoInter;

/**
 *
 * @author HuzeyirPc
 */
public class Context {

    public static UserDaoInter instanceUserDao() {

        return new UserDaoImpl();

    }

    public static SkillDaoInter instanceSkillDao() {

        return new SkillDaoImpl();

    }
    
       public static AddressDaoInter instanceAddressDao() {

        return new AddressDaoIml();

    }
       
          public static SkillDaoInter instanceSkillDao2() {

        return new SkillDaoImpl();

    }
          
          
             public static SkillDaoInter instanceSkillDao3() {

        return new SkillDaoImpl();

    }
             
                public static SkillDaoInter instanceSkillDao4() {

        return new SkillDaoImpl();

    }
}
