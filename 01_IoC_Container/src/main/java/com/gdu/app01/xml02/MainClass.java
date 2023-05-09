package com.gdu.app01.xml02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml02/app-context.xml");
		
		Academy academy = ctx.getBean("academy", Academy.class);
		System.out.println("�̸�: " + academy.getName());
		System.out.println("���θ��ּ�: " + academy.getAddress().getRoadAddress());
		System.out.println("�����ּ�: " + academy.getAddress().getJibunAddress());
		System.out.println("��ȭ��ȣ: " + academy.getAddress().getContact().getTel());
		System.out.println("�ѽ���ȣ: " + academy.getAddress().getContact().getFax());
		
		ctx.close();

	}
}
