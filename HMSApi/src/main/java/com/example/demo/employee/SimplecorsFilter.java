package com.example.demo.employee;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class SimplecorsFilter implements Filter {

	private static final Logger LOGGER =LoggerFactory.getLogger(SimplecorsFilter.class);
	FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.info("Initializing CORS filter 1");
		this.filterConfig = filterConfig;
	}
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		LOGGER.info("Hello  do filter method 1");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		LOGGER.info("Logging Request  {} : {}", request.getMethod(), request.getRequestURI());
		
		response.setHeader("Access-Control-Allow-Origin",response.getHeader("Origin"));	
	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PATCH");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
	    chain.doFilter(request, response);
		LOGGER.info("Logging Response :{}", request.getContentType());
		
	}
	
	public void destroy() {
	}

}
