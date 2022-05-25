/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.daoInter;

import com.mycompany.entity.User;
import java.util.List;

/**
 *
 * @author admin
 */
public interface UserDaoInter {

    void addUser(User u);

    void addBatchUser(List<User> users);

    boolean updateUser(User u);

    boolean deleteUser(int id);
    
     public User serchUserByEmailAndPassword(String email, String password);

    User getUserbyId(int id);

    User serchUserByEmail(String email);

    List<User> serchUsersByName(String name);

    List<User> serchUsersByNameAndSurname(String name, String surName);

    List<User> getAllUsers();

}
