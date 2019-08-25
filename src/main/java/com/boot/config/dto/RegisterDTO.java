package com.boot.config.dto;

public class RegisterDTO {
	private String email;
	private String name;
	private String contact;
	private String dob;
	private String gender;
	private String address;
	private String password;
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	private String cpassword;

	@Override
	public String toString() {
		return "\n RegisterDTO [email=" + email + ", name=" + name + ", contact=" + contact + ", dob=" + dob
				+ ", gender=" + gender + ", address=" + address + ", password=" + password + ", cpassword=" + cpassword
				+ "]";
	}
	
	

}
