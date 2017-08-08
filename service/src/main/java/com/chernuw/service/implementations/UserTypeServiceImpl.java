package com.chernuw.service.implementations;

import com.chernuw.dao.interfaces.UserTypeDao;
import com.chernuw.model.UserType;
import com.chernuw.service.interfaces.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userTypeService")
@Transactional
public class UserTypeServiceImpl implements UserTypeService {

    @Autowired
    private UserTypeDao userTypeDao;

    public void save(UserType userType) {
        userTypeDao.saveUserType(userType);
    }
}
