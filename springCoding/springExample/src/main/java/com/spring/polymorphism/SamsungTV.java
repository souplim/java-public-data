package com.spring.polymorphism;

import lombok.Data;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

/*
 * public class SamsungTV implements TV { // private SonySpeaker speaker;
 * private Speaker speaker; private int price;
 * 
 * public SamsungTV() { System.out.println("===> SamsungTV(1) 객체 생성"); } public
 * SamsungTV(Speaker speaker) { System.out.println("===> SamsungTV(2) 객체 생성");
 * this.speaker = speaker; } public SamsungTV(Speaker speaker, int price) {
 * System.out.println("===> SamsungTV(3) 객체 생성"); this.speaker = speaker;
 * this.price = price; }
 * 
 * public void setSpeaker(Speaker speaker) {
 * System.out.println("===>setSpeaker() 호출"); this.speaker = speaker; } public
 * void setPrice(int price) { System.out.println("===>setPrice() 호출");
 * this.price = price; }
 * 
 * public void initMethod() { System.out.println("객체 초기화 작업 처리."); } public void
 * destroyMethod() { System.out.println("객체 삭제 전에 처리할 로직 처리."); }
 * 
 * public void powerOn() {
 * System.out.println("SamsungTV --- 전원을 켠다. (가격:"+price+")"); }
 * 
 * public void powerOff() { System.out.println("SamsungTV --- 전원을 끈다."); }
 * 
 * public void volumeUp() { // System.out.println("SamsungTV --- 소리를 올린다."); //
 * speaker = new SonySpeaker(); speaker.volumeUp(); }
 * 
 * public void volumeDown() { // System.out.println("SamsungTV --- 소리를 내린다.");
 * // speaker = new SonySpeaker(); speaker.volumeDown(); } }
 */

/* 작성한 코드에서 생성자, 설정자를 삭제한다 */
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@ToString
@Data // @Getter, @Setter, @ToString, @RequiredArgsConstructor 포함
public class SamsungTV implements TV {
//	private SonySpeaker speaker;
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 객체 생성");
	}
//	public SamsungTV(Speaker speaker) {
//		System.out.println("===> SamsungTV(2) 객체 생성"); 
//		this.speaker = speaker;
//	}
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(3) 객체 생성"); 
		this.speaker = speaker;
		this.price = price;
	}	

//	public void setSpeaker(Speaker speaker) {
//		System.out.println("===>setSpeaker() 호출");
//		this.speaker = speaker;
//	}
//	public void setPrice(int price) {
//		System.out.println("===>setPrice() 호출");
//		this.price = price;
//	}
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리.");
	}
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리.");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV --- 전원을 켠다. (가격:"+price+")");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV --- 전원을 끈다.");
	}
	
	public void volumeUp() {
//		System.out.println("SamsungTV --- 소리를 올린다.");
//		speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	
	public void volumeDown() {
//		System.out.println("SamsungTV --- 소리를 내린다.");
//		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
}