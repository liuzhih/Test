package com.hand.liu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.liu.dao.UserDao;
import com.hand.liu.model.User;
import com.hand.liu.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> select() {
		// TODO Auto-generated method stub
		return userDao.select();
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	public void add(User user) {
		// TODO Auto-generated method stub
		userDao.add(user);
	}

	public User searchByid(int id) {
		// TODO Auto-generated method stub
		return userDao.searchByid(id);
	}

}
