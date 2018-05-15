package com.fengf.wms.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fengf.wms.pojo.User;
import com.fengf.wms.service.LoginService;
@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	//去登陆的页面
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(String cur_username,String cur_password,HttpSession httpSession,Model model){
		System.out.println("username="+cur_username+"  password="+cur_password);
		User user=loginService.login(cur_username,cur_password);
		System.out.println(user);
		if(user!=null){
			
			System.out.println("login ok");
			httpSession.setAttribute("USER", user);
			return "redirect:home";
		}
		System.out.println("login failing");
		return "login";
	}
	@RequestMapping(value = "/home")
	public String home(){
		System.out.println("enter home");
		return "index";
	}
	@RequestMapping(value = "/exitlogin")
	public String login(HttpSession httpSession){
		System.out.println("开始关闭");
		httpSession.invalidate();
		return "login";
	}
}
