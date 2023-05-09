package com.gdu.app01.xml_into_java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		// AppContext.java�� ���ǵ� Bean�� �ּ���!
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		// �̸��� upload�� Bean�� �ּ���!
		Upload upload = ctx.getBean("upload", Upload.class);
		
		System.out.println("÷������: " + upload.getTitle());
		System.out.println("÷������: " + upload.getAttach().getFilename());
		System.out.println("÷�ΰ��: "+ upload.getAttach().getPath());
		ctx.close();
	}

}
