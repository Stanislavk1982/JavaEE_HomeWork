package com.service;

import com.model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    List<User> addUser(User newUser);

    public String accesOKOrDenied(String username, String password) throws IOException;

}
