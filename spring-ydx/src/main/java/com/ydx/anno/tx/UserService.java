package com.ydx.anno.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.UserDataHandler;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public int insert(){
		return userDao.insert();
	}
}
