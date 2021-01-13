package com.ydx.anno.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {


	@Autowired
	JdbcTemplate jdbcTemplate;

//	@Transactional
	public int insert(){

		String sql = "insert into user (name,age) values (?,?)";
		int i = jdbcTemplate.update(sql,"aaa",33);
		System.out.println(1/0);
		return i;
	}

}
