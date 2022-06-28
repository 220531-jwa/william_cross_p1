package dev.cross.services;

import dev.cross.repositories.EventDAO;
import dev.cross.types.Event_Type;

public class EventService {
	
private static EventDAO eventDao;
	
	public EventService(EventDAO e) {
		eventDao = e;
	}

	public String getEvent(Event_Type e) {
		String gradeType = eventDao.getGradeType(e).toString();
		String gradePct = eventDao.getPct(e) + "";
		return ("{\"grade_t\":\"" + gradeType + "\", \"pct\":\"" + gradePct + "\"}");
	}
	
}
