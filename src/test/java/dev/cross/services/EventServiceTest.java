package dev.cross.services;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.*;

import dev.cross.repositories.EventDAO;
import dev.cross.types.Event_Type;
import dev.cross.types.Grade_Type;

import org.mockito.InjectMocks;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {
	
	private static EventService eventService;
	
	private static EventDAO mockEventDao;
	
	@BeforeAll
	public static void setUp() {
		mockEventDao = mock(EventDAO.class);
		eventService = new EventService(mockEventDao);
	}
	
	@Test
	public void sanityTest() {
		
	}
	
	@Test
	public void getEventTest() {
		Event_Type e = Event_Type.University_Course;
		when(mockEventDao.getGradeType(e)).thenReturn(Grade_Type.Grade);
		when(mockEventDao.getPct(e)).thenReturn(70.0);
		assertEquals(eventService.getEvent(e), "{\"grade_t\":\"" + "Grade" + "\", \"pct\":\"" + "70.0" + "\"}");
	}
	
	
}