package dev.cross.controllers;

import dev.cross.repositories.UserDAO;
import dev.cross.services.UserService;

public class UserController {

	private static UserService userService = new UserService(new UserDAO());
	
	public static void createUser() {
		
	}
	
	public static void getUser() {
		
	}
	
}
