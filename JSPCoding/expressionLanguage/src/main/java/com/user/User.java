package com.user;

public class User {
	private String uname;
	private String uid;
	private int unum;
	
	public User() {}
	public User(String uname, String uid, int unum) {
		super();
		this.uname = uname;
		this.uid = uid;
		this.unum = unum;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getUnum() {
		return unum;
	}
	public void setUnum(int unum) {
		this.unum = unum;
	}
	
	@Override
	public String toString() {
		return "User [uname=" + uname + ", uid=" + uid + ", unum=" + unum + "]";
	}
}
