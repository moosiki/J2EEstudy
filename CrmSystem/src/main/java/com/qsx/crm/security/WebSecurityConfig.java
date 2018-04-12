package com.qsx.crm.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyFilterSecurityInterceptor mySecurityFilter;
	
	@Autowired
	private AuthenticationProvider provider;// 注入我们自己的AuthenticationProvider
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//用到我们自己的provider，从而可以实现自己去数据库中提取用户名和密码进行校验的逻辑
		auth.authenticationProvider(provider);
		
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			//添加自定义的安全过滤器
			.addFilterBefore(mySecurityFilter, FilterSecurityInterceptor.class)
			.authorizeRequests()
			.antMatchers("/css/*","/plugins/**","/js/**","/login/**").permitAll()
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login")
			.defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
			.and().logout().permitAll();
	}
	

	
}
