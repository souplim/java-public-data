package com.spring.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
//		SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
//		LgTV tv = new LgTV();
//		tv.turnOn();
//		tv.turnOff();
//		tv.soundUp();
//		tv.soundDown();
		
		// ������ �̿�
//		TV tv = new SamsungTV();
//		tv = new LgTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		// ������ ���� �̿�
//		BeanFactory bf = new BeanFactory();
//		TV tv = (TV)bf.getBean(args[0]);
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		// 1. Spring �����̳ʸ� ����
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û(Lookup)
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. Spring �����̳ʸ� ����
		factory.close();
	}
}
