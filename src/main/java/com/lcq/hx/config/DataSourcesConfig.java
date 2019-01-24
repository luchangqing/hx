/**
 * 项目名:hx
 * 包名：com.lcq.hx.config
 * 文件名：DataSourcesConfig.java
 * 用途：(这里用一句话描述这个方法的作用)
 * 版本信息：1.0
 * 作者：luzq58
 * 日期：2019-1-24 10:15:15
 * Copyright (c) 2019 东方希望集团-版权所有.
 */
package com.lcq.hx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configurable
public class DataSourcesConfig {
	@Bean
	public DataSource dataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		/**
		 * 基本属性 url、user、password
		 */
		dataSource.setUrl("jdbc:mysql://localhost:3306/hx?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		/**
		 * 配置初始化大小、最小、最大
		 */
		dataSource.setInitialSize(5);//0:初始化时建立物理连接的个数。初始化发生在显示调用init方法，或者第一次getConnection时
		dataSource.setMinIdle(10);//最小连接池数量
		dataSource.setMaxActive(20);//8:最大连接池数量
		/**
		 * 配置获取连接等待超时的时间
		 * 获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁，并发效率会有所下降，如果需要可以通过配置useUnfairLock属性为true使用非公平锁。
		 */
		dataSource.setMaxWait(60000L);
		/**
		 * 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		 *
		 * 默认值1分钟
		 * 有两个含义：
		 * 1) Destroy线程会检测连接的间隔时间，如果连接空闲时间大于等于minEvictableIdleTimeMillis则关闭物理连接。
		 * 2) testWhileIdle的判断依据，详细看testWhileIdle属性的说明
		 */
		dataSource.setTimeBetweenEvictionRunsMillis(2000L);
		/**
		 * 配置一个连接在池中最小生存的时间，单位是毫秒
		 * 连接保持空闲而不被驱逐的最小时间
		 */
		dataSource.setMinEvictableIdleTimeMillis(600000L);
		dataSource.setMaxEvictableIdleTimeMillis(900000L);
		/**
		 *用来检测连接是否有效的sql，要求是一个查询语句，常用select 'x'。如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会起作用
		 */
		dataSource.setValidationQuery("select 1");
		/**
		 * 默认false
		 * 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
		 */
		dataSource.setTestWhileIdle(true);
		/**
		 *默认 true
		 * 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
		 */
		dataSource.setTestOnBorrow(false);
		/**
		 *默认false
		 * 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
		 */
		dataSource.setTestOnReturn(false);
		/**
		 *默认false
		 * 连接池中的minIdle数量以内的连接，空闲时间超过minEvictableIdleTimeMillis，则会执行keepAlive操作。
		 */
		dataSource.setKeepAlive(true);
		/**
		 *
		 */
		dataSource.setPhyMaxUseCount(100000L);
		/**
		 * 配置监控统计拦截的filters
		 */
		try {
			dataSource.setFilters("stat");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource){
		return new NamedParameterJdbcTemplate(dataSource);
	}
}
