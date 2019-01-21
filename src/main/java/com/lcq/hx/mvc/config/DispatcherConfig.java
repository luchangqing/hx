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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@ComponentScan(basePackages = {"com.lcq.hx.controller"})
@EnableWebMvc
@EnableAspectJAutoProxy
public class DispatcherConfig implements WebMvcConfigurer {

	@Autowired
	private ApplicationContext applicationContext;

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

		//method 1
		/*InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".html");
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		registry.viewResolver(resolver);*/

		//method 2
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setOrder(1);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCacheable(false);
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.setEnableSpringELCompiler(true);
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		registry.viewResolver(viewResolver);

		//method 3
		/*registry.jsp("/WEB-INF/jsp/", ".jsp");*/

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
