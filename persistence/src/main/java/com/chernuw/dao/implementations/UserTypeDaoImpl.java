package com.chernuw.dao.implementations;

import com.chernuw.dao.AbstractDao;
import com.chernuw.dao.interfaces.UserTypeDao;
import com.chernuw.model.UserType;
import org.springframework.stereotype.Repository;

@Repository("userTypeDao")
public class UserTypeDaoImpl extends AbstractDao<Integer, UserType> implements UserTypeDao {


    public void saveUserType(UserType userType) {
        save(userType);
    }
}
