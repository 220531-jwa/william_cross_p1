
package dev.cross;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import static io.javalin.apibuilder.ApiBuilder.*;

import dev.cross.controllers.RequestController;
import dev.cross.controllers.UserController;


public class ERSRunner {

	public static void main(String[] args) {
		
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
//			config.enableCorsForOrigin("http://localhost:8080");
			config.addStaticFiles("/", Location.CLASSPATH);
		});
		
		app.start(8080);

		app.routes(() -> {
			path("/users", () ->{
				post(UserController::createUser);
				path("/{username}", () ->{
					get(UserController::getUser);
				});
			});
			
			path("/requests", () ->{
				get(RequestController::getRequestList);
				post(RequestController::createRequest);
				path("/{userId}", () ->{
					get(RequestController::getUserRequestList);
				});
				path("/{requestId}", () ->{
					get(RequestController::getRequest);
					put(RequestController::modifyRequest);
				});
			});
		});
		
		app.exception(Exception.class, (e, ctx) -> {
			ctx.status(404);
			System.out.println(e);
			ctx.result("Exception: Not found");
		});
		
	}

}