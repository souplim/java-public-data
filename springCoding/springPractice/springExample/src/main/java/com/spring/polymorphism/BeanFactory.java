package com.spring.polymorphism;

// 결합도를 낮추기 위한 또 다른 방법 디자인패턴
// Factory 패턴은 클라이언트에서 사용할 객체 생성을 캡슐화하여 TVUser와 TV 사이를 느슨한 결합 상태로 만들어준다.
public class BeanFactory {
	public Object getBean(String beanName) {
		if(beanName.equals("samsung"))
			return new SamsungTV();
		else if(beanName.equals("lg"))
			return new LgTV();
		
		return null;
	}
}
