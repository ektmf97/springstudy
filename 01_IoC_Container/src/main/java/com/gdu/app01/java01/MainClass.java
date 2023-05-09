package com.gdu.app01.java01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		 	@Configuration, @Bean �ֳ����̼����� ������ Bean�� ������ �� ����ϴ� ������ Ŭ����
		 	AnnotationConfigApplicationContext 
		 */
		
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class); // AppContext.java ���Ͽ� �ִ� Bean�� �ּ���!
		// AbstractApplicationContext ctx = new AnnotationConfigApplicationContext("com.gdu.app01.java01");  com.gdu.app01.java01 ��Ű���� �ִ� ��� Bean�� �ּ���!
		
		User user1 = ctx.getBean("user1", User.class);
		System.out.println(user1.getId());
		System.out.println(user1.getContact().getTel());
		System.out.println(user1.getContact().getFax());
		
		
		User user2 = ctx.getBean("user2", User.class);
		System.out.println(user2.getId());
		System.out.println(user2.getContact().getTel());
		System.out.println(user2.getContact().getFax());
	
		ctx.close();
		
		/*
		 * AbstractApplicationContext ctx2 = new
		 * AnnotationConfigApplicationContext(AppContext.class); User user2 =
		 * ctx2.getBean("user2", User.class); System.out.println(user2.getId());
		 * System.out.println(user2.getContact().getTel());
		 * System.out.println(user2.getContact().getFax());
		 * 
		 * ctx2.close();
		 */
	}

}
