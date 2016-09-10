package com.npf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {


	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object object) throws Exception {
		String url = request.getRequestURI();
		if(url.indexOf("login")>0){
			return true;
		}
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username != null){
			return true;
		}
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}
	
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("HandlerInterceptor1.postHandle()");
	}
	
	public void afterCompletion(HttpServletRequest arg0,HttpServletResponse arg1, Object arg2, Exception arg3)throws Exception {
		System.out.println("HandlerInterceptor1.afterCompletion()");
	}

}