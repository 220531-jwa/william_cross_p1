package dev.cross.models;

public class Creds {

	private String user;
	private String pass;
	
	public Creds (String u, String p) {
		user = u;
		pass = p;
	}
	
	public String getUser() {
		return user;
	}
	
	public boolean checkPass(String p) {
		return pass.equals(p);
	}
	
}
