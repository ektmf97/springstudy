package com.gdu.app01.xml_into_java;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

// xml_into_java ���͸��� �ִ� app-context.xml�� ��ϵ� Bean�� ����������! (�ڿ��� �ҷ��帲)
@ImportResource("xml_into_java/app-context.xml")

@Configuration
public class AppContext {

}
