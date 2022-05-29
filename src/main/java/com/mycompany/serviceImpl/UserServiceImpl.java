package com.mycompany.serviceImpl;

import com.mycompany.daoImpl.UserDaoImpl;
import com.mycompany.daoInter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoInter udi = new UserDaoImpl();

    @Override
    public List<User> getAllUser() {
        return udi.getAllUser();
    }

    @Override
    public User addUser(User user) {
        return udi.addUser(user);
    }

    @Override
    public User findUser(Integer id) {
        return udi.findUser(id);
    }

    @Override
    public User updateUser(User user) {
        return udi.updateUser(user);
    }

    @Override
    public User removeUser(User user) {
        return udi.removeUser(user);
    }

    @Override
    public User findUserFullById(Integer id) {
        return udi.findUserFullById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return udi.findUserByEmail(email);
    }

}
