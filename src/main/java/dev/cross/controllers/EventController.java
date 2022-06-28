package dev.cross.controllers;

import dev.cross.repositories.EventDAO;
import dev.cross.services.EventService;
import dev.cross.types.Event_Type;
import io.javalin.http.Context;

public class EventController {

private static EventService eventService = new EventService(new EventDAO());
	
	public static void getEvent(Context ctx) {
		String event = ctx.pathParam("eventId");
		
		Event_Type e = Event_Type.Other;
		System.out.println(e);
		
		switch(event) {
		case "University_Course": 
			e = Event_Type.University_Course;
			break;
		case "Seminar": 
			e = Event_Type.Seminar;
			break;
		case "Certification": 
			e = Event_Type.Certification;
			break;
		case "Certification_Preparation_Class": 
			e = Event_Type.Certification_Preparation_Class;
			break;
		case "Tehnical_Training": 
			e = Event_Type.Tehnical_Training;
			break;
		default: 
			break;
		}
		
		String s = eventService.getEvent(e);
		
		System.out.println(e);
		
		if (s != null) {
			ctx.status(200);
			ctx.json(s);
		} else {
			ctx.status(404);
		}
	}
	
}
