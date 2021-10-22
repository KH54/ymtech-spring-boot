package com.example.demo.test.dao.user.impl;

import java.util.List;

import com.example.demo.test.model.User;


public interface IUserDao{
    public List<User> getUsers(String name, String gender, int age);
    
    public User getUser(String id);
    
    public int createUser(User user);
    
    public int deleteUser(String id);
    
    public int updateUser(User user);
}