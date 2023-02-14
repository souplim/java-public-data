package com.spring.polymorphism;

public interface TV {
	// 모든 tv가 공통으로 가져야 할 메서드들을 추상 메서드로 선언
	public void powerOn();
	public void powerOff();
	public void volumeUp();
	public void volumeDown();
}
