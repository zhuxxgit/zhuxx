package com.zhuxx.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//加上Data注解后不再需要写getter和setter方法
@Data
@Table(name = "user")
public class User {

    //这是自增主键
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private  String username;

    @Column(name = "password")
    private  String password;

    @Column(name = "gender")
    private  String gender;

    @Column(name = "email")
    private  String email;

    @Column(name = "province")
    private  String province;

    @Column(name = "city")
    private  String city;

    @Column(name = "birthday")
    private Date birthday;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
