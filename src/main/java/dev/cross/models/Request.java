package dev.cross.models;

import dev.cross.types.approve_type;
import dev.cross.types.event_type;

public class Request {
	
	private int id;
	private int employee_id;
	private event_type event_t;
	private String description;
	private int money;
	private String grade;
	private approve_type approval;
	
	public Request() {
		super();
	}
	
	public Request(int id, int employee_id, event_type event_t, String description, int money, String grade) {
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

	public event_type getEvent_t() {
		return event_t;
	}

	public void setEvent_t(event_type event_t) {
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

	public approve_type getApproval() {
		return approval;
	}

	public void setApproval(approve_type approval) {
		this.approval = approval;
	}
	
	
}