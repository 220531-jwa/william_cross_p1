package dev.cross.controllers;

import java.util.List;

import dev.cross.models.Request;
import dev.cross.models.RequestManagerView;
import dev.cross.repositories.EventDAO;
import dev.cross.repositories.RequestDAO;
import dev.cross.services.RequestService;
import io.javalin.http.Context;

public class RequestController {

	private static RequestService requestService = new RequestService( new RequestDAO(), new EventDAO() );
	
	public static void getRequestList(Context ctx) {
		List<RequestManagerView> requests = requestService.getAllRequests();
		if (requests.isEmpty()) {
			ctx.status(404);
		} else {
			ctx.status(200);
			ctx.json(requests);
		}
		
	}
	
	public static void createRequest(Context ctx) {
		Request request = ctx.bodyAsClass(Request.class);
		Request r = requestService.createRequest(request);
		if (r != null) {
			ctx.status(200);
			ctx.json(r);
		} else {
			ctx.status(404);
		}
	}
	
	public static void getUserRequestList(Context ctx) {
		int userId = Integer.parseInt(ctx.pathParam("userId"));
		List<Request> requests = requestService.getUserRequests(userId);
		if (requests.isEmpty()) {
			ctx.status(404);
		} else {
			ctx.status(200);
			ctx.json(requests);
		}
	}
	
	public static void getRequest(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("requestId"));
		Request r = requestService.getRequest(id);
		if (r != null) {
			ctx.status(200);
			ctx.json(r);
		} else {
			ctx.status(404);
		}
	}
	
	public static void getRequestManager(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("requestId"));
		RequestManagerView r = requestService.getRequestManager(id);
		if (r != null) {
			ctx.status(200);
			ctx.json(r);
		} else {
			ctx.status(404);
		}
	}
	
	
	public static void modifyRequest(Context ctx) {
		Request request = ctx.bodyAsClass(Request.class);
		request.setId(Integer.parseInt(ctx.pathParam("requestId")));
		if (requestService.modifyRequest(request)) {
			ctx.status(200);
		} else {
			ctx.status(404);
		}
	}
	
	public static void approveRequest(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("requestId"));
		if (requestService.approveRequest(id)) {
			ctx.status(200);
		} else {
			ctx.status(400);
		}
	}
	
	public static void rejectRequest(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("requestId"));
		if (requestService.rejectRequest(id)) {
			ctx.status(200);
		} else {
			ctx.status(400);
		}
	}
}
