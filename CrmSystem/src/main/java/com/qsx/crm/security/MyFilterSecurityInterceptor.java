package com.qsx.crm.security;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

@Component
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter{
	
	@Autowired
	private SimpleSecurityMetadataSource myDataSource;
	
	@Autowired
	private CustomAccessDecisionManager myAccessManager;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostConstruct
	public void init(){
		super.setAuthenticationManager(authenticationManager);
		super.setAccessDecisionManager(myAccessManager);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		FilterInvocation fl = new FilterInvocation(request, response,chain);
		invoke(fl);
	}
	
	private void invoke(FilterInvocation fl) throws IOException,ServletException{
		System.out.println("filter............");
		InterceptorStatusToken token = super.beforeInvocation(fl);
		try {
			fl.getChain().doFilter(fl.getRequest(), fl.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
			
	}

	@Override
	public void destroy() {
		System.out.println("filter=======end");
	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		System.out.println("filter getDatasource");
		return this.myDataSource;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter======start");
	}
	
}
