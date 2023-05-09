package com.gdu.app01.java02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		// com.gdu.app01.java02 ��Ű���� �ִ� Bean�� �ּ���!
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext("com.gdu.app01.java02");
		
		// �̸��� stu�� Bean�� �ּ���! @Bean public Student stu() {...}
		Student student = ctx.getBean("stu", Student.class);
		
		System.out.println("����: " + student.getScores());
		System.out.println("��: " + student.getAwards());
		System.out.println("����ó: " + student.getContact());
		
		ctx.close();

	}

}