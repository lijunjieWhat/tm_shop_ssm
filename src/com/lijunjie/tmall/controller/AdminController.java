package com.lijunjie.tmall.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lijunjie.tmall.bean.Admin;
import com.lijunjie.tmall.service.UserService;

@Controller
@RequestMapping("")
public class AdminController {
	@Autowired
	private UserService userService;
	@RequestMapping("admin_login")
	public String login() {
		return "/admin/login";

	}
	@RequestMapping("loginCheck")
	public String loginCheck(Admin admin, HttpServletRequest request) {
		System.out.println(admin);
		Admin admin2 = userService.queryAdmin(admin);
		System.out.println(admin2);
		if (admin2 == null) {
			request.setAttribute("msg", "账号密码错误");
			return "/admin/login";
		}
		request.getSession().setAttribute("admin", admin2);
		return "redirect:admin_category_list.action";
	}
}
