package com.spring.polymorphism;

// ���յ��� ���߱� ���� �� �ٸ� ��� ����������
// Factory ������ Ŭ���̾�Ʈ���� ����� ��ü ������ ĸ��ȭ�Ͽ� TVUser�� TV ���̸� ������ ���� ���·� ������ش�.
public class BeanFactory {
	public Object getBean(String beanName) {
		if(beanName.equals("samsung"))
			return new SamsungTV();
		else if(beanName.equals("lg"))
			return new LgTV();
		
		return null;
	}
}
