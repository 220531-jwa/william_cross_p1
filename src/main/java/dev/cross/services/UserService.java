package dev.cross.services;

import dev.cross.models.Creds;
import dev.cross.models.User;
import dev.cross.repositories.UserDAO;

public class UserService {

	private static UserDAO userDao;
	
	public UserService(UserDAO u) {
		userDao = u;
	}
	
	public User getUser(Creds credentials) {
		User newUser = userDao.getUserByUsername(credentials.getUser());
		if (newUser == null) return null;
		if (credentials.checkPass(newUser.getPass())) return newUser;
		return null;
	}
	
	public User createUser(User u) {
		return userDao.createUser(u);
	}
	
	public User getUserId(int id) {
		return userDao.getUserById(id);
	}
}
