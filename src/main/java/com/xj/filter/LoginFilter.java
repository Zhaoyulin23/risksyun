package com.xj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xj.pojo.PlaUser;

public class LoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		// 获得用户请求的URI
		String path = servletRequest.getRequestURI();
		// 从session里获取登录信息
		PlaUser plaUser = (PlaUser) session.getAttribute("userinfo");

		// 过滤页面
		if (path.indexOf("/login.jsp") > -1) {
			chain.doFilter(request, response);
			return;
		}
		String basePath = servletRequest.getScheme() + "://" + servletRequest.getServerName() + ":" + servletRequest.getServerPort() + servletRequest.getContextPath() + "/";
		// 如果没有登录则跳转到登录页面
		if (plaUser == null) {
			// 跳转到登陆页面
			servletResponse.sendRedirect(basePath + "view/login.jsp");
		} else {
			// 已经登陆,继续此次请求
			chain.doFilter(request, response);

		}

	}

	public void destroy() {

	}

}
