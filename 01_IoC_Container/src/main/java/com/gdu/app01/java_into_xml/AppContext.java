package com.gdu.app01.java_into_xml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	@Bean
	public Publisher publisher() {
		Publisher publisher = new Publisher();
		publisher.setName("�ѱ����ǻ�");
		publisher.setTel("02-123-4567");
		return publisher;
	}
	
	@Bean
	public Book book() {
		Book book = new Book();
		book.setTitle("�ҳ���");
		book.setPublisher(publisher());
		return book;
	}
}
