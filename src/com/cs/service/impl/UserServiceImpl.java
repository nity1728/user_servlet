package com.cs.service.impl;

import com.cs.dao.impl.UserDaoImpl;
import com.cs.entity.User;
import com.cs.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoImpl udi=new UserDaoImpl();
    @Override
    public int findByCountUser() throws Exception {
        return udi.findByCountUser();
    }

    @Override
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception {
        return udi.findByPageUserInfo(pageNo,pageSize);
    }

    @Override
    public boolean addUser(User user) throws Exception {
        return udi.addUser(user);
    }

    @Override
    public User findUserById(int id) throws Exception {
        return udi.findUserById(id);
    }

    @Override
    public boolean delUserById(int id) throws Exception {
        return udi.delUserById(id);
    }

    @Override
    public boolean updateUserById(User user) throws Exception {
        return udi.updateUserById(user);
    }
}
