package com.vote.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String password;

    private Integer phone;

    private Integer admin;

    private Integer enable;

    private Date modifytime;

    private Date createtime;

    public User(Integer id, String username, String password, Integer phone, Integer admin, Integer enable, Date modifytime, Date createtime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.admin = admin;
        this.enable = enable;
        this.modifytime = modifytime;
        this.createtime = createtime;
    }
    public User() {
        super();
    }
    public User(Object user) {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}