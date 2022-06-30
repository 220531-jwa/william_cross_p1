package dev.cross.models;

import dev.cross.types.Approve_Type;
import dev.cross.types.Event_Type;
import java.sql.Date;

public class Request {
	
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
	private double expected_funds;
	private boolean managerNotif;
	private boolean employeeNotif;
	private boolean exceedsFunds;

	
	public Request() {
		super();
	}
	
	

	public Request(int id, int employee_id, Event_Type event_t, String description, String grade, Approve_Type approval,
			Date startDate, Date endDate, double totalValue, double money, double expected_funds, boolean managerNotif,
			boolean employeeNotif, boolean exceedsFunds) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.event_t = event_t;
		this.description = description;
		this.grade = grade;
		this.approval = approval;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalValue = totalValue;
		this.money = money;
		this.expected_funds = expected_funds;
		this.managerNotif = managerNotif;
		this.employeeNotif = employeeNotif;
		this.exceedsFunds = exceedsFunds;
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



	public double getExpected_funds() {
		return expected_funds;
	}



	public void setExpected_funds(double expected_funds) {
		this.expected_funds = expected_funds;
	}



	public boolean isManagerNotif() {
		return managerNotif;
	}



	public void setManagerNotif(boolean managerNotif) {
		this.managerNotif = managerNotif;
	}



	public boolean isEmployeeNotif() {
		return employeeNotif;
	}



	public void setEmployeeNotif(boolean employeeNotif) {
		this.employeeNotif = employeeNotif;
	}



	public boolean isExceedsFunds() {
		return exceedsFunds;
	}



	public void setExceedsFunds(boolean exceedsFunds) {
		this.exceedsFunds = exceedsFunds;
	}
	
	
	
	
}
