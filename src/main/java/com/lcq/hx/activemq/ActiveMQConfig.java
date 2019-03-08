/**
 * 项目名:hx
 * 包名：com.lcq.hx.activemq
 * 文件名：ActiveConfig.java
 * 用途：(这里用一句话描述这个方法的作用)
 * 版本信息：1.0
 * 作者：luzq58
 * 日期：2019-3-8 15:31:31
 * Copyright (c) 2019 东方希望集团-版权所有.
 */
package com.lcq.hx.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/** 
 * 项目名:ActiveMQConfig 配置Activemq 连接工程、目的地（队列、主题）
 * 包名：com.lcq.hx.activemq 
 * 文件名：ActiveConfig.java 
 * @author luzq58
 * @date 2019-3-8 15:48
 * 版本信息：1.0
 * Copyright (c) 2019-3-8 东方希望集团-版权所有.
 *  
 */
@Configuration
public class ActiveMQConfig {
	
	@Bean
	public ConnectionFactory connectionFactory(){
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
		return activeMQConnectionFactory;
	}

	@Bean
	public Queue queue(){
		ActiveMQQueue activeMQQueue = new ActiveMQQueue("luchangqing_queue");
		return activeMQQueue;
	}

	@Bean
	public Topic topic(){
		ActiveMQTopic activeMQTopic = new ActiveMQTopic("luchagnqing_topic");
		return activeMQTopic;
	}

	@Bean
	public JmsTemplate jmsTemplate(){
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		jmsTemplate.setDefaultDestination(queue());
		return jmsTemplate;
	}
	
	
}
