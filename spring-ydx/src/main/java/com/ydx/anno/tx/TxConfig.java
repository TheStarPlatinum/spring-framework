package com.ydx.anno.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ydx.anno.tx")
public class TxConfig {

	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
		comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		return comboPooledDataSource;
	}


	/*
		@EnableTransactionManagement
		1.注册了 TransactionManagementConfigurationSelector.class
			例佣TransactionManagementConfigurationSelector 给容器导入组件
			AutoProxyRegistrar.class 和 ProxyTransactionManagementConfiguration.class
			1.AutoProxyRegistrar 注册了 InfrastructureAdvisorAutoProxyCreator
			  其利用后置处理器初始化bean时填充属性
			2.ProxyTransactionManagementConfiguration 有 AnnotationTransactionAttributeSource类型的bean
			  这个bean注册了

	 */



	/**
	 *
	 * @param dataSource @configuration中 @bean修饰的方法 参数会直接从spring容器中寻找
	 * @return
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
		return dataSourceTransactionManager;
	}

}
