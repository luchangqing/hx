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

import javax.servlet.*;

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
	 * Optionally perform further registration customization once
	 * {@link #registerDispatcherServlet(ServletContext)} has completed.
	 *
	 * @param registration the {@code DispatcherServlet} registration to be customized
	 * @see #registerDispatcherServlet(ServletContext)
	 */
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement("d:/lcq/tmp/uploads",2097152L,4194304L,0));
		super.customizeRegistration(registration);
	}

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
	 * Return the name under which the {@link DispatcherServlet} will be registered.
	 * Defaults to {@link #DEFAULT_SERVLET_NAME}.
	 *
	 * @see #registerDispatcherServlet(ServletContext)
	 */
	@Override
	protected String getServletName() {
		return super.getServletName();
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

	/**
	 * Specify filters to add and map to the {@code DispatcherServlet}.
	 *
	 * @return an array of filters or {@code null}
	 * @see #registerServletFilter(ServletContext, Filter)
	 */
	@Override
	protected Filter[] getServletFilters() {
		return super.getServletFilters();
	}

	/**
	 * Add the given filter to the ServletContext and map it to the
	 * {@code DispatcherServlet} as follows:
	 * <ul>
	 * <li>a default filter name is chosen based on its concrete type
	 * <li>the {@code asyncSupported} flag is set depending on the
	 * return value of {@link #isAsyncSupported() asyncSupported}
	 * <li>a filter mapping is created with dispatcher types {@code REQUEST},
	 * {@code FORWARD}, {@code INCLUDE}, and conditionally {@code ASYNC} depending
	 * on the return value of {@link #isAsyncSupported() asyncSupported}
	 * </ul>
	 * <p>If the above defaults are not suitable or insufficient, override this
	 * method and register filters directly with the {@code ServletContext}.
	 *
	 * @param servletContext the servlet context to register filters with
	 * @param filter         the filter to be registered
	 * @return the filter registration
	 */
	@Override
	protected FilterRegistration.Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
		return super.registerServletFilter(servletContext, filter);
	}
}
