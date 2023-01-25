package com.member;

// 데이터베이스 연동하지 않고 회원가입 입력받아 서블릿에서 JSP로 정보 공유하여 출력
public class Address { // 클래스 구성요소 -> 필드/생성자/메서드
	private String city;
	private String zipcode;
	
	public String getCity() {return city;}
	public void setCity(String city) {this.city = city;}
	public String getZipcode() { return zipcode; }
	public void setZipcode(String zipcode) { this.zipcode = zipcode; }
}
