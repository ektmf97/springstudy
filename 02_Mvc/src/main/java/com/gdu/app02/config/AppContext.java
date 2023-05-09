package com.gdu.app02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app02.domain.Bbs;

@Configuration
public class AppContext {
	
	// 1번째 Bean은 root-context.xml에 있습니다. (프로젝트 때 조별로 정해서 하나만 하기)

	@Bean
	public Bbs bbs2() {
		Bbs bbs = new Bbs();
		bbs.setBbsNo(2);
		bbs.setTitle("살려주세요");
		bbs.setCreatedAt("2023-04-13");
		return bbs;
	}
}
