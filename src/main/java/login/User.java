package login;

public class User {
	private int id;
	
	private String email;
	private String password;
	private String name;
	private int status_id;
	private int roll_id;
	private String emp_id;
	private String address;
	private String mobileno;
	private String rollName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRollName() {
		return rollName;
	}
	public void setRollName(String rollName) {
		this.rollName = rollName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public int getRoll_id() {
		return roll_id;
	}
	public void setRoll_id(int roll_id) {
		this.roll_id = roll_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", name=" + name + ", status_id=" + status_id
				+ ", roll_id=" + roll_id + "]";
	}

}
