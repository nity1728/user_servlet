package com.cs.service;

import com.cs.entity.User;

import java.util.List;

public interface UserService {

    //查询数据的总记录数
    public int findByCountUser()throws Exception;

    //分页方法
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception;

    //添加用户
    public boolean addUser(User user) throws Exception;

    //通过id查询用户
    public User findUserById(int id) throws Exception;

    //通过id删除用户
    public boolean delUserById(int id) throws Exception;

    //通过id修改用户
    public boolean updateUserById(User user) throws Exception;
}
