package com.qsx.crm.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import com.qsx.crm.model.Constants;
import com.qsx.crm.model.ResourceModel;

@Service
public class SimpleSecurityMetadataSource implements FilterInvocationSecurityMetadataSource{
	
	private static Log log = LogFactory.getLog(SimpleUserDetailsService.class);

	@Resource
	private RoleResourceRepository rRRepository;
	
	//按照Spring Security 要求定义角色与权限资源的映射关系
	private static Map<String, Collection<ConfigAttribute>> configAttributesMap = new 
			HashMap<String,Collection<ConfigAttribute>>();
	
	@PostConstruct
	public void loadResourceDefine() throws Exception{
		
		System.out.println("加载资源权限映射");
		if (!configAttributesMap.isEmpty()) {
			return;
		}
		//首先清除源资源映射配置信息
		configAttributesMap.clear();
		
		//获取所有角色与权限资源映射Map
		Map<String, List<ResourceModel>> roleResources = rRRepository.getRoleResource();
		
		//对角色所拥有的资源信息进行遍历
		for (Map.Entry<String, List<ResourceModel>> entry : roleResources.entrySet()) {
			for (ResourceModel resource  : entry.getValue()) {
				log.debug("Resource config -->" + resource + "/role:" +entry.getKey());
				System.out.println("Resource config 输出 -->" + resource + "/role:" +entry.getKey());
				if (configAttributesMap.containsKey(resource.getUrl())) {
					configAttributesMap.get(resource.getUrl()).add(new SecurityConfig(entry.getKey()));
					
				}else {
					Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
					ConfigAttribute configAttribute = new SecurityConfig(entry.getKey());
					configAttributes.add(configAttribute);
					configAttributesMap.put(resource.getUrl(), configAttributes);
				}
			}
			
		}
		//所有人都拥有的权限
		addResourceDefine("/index",Constants.ROLE_EVERY_ONE);
	}
	
	private void addResourceDefine(String resource, String roleName) {
		Collection<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();
		ConfigAttribute ca = new SecurityConfig(roleName);
		attributes.add(ca);
		configAttributesMap.put(resource, attributes);
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		FilterInvocation filterInvocation = (FilterInvocation) object;
		for (Map.Entry<String, Collection<ConfigAttribute>> entry : configAttributesMap.entrySet()) {
			String resourceUrl = entry.getKey();
			
			RequestMatcher requestMatcher = new AntPathRequestMatcher(resourceUrl);
			if (requestMatcher.matches(filterInvocation.getHttpRequest())) {
				return configAttributesMap.get(resourceUrl);
				
			}
		}
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
		for(Map.Entry<String, Collection<ConfigAttribute>> entry : configAttributesMap.entrySet()){
			allAttributes.addAll(entry.getValue());
		}
		return allAttributes;
			
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}
	
}
