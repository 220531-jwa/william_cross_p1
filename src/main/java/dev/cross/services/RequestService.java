package dev.cross.services;

import dev.cross.repositories.RequestDAO;

public class RequestService {

	private static RequestDAO requestDao;
	
	public RequestService(RequestDAO u) {
		requestDao = u;
	}
}
