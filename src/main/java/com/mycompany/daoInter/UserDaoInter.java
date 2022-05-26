/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.daoInter;

import com.mycompany.entity.UserDetail;
import java.util.List;

/**
 *
 * @author admin
 */
public interface UserDaoInter {

    void addUser(UserDetail u);

    void addBatchUser(List<UserDetail> users);

    boolean updateUser(UserDetail u);

    boolean deleteUser(int id);
    
     public UserDetail serchUserByEmailAndPassword(String email, String password);

    UserDetail getUserbyId(int id);

    UserDetail serchUserByEmail(String email);

    List<UserDetail> serchUsersByName(String name);

    List<UserDetail> serchUsersByNameAndSurname(String name, String surName);

    List<UserDetail> getAllUsers();

}
