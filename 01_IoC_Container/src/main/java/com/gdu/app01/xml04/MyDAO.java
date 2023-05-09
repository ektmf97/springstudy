package com.gdu.app01.xml04;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyDAO {
	
	// field
	private Connection con;
	
	// singleton pattern - app-context.xml에서 <bean> 태그를 만들 때 사용된다.
	// dao에 싱글톤 패턴인데 권한이 스프링으로 넘어가서 스프링이 처리한다.
	
	// method
	public Connection getConnection() {
		
		// Spring Conteiner에 만들어 둔 myConn Bean 가져오기
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml04/app-context.xml");
		con = ctx.getBean("myConn",MyConnection.class).getConnection(); // bean의 이름 bean의 클래스 가져오기 
		ctx.close();
		return con;
	}
	
	public void close() {
		
		try	{
			if(con != null) {
				con.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public void list() {
		
		con = getConnection();
		
		close();
		
	}
}
