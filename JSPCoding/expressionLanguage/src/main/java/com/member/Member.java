package com.member;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String email;
	
	private Address address;
	public String getId()  {return id; }
	public void setId(String id) { this.id = id; }
	public String getPwd() { return pwd; }
	public void setPwd(String pwd) { this.pwd = pwd; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public Address getAddress() { return address; }
	public void setAddress(Address address) { this.address = address; }
}
