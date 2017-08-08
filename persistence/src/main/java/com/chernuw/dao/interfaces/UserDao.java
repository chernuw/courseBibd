package com.chernuw.dao.interfaces;


import com.chernuw.model.User;

public interface UserDao {

    User findById(int id);
    User findByUsername(String username);
    int saveUser(User user);
    void updateUser(User user);
}
