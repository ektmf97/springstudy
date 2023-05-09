package com.gdu.app01.xml05;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml05/app-context.xml");
		Person person = ctx.getBean("p", Person.class);
		
		// List<String> hobbies
		List<String> hobbies = person.getHobbies();
		for(int i = 0; i < hobbies.size(); i++) {
			System.out.println("���" + (i + 1) + ": " + hobbies.get(i));
		}
		
		// Set<String> contacts
		Set<String> contacts = person.getContacts();
		for(String contact : contacts) { // Set ������ index�� ���� ������ advanced for�� �����մϴ�.
			System.out.println(contact );
		}
		
		// Map<String, String> friends
		// Map�� entrySet �׻� ����ؾ� �Ѵ�.
		Map<String, String> friends = person.getFriends();
		for(Entry<String, String> entry : friends.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		ctx.close();
		
	}

}
