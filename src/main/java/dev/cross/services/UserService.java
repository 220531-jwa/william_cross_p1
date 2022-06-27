package dev.cross.services;

import dev.cross.repositories.UserDAO;

public class UserService {

	private static UserDAO userDao;
	
	public UserService(UserDAO u) {
		userDao = u;
	}
}
