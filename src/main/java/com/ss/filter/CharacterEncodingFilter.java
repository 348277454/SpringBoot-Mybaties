package com.ss.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//字符编码过滤器
@WebFilter(urlPatterns = "/*", filterName = "CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("character encoding file start ...");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		filterChain.doFilter(request, response);
	}

	public void destroy() {
	}

}