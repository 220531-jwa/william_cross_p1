package dev.cross.models;

import dev.cross.types.Approve_Type;
import dev.cross.types.Event_Type;
import java.sql.Date;

public class RequestManagerView {
	
	private int id;
	private int employee_id;
	private Event_Type event_t;
	private String description;
	private String grade;
	private Approve_Type approval;
	private Date startDate;
	private Date endDate;
	private double totalValue;
	private double money;
	private String firstName;
	private String lastName;

	
	public RequestManagerView() {
		super();
	}
	
	public RequestManagerView(int id, int employee_id, Event_Type event_t, String description, String grade, Approve_Type approval, Date startDate, Date endDate, int totalValue, int money, String fName, String lName) {
		this.id = id;
		this.employee_id = employee_id;
		this.event_t = event_t;
		this.description = description;
		this.money = money;
		this.grade = grade;
		this.approval = approval;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalValue = totalValue;
		this.firstName = fName;
		this.lastName = lName;
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

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "RequestManagerView [id=" + id + ", employee_id=" + employee_id + ", event_t=" + event_t
				+ ", description=" + description + ", grade=" + grade + ", approval=" + approval + ", startDate="
				+ startDate + ", endDate=" + endDate + ", totalValue=" + totalValue + ", money=" + money
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
	
}