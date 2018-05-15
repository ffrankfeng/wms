package com.fengf.wms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fengf.wms.pojo.User;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
				//判断用户是否登陆  如果没有登陆  重定向到登陆页面   不放行   如果登陆了  就放行了
				// URL  http://localhost:8080/springmvc-mybatis/login.action
				//URI /login.action
				String requestURI = request.getRequestURI();
				if(!requestURI.contains("/login")){
					User user = (User) request.getSession().getAttribute("USER");
					if(user==null){
						response.sendRedirect(request.getContextPath()+"/login.action");
						return false;
					}
				}
				return true;
	}

}
