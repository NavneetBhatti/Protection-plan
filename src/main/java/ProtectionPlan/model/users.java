package ProtectionPlan.model;

public class users {
	private String username;
	private String password;
	private String cell;
	private String email;
	private String name;
	private String address;
	
	public  users() {	
	}
	public  users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	
	}
	
	public  users(String username, String password, String cell, String email,String name,String address) {
		super();
		this.username = username;
		this.password = password;
		this.cell = cell;
		this.email = email;
		this.name = name;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getCell() {
		return password;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public String setAddress(String address) {
		return address;
	}

	
	
	@Override
	public String toString() {
		return "users("+"username="+username+",password="+password+", cell="+cell+", email="+email+", name="+name+",address="+address+")";
	}
	



}


	
	