package com.chernuw.service.implementations;

import com.chernuw.dao.interfaces.UserDao;
import com.chernuw.model.User;
import com.chernuw.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    public User findById(int id) {
        return dao.findById(id);
    }

    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public int saveUser(User user) {
        return dao.saveUser(user);
    }

    @Override
    public void updateUser(User user){
        dao.updateUser(user);
    }
}
