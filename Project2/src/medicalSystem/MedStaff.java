package medicalSystem;

public class MedStaff extends User {
	protected String Department;
	
	public MedStaff(int ID, String username, String password, String name, String email, String Department) {
		super(ID, username, password, name, email);
		this.Department = Department;
	}
	
	
	
	public void setDepartment(String Department) {
		this.Department = Department;
	}
	
	public String getDepartment() {
		return Department;
	}
	
	@Override
	public String toString() {
		return super.toString() + "," + Department;
	}
}
