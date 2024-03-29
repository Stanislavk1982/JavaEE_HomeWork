package com.service;


import com.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("userService::: constructor");
    }

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public List<User> addUser(User newUser) {
        return userDao.addUser(newUser);
    }


    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String accesOKOrDenied(String username, String password ) throws IOException {
        String [] fromDB = userDao.getLoginAndPassword();
        if ((fromDB[0].equals(username) && (fromDB[1].equals(password)))) {
            return "OK";
        }
        return "Access denied";
    }
}