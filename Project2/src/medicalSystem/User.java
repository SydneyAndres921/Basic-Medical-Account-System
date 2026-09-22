package medicalSystem;

abstract class User {
	protected int ID;
	protected String username;
	protected String password;
	protected String name;
	protected String email;
	
	
	public User(int ID, String username, String password, String name, String email) {
		this.ID = ID;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	
	
	public int getID() {
		return ID;
	}
	
	
	
	public String getUsername() {
		return username;
	}
	
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return ID + "," + username + "," + password + "," + name + "," + email;
	}
	
	public String formalString() {
		return ID + "," + name + "," + email;
	}
}
