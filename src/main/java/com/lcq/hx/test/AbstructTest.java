/**
 * 项目名:hx
 * 包名：com.lcq.hx.test
 * 文件名：AbstructTest.java
 * 用途：(这里用一句话描述这个方法的作用)
 * 版本信息：1.0
 * 作者：luzq58
 * 日期：2019-1-24 13:08:08
 * Copyright (c) 2019 东方希望集团-版权所有.
 */
package com.lcq.hx.test;

import com.lcq.hx.mvc.config.ApplicationContextConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Topic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class})
public class AbstructTest {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Topic topic;
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test(){
		namedParameterJdbcTemplate.queryForObject("select * from  user ", new HashMap<String, Object>(), new RowMapper<Object>() {
			/**
			 * Implementations must implement this method to map each row of data
			 * in the ResultSet. This method should not call {@code next()} on
			 * the ResultSet; it is only supposed to map values of the current row.
			 *
			 * @param rs     the ResultSet to map (pre-initialized for the current row)
			 * @param rowNum the number of the current row
			 * @return the result object for the current row (may be {@code null})
			 * @throws SQLException if a SQLException is encountered getting
			 *                      column values (that is, there's no need to catch SQLException)
			 */
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				return null;
			}
		});
	}

	@Test
	public void testRedis(){
		redisTemplate.opsForValue().set("luchangqing","hexi");
	}

	@Test
	public void sendMessageToQueue(){
		jmsTemplate.convertAndSend("luchangqing");
	}

	@Test
	public void getMessageFromQueue(){
		Object o = jmsTemplate.receiveAndConvert();
		System.out.println(o);
		getMessageFromQueue();
	}

	@Test
	public void sendMessageToTopic(){
		jmsTemplate.setDefaultDestination(topic);
		jmsTemplate.convertAndSend("hexi");
	}

	@Test
	public void getMessageFromTopic(){
		jmsTemplate.setDefaultDestination(topic);
		Object o = jmsTemplate.receiveAndConvert();
		System.out.println(o);
		getMessageFromTopic();
	}



}
