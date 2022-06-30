package dev.cross.services;

import java.util.List;

import dev.cross.models.Request;
import dev.cross.models.RequestManagerView;
import dev.cross.models.User;
import dev.cross.repositories.EventDAO;
import dev.cross.repositories.RequestDAO;
import dev.cross.repositories.UserDAO;
import dev.cross.types.Approve_Type;

public class RequestService {

	private static RequestDAO requestDao;
	private static EventDAO eventDao;
	private static UserDAO userDao;
	
	public RequestService(RequestDAO r, EventDAO e, UserDAO u) {
		requestDao = r;
		eventDao = e;
		userDao = u;
	}
	
	public Request getRequest(int id) {
		return requestDao.getRequest(id);
	}
	
	public RequestManagerView getRequestManager(int id) {
		return requestDao.getRequestManager(id);
	}
	
	public List<RequestManagerView> getAllRequests() {
		return requestDao.getRequestList();
	}
	
	public List<Request> getUserRequests(int employee) {
		return requestDao.getRequestListByEmployee(employee);
	}
	
	public Request createRequest(Request newRequest) {
		double newMoney = newRequest.getTotalValue();
		
		double pct = eventDao.getPct(newRequest.getEvent_t());
		
		newMoney *= pct;
		newMoney = Math.floor(newMoney);
		newMoney /= 100;
		
		newRequest.setMoney(newMoney);
		
		return requestDao.createRequest(newRequest);
	}
	
	public boolean modifyRequest(Request newRequest) {
		return requestDao.modifyRequest(newRequest);
	}
	
	public boolean approveRequest(int id) {
		Request r = requestDao.getRequest(id);
		r.setApproval(Approve_Type.Approved);
		return requestDao.modifyRequest(r);
	}
	
	public boolean rejectRequest(int id) {
		Request r = requestDao.getRequest(id);
		r.setApproval(Approve_Type.Rejected);
		if (requestDao.modifyRequest(r)) {
			User u = userDao.getUserById(r.getEmployee_id());
			u.setReimburseUsed((float)(u.getReimburseUsed() + r.getMoney()));
			return userDao.modifyUserNotif(u);
		} else {
			return false;
		}
	}
	
}
