package com.gdu.app01.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 	<bean> �±׷� ������ Bean�� ������ �� ����ϴ� ������ Ŭ����
		 	1. GenericXmlApplicationContext Ŭ����
		 	2. ClassPathXmlApplicationContext Ŭ����
		 	�� Ŭ���� �� �ƹ��ų� ����ϸ� �˴ϴ�.
		 */
		 
		 // src/main/resources/xml01 ���͸��� �ִ� app-context.xml ���Ͽ� ���ǵ� Bean�� ������!
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml01/app-context.xml"); // src/main/resources�� ������� �ʽ��ϴ�.
		
		// Bean �߿��� student�� id�� ���� Bean�� �ּ���!
		Student haksaeng = ctx.getBean("student", Student.class); // (Student)ctx.getBean("student") ĳ���� �ش޶� ������ �ڵ�
		
		// haksaeng�� calculator�� �̿��� �޼ҵ带 ȣ���մϴ�!
		haksaeng.getCalculator().add(5, 2);
		haksaeng.getCalculator().sub(5, 2);
		haksaeng.getCalculator().mul(5, 2);
		haksaeng.getCalculator().div(5, 2);
		
		// ����� �ڿ� �ݳ��մϴ�! (���� �����մϴ�.)
		ctx.close(); 
		
	}

}
