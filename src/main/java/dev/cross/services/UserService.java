package dev.cross.services;

import dev.cross.models.User;
import dev.cross.repositories.UserDAO;

public class UserService {

	private static UserDAO userDao;
	
	public UserService(UserDAO u) {
		userDao = u;
	}
	
	public User getUser(String username) {
		return userDao.getUserByUsername(username);
	}
	
	public User createUser(User u) {
		return userDao.createUser(u);
	}
}
