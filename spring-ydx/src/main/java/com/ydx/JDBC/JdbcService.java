package com.ydx.JDBC;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JdbcService {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 查询
	 * @param id 根据id查询
	 * @return 对应idd的user对象
	 */
	public User getUserById(int id) {
		return jdbcTemplate
				.queryForObject("select * from `user` where id  =  ?", new RowMapper<User>() {
					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						user.setId(rs.getInt("id"));
						user.setAge(rs.getInt("age"));
						user.setName(rs.getString("name"));
						return user;
					}
				}, id);
	}

	public int saveUser(User user){
		return jdbcTemplate.update("insert into user values(?,?,?)",
				new Object[]{user.getId(),user.getName(),user.getAge()});
	}

}
@Data
class User{
	Integer id;
	String name;
	Integer age;
}