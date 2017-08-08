package com.chernuw.service.interfaces;

import com.chernuw.model.User;

public interface UserService {

    User findById(int id);

    User findByUsername(String username);

    int saveUser(User user);

    void updateUser(User user);

}
