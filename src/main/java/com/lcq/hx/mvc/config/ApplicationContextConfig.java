/**
 * 项目名:hx
 * 包名：com.lcq.hx.mvc.config
 * 文件名：ApplicationContextConfig.java
 * 用途：(这里用一句话描述这个方法的作用)
 * 版本信息：1.0
 * 作者：luzq58
 * 日期：2019-1-9 11:00:00
 * Copyright (c) 2019 东方希望集团-版权所有.
 */
package com.lcq.hx.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.lcq.hx"}, excludeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {EnableWebMvc.class,})})
public class ApplicationContextConfig {
}
