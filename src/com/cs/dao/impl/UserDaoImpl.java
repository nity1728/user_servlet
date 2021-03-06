package com.cs.dao.impl;

import com.cs.basedao.BaseDao;
import com.cs.dao.UserDao;
import com.cs.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int findByCountUser() throws Exception {
        int index=0;
        String sql="select Count(*) from user";
        ResultSet rs=exeuQuery(sql,null);
        while(rs.next()){
            index=rs.getInt(1);
        }
        getClose();
        return index;
    }

    @Override
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception {
        List<User> list=new ArrayList<User>();
        String sql="select * from user limit ?,?";
        Object obj[]={(pageNo-1)*pageSize,pageSize};
        ResultSet rs=exeuQuery(sql,obj);
        while(rs.next()){
            User us=new User();
            us.setId(rs.getInt(1));
            us.setUsername(rs.getString(2));
            us.setPassword(rs.getString(3));
            us.setSex(rs.getString(4));
            us.setBornDate(rs.getTimestamp(5));
            us.setUserpic(rs.getString(6));
            list.add(us);
        }
        getClose();
        return list;
    }

    @Override
    public boolean addUser(User user) throws Exception {
        int index=-1;
        String sql="insert into user(username,password,sex,bornDate,userpic)" +
                "values(?,?,?,?,?)";
        Object [] objects={user.getUsername(),user.getPassword(),user.getSex()
        ,user.getBornDate(),user.getUserpic()};
        index=exeuUpdate(sql,objects);
        getClose();
        if(index>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public User findUserById(int id) throws Exception {
        String sql="select * from user where id=?";
        Object [] objects={id};
        ResultSet rs=exeuQuery(sql,id);
        User user=new User();
        while (rs.next()){
            user.setId(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setSex(rs.getString(4));
            user.setBornDate(rs.getDate(5));
            user.setUserpic(rs.getString(6));
        }
        getClose();
        return user;
    }

    @Override
    public boolean delUserById(int id) throws Exception {
        String sql="delete from user where id=?";
        Object [] objects={id};
        int index=exeuUpdate(sql,objects);
        getClose();
        if(index>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateUserById(User user) throws Exception {
        String sql="update user set username=?,password=?,sex=?," +
                "bornDate=?,userpic=? where id=?";
        Object [] objects={user.getUsername(),user.getPassword(),
        user.getSex(),user.getBornDate(),user.getUserpic(),user.getId()};
        int index=exeuUpdate(sql,objects);
        getClose();
        if(index>0){
            return true;
        }else {
            return false;
        }
    }
}
