package com.hand.liu.service;

import java.util.List;

import com.hand.liu.model.User;


public interface UserService {
	List<User> select();

    void update(User user);
    
    void delete(int id);
    
    void add(User user);
    
    User searchByid(int id);
}
