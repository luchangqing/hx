/**
 * 项目名:hx
 * 包名：com.lcq.hx.controller
 * 文件名：HomeController.java
 * 用途：(这里用一句话描述这个方法的作用)
 * 版本信息：1.0
 * 作者：luzq58
 * 日期：2019-1-9 11:45:45
 * Copyright (c) 2019 东方希望集团-版权所有.
 */
package com.lcq.hx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/thymeleaftest")
	public ModelAndView thymeleaftest(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("thymeleaftest");
		modelAndView.addObject("home","welcome lu");
		return modelAndView;
	}
}
