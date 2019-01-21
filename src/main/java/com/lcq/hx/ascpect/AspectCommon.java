/**
 * 项目名:hx
 * 包名：com.lcq.hx.ascpect
 * 文件名：AspectCommon.java
 * 用途：(这里用一句话描述这个方法的作用)
 * 版本信息：1.0
 * 作者：luzq58
 * 日期：2019-1-19 13:10:10
 * Copyright (c) 2019 东方希望集团-版权所有.
 */
package com.lcq.hx.ascpect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectCommon {
	@Around(value = "execution(* com.lcq.hx.controller.HomeController.thymeleaftest(..))")
	public Object logSystemOperation(ProceedingJoinPoint joinPoint){
		Object proceed = null;
		try {
			System.out.println("Before");
			proceed = joinPoint.proceed();
			System.out.println("After");
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		} finally {
		}
		return proceed;

	}
}
