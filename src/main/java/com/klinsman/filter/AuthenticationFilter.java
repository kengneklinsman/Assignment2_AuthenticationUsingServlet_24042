package com.klinsman.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		// check if the user is authenticated by looking for a session attribute
		HttpSession session = httpRequest.getSession(false);
		
		if(session != null && session.getAttribute("name") != null) {
			// user is authenticated, proceed to the servlet
			chain.doFilter(request, response);
		}
		httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
	}
	
}
