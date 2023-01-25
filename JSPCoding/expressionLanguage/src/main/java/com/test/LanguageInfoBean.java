package com.test;

public class LanguageInfoBean {
	public static String name = "Java"; // 정적 필드(클래스 필드)
	
	public static int getBirthYear() { // 정적 메서드(클래스 메서드)
		return 1996;
	}
	
	public static String getKindInfo() {
		return name+"는 OOP 프로그래밍 언어이다.";
	}
}
