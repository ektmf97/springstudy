package com.gdu.app01.java01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 	@Configuration
 	�ȳ�. �� Configuration�̶�� ��.
 	Spring Container�� Bean�� ����� �δ� Java Ŭ������.
 	Spring Bean Configuration File�ϰ� ���� ���� ����
 */
@Configuration
public class AppContext {
	
	// Bean�� ����� ������ �޼ҵ带 ����� �˴ϴ�. (Bean �ϳ� = �޼ҵ� �ϳ�)
	
	
	/*
	 	@Bean 
	 	�ȳ�. �� Bean�� ����� �޼ҵ��.
	 	��ȯŸ���� Bean�� Ÿ��(<bean> �±��� class �Ӽ�)�̰�,
	 	�޼ҵ���� Bean�� �̸�(<bean> �±��� id �Ӽ�)�̾�.
	 */
	@Bean
	public Contact contact1() {	   // <bean id="contact1" class="Contact">
		Contact c = new Contact(); // default constructor
		c.setTel("02-2222-2220");  // setter <property name="tel" value="02-2222-2220">
		c.setFax("02-2222-2229");  // setter <property name="fax" value="02-2222-2220">
		return c;                  // ��ȯ�� ��ü c�� Spring Container�� ����˴ϴ�.
	}
	
	@Bean 
	public User user1() {         // <bean id="user1" class="User">
		User u = new User();      // default constructor 
		u.setId("spider");	      // setter <property name="id" value="spider"/>
		u.setContact(contact1()); // setter <property name="id" ref="contact1"/>
		return u;                 // ��ȯ�� ��ü u�� Spring Container�� ����˴ϴ�.
	}
	
	/*
	 * @Bean public Contact contact2() { Contact c = new Contact();
	 * c.setTel("010-1234-5678"); c.setFax("02-831-1234"); return c; }
	 * 
	 * @Bean public User user2() { User u = new User(); u.setId("ektmf");
	 * u.setContact(contact2()); return u; }
	 */
	
	@Bean(name="contact2")  // name �Ӽ��� �߰��Ǹ� Bean�� id�� ���˴ϴ�.
	public Contact www() {  // name �Ӽ��� ���Ǿ����Ƿ� �޼ҵ���� �� �̻� Bean�� id�� �ƴϿ���. �ƹ� �̸��̳� �ᵵ �˴ϴ�.
		return new Contact("02-333-3333", "02-333-3334");
	}
	
	@Bean(name="user2")     // name �Ӽ��� �߰��Ǹ� Bean�� id�� ���˴ϴ�.
	public User aaa() {     // name �Ӽ��� ���Ǿ����Ƿ� �޼ҵ���� �� �̻� Bean�� id�� �ƴϿ���. �ƹ� �̸��̳� �ᵵ �˴ϴ�.
		return new User("superman", www());
	}
}
