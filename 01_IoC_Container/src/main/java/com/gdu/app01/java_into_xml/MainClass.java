package com.gdu.app01.java_into_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
			
		// java_into_xml ������ �ִ� app-context.xml
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("java_into_xml/app-context.xml");
		
		// �̸��� book�� Bean�� �ּ���!
		Book book = ctx.getBean("book", Book.class);
		
		System.out.println("����: " + book.getTitle());
		System.out.println("���ǻ��: " + book.getPublisher().getName());
		System.out.println("���ǻ���ȭ: " + book.getPublisher().getTel());
		
		ctx.close();
	}

}
