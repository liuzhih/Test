package com.hand.liu.dao;

import java.util.List;

import com.hand.liu.model.User;

public interface UserDao {
	List<User> select();

    void update(User user);
    
    void delete(int id);
    
    void add(User user);
    
    User searchByid(int id);

}
