package dev.cross.models;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String pass;
	private boolean manager;
	private float reimburseUsed;
	
	public User() {
		super();
	}
	
	public User(int id, String firstName, String lastName, String username, String pass, boolean manager, float reimburseUsed) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username; 
		this.pass = pass;
		this.manager = manager;
		this.reimburseUsed = reimburseUsed;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public float getReimburseUsed() {
		return reimburseUsed;
	}

	public void setReimburseUsed(float reimburseUsed) {
		this.reimburseUsed = reimburseUsed;
	}
	
}
