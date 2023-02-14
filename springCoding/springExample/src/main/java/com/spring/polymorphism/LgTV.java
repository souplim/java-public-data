package com.spring.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Setter;

/*public class LgTV implements TV {
//	public void turnOn() {
//		System.out.println("LgTV --- 전원 켠다.");
//	}
//	
//	public void turnOff() {
//		System.out.println("LgTV --- 전원 끈다.");
//	}
//	
//	public void soundUp() {
//		System.out.println("LgTV --- 소리를 올린다.");
//	}
//	
//	public void soundDown() {
//		System.out.println("LgTV --- 소리를 내린다.");
//	}
	
	public LgTV() {
		System.out.println("===> LgTV 객체 생성됨");
	}
	public void powerOn() {
		System.out.println("LgTV --- 전원을 켠다.");
	}
	
	public void powerOff() {
		System.out.println("LgTV --- 전원을 끈다.");
	}
	
	public void volumeUp() {
		System.out.println("LgTV --- 소리를 올린다.");
	}
	
	public void volumeDown() {
		System.out.println("LgTV --- 소리를 내린다.");
	}
}*/

@Component("tv")
public class LgTV implements TV {
	/* speaker로 구현된 구현 클래스가 하나 이상일 경우
	@Autowired
	@Qualifier("apple")
	private Speaker speaker; */
	
	/* 필드 객체에 의존성 주입 */
	@Autowired
	private Speaker speaker; 
	
	/* 생성자로 의존성 주입 
	private Speaker speaker; 
	
	@Autowired
	public LgTV(Speaker speaker){
		this.speaker = speaker;
	} */
	
	/* 설정자로 의존성 주입 
	private Speaker speaker; 
	
	@Autowired
	public void setSpeaker(Speaker speaker){
		this.speaker = speaker;
	} */
	
	/* lombok으로 설정자 생성하여 의존성 주입 
	@Setter(onMethod_=@Autowired)
	private Speaker speaker; */
	
	public LgTV() {
		System.out.println("===> LgTV 객체 생성됨");
	}
	public void powerOn() {
		System.out.println("LgTV --- 전원을 켠다.");
	}
	
	public void powerOff() {
		System.out.println("LgTV --- 전원을 끈다.");
	}
	
	public void volumeUp() {
//		System.out.println("LgTV --- 소리를 올린다.");
		speaker.volumeUp();
	}
	
	public void volumeDown() {
//		System.out.println("LgTV --- 소리를 내린다.");
		speaker.volumeDown();
	}
}
