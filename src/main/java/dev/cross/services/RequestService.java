package dev.cross.services;

import java.util.List;

import dev.cross.models.Request;
import dev.cross.repositories.EventDAO;
import dev.cross.repositories.RequestDAO;

public class RequestService {

	private static RequestDAO requestDao;
	private static EventDAO eventDao;
	
	public RequestService(RequestDAO u, EventDAO e) {
		requestDao = u;
		eventDao = e;
	}
	
	public Request getRequest(int id) {
		return requestDao.getRequest(id);
	}
	
	public List<Request> getAllRequests() {
		return requestDao.getRequestList();
	}
	
	public List<Request> getUserRequests(int employee) {
		return requestDao.getRequestListByEmployee(employee);
	}
	
	public Request createRequest(Request newRequest) {
		return requestDao.createRequest(newRequest);
	}
	
	public boolean modifyRequest(Request newRequest) {
		return requestDao.modifyRequest(newRequest);
	}
	
}
