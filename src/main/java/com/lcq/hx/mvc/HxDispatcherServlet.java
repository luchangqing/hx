/**
 * 项目名:hx
 * 包名：com.lcq.hx.mvc
 * 文件名：HxDispatcherServlet.java
 * 用途：(这里用一句话描述这个方法的作用)
 * 版本信息：1.0
 * 作者：luzq58
 * 日期：2019-1-9 10:45:45
 * Copyright (c) 2019 东方希望集团-版权所有.
 */
package com.lcq.hx.mvc;

import com.lcq.hx.mvc.config.ApplicationContextConfig;
import com.lcq.hx.mvc.config.DispatcherConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * springMvcDispatcherServlet
 * 项目名:HxDispatcherServlet
 * 包名：com.lcq.hx.mvc
 * 文件名：HxDispatcherServlet.java
 *
 * @author luzq58
 * @date 2019-1-9 10:46
 * 版本信息：1.0
 * Copyright (c) 2019-1-9 东方希望集团-版权所有.
 */
public class HxDispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {
	/**
	 * Specify {@code @Configuration} and/or {@code @Component} classes for the
	 * {@linkplain #createRootApplicationContext() root application context}.
	 *
	 * @return the configuration for the root application context, or {@code null}
	 * if creation and registration of a root context is not desired
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{ApplicationContextConfig.class};
	}

	/**
	 * Specify {@code @Configuration} and/or {@code @Component} classes for the
	 * {@linkplain #createServletApplicationContext() Servlet application context}.
	 *
	 * @return the configuration for the Servlet application context, or
	 * {@code null} if all configuration is specified through root config classes.
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{DispatcherConfig.class};
	}

	/**
	 * Specify the servlet mapping(s) for the {@code DispatcherServlet} &mdash;
	 * for example {@code "/"}, {@code "/app"}, etc.
	 *
	 * @see #registerDispatcherServlet(ServletContext)
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
