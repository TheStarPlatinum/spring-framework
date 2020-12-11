package com.ydx.JDBC;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext("jdbcTest.xml");


		JdbcService jdbcService = cc.getBean(JdbcService.class);
//		jdbcService.getJdbcTemplate().getDataSource().
		jdbcService.getUserById(1);


	}
}
