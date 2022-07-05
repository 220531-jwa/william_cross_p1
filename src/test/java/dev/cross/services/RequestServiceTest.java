package dev.cross.services;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.*;

import dev.cross.models.Request;
import dev.cross.models.User;
import dev.cross.repositories.EventDAO;
import dev.cross.repositories.RequestDAO;
import dev.cross.repositories.UserDAO;
import dev.cross.types.Approve_Type;
import dev.cross.types.Event_Type;
import dev.cross.types.Grade_Type;

import org.mockito.InjectMocks;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class RequestServiceTest {
	
	private static RequestService requestService;
	
	private static EventDAO mockEventDao;
	private static RequestDAO mockRequestDao;
	private static UserDAO mockUserDao;
	
	@BeforeAll
	public static void setUp() {
		mockEventDao = mock(EventDAO.class);
		mockRequestDao = mock(RequestDAO.class);
		mockUserDao = mock(UserDAO.class);
		requestService = new RequestService(mockRequestDao, mockEventDao, mockUserDao);
	}
	
	@Test
	public void sanityTest() {
		
	}
	
	
	@Test
	public void createRequestTest() {
		Event_Type e = Event_Type.University_Course;
		
		Request newRequest = new Request(0, 8, e, "Test", "Unknown", Approve_Type.Pending, new Date(0), new Date(0), 500.0, 0, 500.0, false, false, false);
		User newUser = new User(8, "Test", "McTest", "Test", "Testing123", false, (float)500.0, 0);
		
		when(mockEventDao.getPct(e)).thenReturn(100.0);
		when(mockUserDao.getUserById(8)).thenReturn(newUser);
		when(mockRequestDao.createRequest(newRequest)).thenReturn(newRequest);
	
		
		assertEquals(requestService.createRequest(newRequest), newRequest);
	}
	
	@Test
	public void createRequestMoneyTest() {
		Event_Type e = Event_Type.University_Course;
		
		Request newRequest = new Request(0, 8, e, "Test", "Unknown", Approve_Type.Pending, new Date(0), new Date(0), 500.0, 0, 500.0, false, false, false);
		User newUser = new User(8, "Test", "McTest", "Test", "Testing123", false, (float)500.0, 0);
		
		when(mockEventDao.getPct(e)).thenReturn(100.0);
		when(mockUserDao.getUserById(8)).thenReturn(newUser);
		when(mockRequestDao.createRequest(newRequest)).thenReturn(newRequest);
	
		
		assertEquals(requestService.createRequest(newRequest).getMoney(), 500.00);
	}
	
	@Test
	public void createRequestExceedsFundsTest() {
		Event_Type e = Event_Type.University_Course;
		
		Request newRequest = new Request(0, 8, e, "Test", "Unknown", Approve_Type.Pending, new Date(0), new Date(0), 700.0, 0, 700.0, false, false, false);
		User newUser = new User(8, "Test", "McTest", "Test", "Testing123", false, (float)500.0, 0);
		
		when(mockEventDao.getPct(e)).thenReturn(100.0);
		when(mockUserDao.getUserById(8)).thenReturn(newUser);
		when(mockRequestDao.createRequest(newRequest)).thenReturn(newRequest);
	
		
		assertEquals(requestService.createRequest(newRequest).getMoney(), 500.00);
	}
	
	@Test
	public void getRequestTest() {
		Request newRequest = new Request(44, 8, Event_Type.University_Course, "Test", "Unknown", Approve_Type.Pending, new Date(0), new Date(0), 500.0, 0, 500.0, false, false, false);
		when(mockRequestDao.getRequest(44)).thenReturn(newRequest);
		assertEquals(requestService.getRequest(44), newRequest);
		
	}
	
	@Test
	public void modifyRequestTest() {
		Request newRequest = new Request(44, 8, Event_Type.University_Course, "Test", "Unknown", Approve_Type.Pending, new Date(0), new Date(0), 500.0, 0, 500.0, false, false, false);
		when(mockRequestDao.modifyRequest(newRequest)).thenReturn(true);
		assertEquals(requestService.modifyRequest(newRequest), true);
	}
}