package dev.cross.models;

import dev.cross.types.Approve_Type;
import dev.cross.types.Event_Type;

public class Request {
	
	private int id;
	private int employee_id;
	private Event_Type event_t;
	private String description;
	private int money;
	private String grade;
	private Approve_Type approval;
	
	public Request() {
		super();
	}
	
	public Request(int id, int employee_id, Event_Type event_t, String description, int money, String grade) {
		this.id = id;
		this.employee_id = employee_id;
		this.event_t = event_t;
		this.description = description;
		this.money = money;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public Event_Type getEvent_t() {
		return event_t;
	}

	public void setEvent_t(Event_Type event_t) {
		this.event_t = event_t;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Approve_Type getApproval() {
		return approval;
	}

	public void setApproval(Approve_Type approval) {
		this.approval = approval;
	}
	
	
}
