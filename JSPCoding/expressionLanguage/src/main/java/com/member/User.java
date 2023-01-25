package com.member;

public class User {
	private int unum;
	private String uname;
	private String uid;
	
	// has-a 관계 설정(회원 정보는 주소를 갖고 있음)
	// 이 때 설정방법은 접근제한자 클래스타입 필드명;
	private Address address;

	public int getUnum() {
		return unum;
	}

	public void setUnum(int unum) {
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
