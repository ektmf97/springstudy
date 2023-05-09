package com.gdu.app01.xml04;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyDAO {
	
	// field
	private Connection con;
	
	// singleton pattern - app-context.xml���� <bean> �±׸� ���� �� ���ȴ�.
	// dao�� �̱��� �����ε� ������ ���������� �Ѿ�� �������� ó���Ѵ�.
	
	// method
	public Connection getConnection() {
		
		// Spring Conteiner�� ����� �� myConn Bean ��������
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml04/app-context.xml");
		con = ctx.getBean("myConn",MyConnection.class).getConnection(); // bean�� �̸� bean�� Ŭ���� �������� 
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
