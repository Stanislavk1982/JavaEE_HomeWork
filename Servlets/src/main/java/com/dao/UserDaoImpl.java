package com.dao;

import com.model.User;
import org.springframework.stereotype.Repository;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("userDao:: constructor");
    }

    private List<User> users = new ArrayList<User>(
            Arrays.asList(
                    new User("name1", 20),
                    new User("name2", 30),
                    new User("name3", 40))
    );

    public List<User> getAllUsers() {
        return users;
    }

    public List<User> addUser(User newUser) {
        users.add(newUser);
        return users;
    }

    public String[] getLoginAndPassword() throws IOException {
        Properties properties = new Properties();
        InputStream stream = new BufferedInputStream(this.getClass().getClassLoader().getResourceAsStream("resource.txt"));
        properties.load(stream);
        String[] db = new String[2];
        db[0] = properties.getProperty("username");
        db[1] = properties.getProperty("password");
        return db;
    }


}

