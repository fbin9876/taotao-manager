package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转Controller
 * <p>
 * Title: PageController
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.taotao.com
 * </p>
 * 
 * @author fb
 * @date 2017年3月1日 下午10:56:37
 * @version 1.0
 */
@Controller
public class PageController {

	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}

}
