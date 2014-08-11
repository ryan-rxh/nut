package com.nut.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	private List<String> allowedUrls;

	public void setAllowedUrls(List<String> allowedUrls) {
		this.allowedUrls = allowedUrls;
	}

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {

		String requestUrl = arg0.getRequestURL().toString();
		for(String url: allowedUrls){
			if(requestUrl.contains(url)){
				requestUrl = null;
				return true;
			}
		}
		
		if(arg0.getSession().getAttribute("LOGINUSER") == null){
			arg1.sendRedirect("login");
			return false;
		}
		
		return true;
	}
}
