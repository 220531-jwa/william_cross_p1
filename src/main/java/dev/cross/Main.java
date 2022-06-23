
package dev.cross;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {

	public static void main(String[] args) {
		
		Javalin app = Javalin.create();
		
		app.start(8080);
		
		
		
		app.exception(Exception.class, (e, ctx) -> {
			ctx.status(404);
			System.out.println(e);
			ctx.result("Exception: Not found");
		});
		
	}

}