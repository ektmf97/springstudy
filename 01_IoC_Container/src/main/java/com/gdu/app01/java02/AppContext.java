package com.gdu.app01.java02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	@Bean
	public Student stu() {  // <bean id="stu" class="Student">
		
		// 0~100 ���� 5��
		List<Integer> scores = new ArrayList<Integer>();
		for(int cnt = 0; cnt < 5; cnt++) {             // 5�� �ݺ��մϴ�. 
			scores.add( (int)(Math.random() * 101) );  // 0���� 101���� ������ �߻��ȴ�.(0~100)
		}
		
		// �� 3��
		Set<String> awards = new HashSet<String>();
		awards.add("���ٻ�");
		awards.add("�����");
		awards.add("������");
		
		// address, tel
		Map<String, String> contact = new HashMap<String, String>();
		contact.put("address", "seoul");
		contact.put("tel", "02-1234-5678");
		
		// Bean ���� �� ��ȯ
		Student student = new Student();
		student.setScores(scores);
		student.setAwards(awards);
		student.setContact(contact);
		return student;
		
	}
	
}