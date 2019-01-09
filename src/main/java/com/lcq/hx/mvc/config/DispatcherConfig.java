/**
 * 项目名:hx
 * 包名：com.lcq.hx.mvc.config
 * 文件名：DispatcherConfig.java
 * 用途：(这里用一句话描述这个方法的作用)
 * 版本信息：1.0
 * 作者：luzq58
 * 日期：2019-1-9 10:48:48
 * Copyright (c) 2019 东方希望集团-版权所有.
 */
package com.lcq.hx.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {"com.lcq.hx.controller"})
@EnableWebMvc
public class DispatcherConfig implements WebMvcConfigurer {

	/**
	 * Configure view resolvers to translate String-based view names returned from
	 * controllers into concrete {@link View}
	 * implementations to perform rendering with.
	 *
	 * @param registry
	 * @since 4.1
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".html");
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		registry.viewResolver(resolver);
//		UrlBasedViewResolverRegistration jsp = registry.jsp("/WEB-INF/views/", ".html");
	}

	/**
	 * Configure a handler to delegate unhandled requests by forwarding to the
	 * Servlet container's "default" servlet. A common use case for this is when
	 * the {@link DispatcherServlet} is mapped to "/" thus overriding the
	 * Servlet container's default handling of static resources.
	 *
	 * @param configurer
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * Add handlers to serve static resources such as images, js, and, css
	 * files from specific locations under web application root, the classpath,
	 * and others.
	 *
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/*registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");*/
		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/static/js/");
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/static/css/");
		registry.addResourceHandler("/image/**").addResourceLocations("/WEB-INF/static/image/");
		registry.addResourceHandler("/bootstrap/**").addResourceLocations("/WEB-INF/static/bootstrap/");
	}
}
