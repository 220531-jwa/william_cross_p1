package dev.cross.controllers;

import dev.cross.models.User;
import dev.cross.repositories.UserDAO;
import dev.cross.services.UserService;
import io.javalin.http.Context;

public class UserController {

	private static UserService userService = new UserService(new UserDAO());
	
	public static void createUser(Context ctx) {
		User newUser = ctx.bodyAsClass(User.class);
		User u = userService.createUser(newUser);
		if (u != null) {
			ctx.status(200);
			ctx.json(u);
		} else {
			ctx.status(404);
		}
	}
	
	public static void getUser(Context ctx) {
		String username = ctx.pathParam("username");
		User u = userService.getUser(username);
		if (u != null) {
			ctx.status(200);
			ctx.json(u);
		} else {
			ctx.status(404);
		}
	}
	
}
