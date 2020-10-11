package com.cs.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private int id;
    private String username;
    private String password;
    private String sex;
    private Date bornDate;
    private String userpic;

    public User() {

    }

    public User(String username, String password, String sex, Date bornDate, String userpic) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.bornDate = bornDate;
        this.userpic = userpic;
    }

    public User(int id, String username, String password, String sex, Date bornDate, String userpic) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.bornDate = bornDate;
        this.userpic = userpic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }
}
