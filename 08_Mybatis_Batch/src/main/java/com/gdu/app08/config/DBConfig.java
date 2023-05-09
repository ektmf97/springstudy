package com.gdu.app08.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@MapperScan(basePackages= {"com.gdu.app08.mapper"})         // @Mapper가 존재하는 패키지를 작성한다.
@PropertySource(value={"classpath:application.properties"}) // resources 및 기본설정 application.properties 파일의 속성을 읽어오게한다.
@EnableTransactionManagement                                // 트랜잭션을 허용한다. 
@Configuration
public class DBConfig {

	@Autowired
	private Environment env;
	
	// HikaryConfig Bean (애플리케이션에 들어있는 설정값을 불러오세요)
	@Bean
	public HikariConfig hikariConfig() { // HikariConfig 등록시킴
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(env.getProperty("spring.datasource.hikari.driver-class-name")); // 애플리케이션프로퍼티값을 읽어온다.
		hikariConfig.setJdbcUrl(env.getProperty("spring.datasource.hikari.jdbc-url"));
		hikariConfig.setUsername(env.getProperty("spring.datasource.hikari.username"));
		hikariConfig.setPassword(env.getProperty("spring.datasource.hikari.password"));
		return hikariConfig; // HikariConfig를 반환 시켜준다.
	}
	
	// HikariDataSource Bean 
	@Bean(destroyMethod="close")
	public HikariDataSource hikariDataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	// SqlSessionFactory Bean
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception { // db를 처리하는 아이라서 try-catch가 필요한데 귀찮아서 던져버림 throws
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(hikariDataSource()); // 우리가 사용하기로 한 데이터소스 이름 : 히카리 전달
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(env.getProperty("mybatis.config-location")));     // mybatis.config-location
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations")));
		return bean.getObject();
	}
	
	// SqlSessionTemplate Bean (기존의 SqlSession)
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	// TransactionManager Bean 
	// 트랜잰셕은 데이타소스만 필요하다.
	@Bean
	public TransactionManager transactionmanger() {
		return new DataSourceTransactionManager(hikariDataSource()); // HikariDataSource 만들때 사용한 dataSource() 가져오기
	}
}
