package com.spring.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Setter;

/*public class LgTV implements TV {
//	public void turnOn() {
//		System.out.println("LgTV --- ���� �Ҵ�.");
//	}
//	
//	public void turnOff() {
//		System.out.println("LgTV --- ���� ����.");
//	}
//	
//	public void soundUp() {
//		System.out.println("LgTV --- �Ҹ��� �ø���.");
//	}
//	
//	public void soundDown() {
//		System.out.println("LgTV --- �Ҹ��� ������.");
//	}
	
	public LgTV() {
		System.out.println("===> LgTV ��ü ������");
	}
	public void powerOn() {
		System.out.println("LgTV --- ������ �Ҵ�.");
	}
	
	public void powerOff() {
		System.out.println("LgTV --- ������ ����.");
	}
	
	public void volumeUp() {
		System.out.println("LgTV --- �Ҹ��� �ø���.");
	}
	
	public void volumeDown() {
		System.out.println("LgTV --- �Ҹ��� ������.");
	}
}*/

@Component("tv")
public class LgTV implements TV {
	/* speaker�� ������ ���� Ŭ������ �ϳ� �̻��� ���
	@Autowired
	@Qualifier("apple")
	private Speaker speaker; */
	
	/* �ʵ� ��ü�� ������ ���� */
	@Autowired
	private Speaker speaker; 
	
	/* �����ڷ� ������ ���� 
	private Speaker speaker; 
	
	@Autowired
	public LgTV(Speaker speaker){
		this.speaker = speaker;
	} */
	
	/* �����ڷ� ������ ���� 
	private Speaker speaker; 
	
	@Autowired
	public void setSpeaker(Speaker speaker){
		this.speaker = speaker;
	} */
	
	/* lombok���� ������ �����Ͽ� ������ ���� 
	@Setter(onMethod_=@Autowired)
	private Speaker speaker; */
	
	public LgTV() {
		System.out.println("===> LgTV ��ü ������");
	}
	public void powerOn() {
		System.out.println("LgTV --- ������ �Ҵ�.");
	}
	
	public void powerOff() {
		System.out.println("LgTV --- ������ ����.");
	}
	
	public void volumeUp() {
//		System.out.println("LgTV --- �Ҹ��� �ø���.");
		speaker.volumeUp();
	}
	
	public void volumeDown() {
//		System.out.println("LgTV --- �Ҹ��� ������.");
		speaker.volumeDown();
	}
}
