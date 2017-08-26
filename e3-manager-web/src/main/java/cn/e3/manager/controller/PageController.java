package cn.e3.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	/**
	 * 需求:页面跳转
	 * 匹配所有请求
	 * 例如item-add item-edit item-list
	 */
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page){
		return page;
		
	}

}
