package com.mycompany.service;

import com.mycompany.entity.User;
import java.util.List;

public interface UserService {

    List<User> getAllUser();

    User addUser(User user);

    User findUser(Integer id);

    User updateUser(User user);

    User removeUser(User user);

    User findUserFullById(Integer id);

    User findUserByEmail(String email);

}
