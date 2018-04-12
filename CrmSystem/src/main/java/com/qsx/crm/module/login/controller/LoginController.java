package com.qsx.crm.module.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qsx.crm.model.MenuModel;
import com.qsx.crm.model.UserModel;
import com.qsx.crm.module.user.service.UserService;
import com.qsx.crm.util.CaptchaUtil;
import com.qsx.crm.web.ResponseData;
import com.qsx.crm.web.controller.BaseController;

@Controller
public class LoginController extends BaseController{
	
	@Autowired
	private UserService userservice;
	
	/**
	 * 进入登陆页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login(Model model) {
		String error = request.getParameter("error");
		System.out.println("登陆错误+"+error);
		  boolean hasLoginError = false;
	        String loginErrorMessage = "LoginSystemException";

	        if (!StringUtils.isEmpty(error)) {
	            hasLoginError = true;
	            loginErrorMessage = error;
	        } else {
	            Object exceptionObj = request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
	            if (exceptionObj != null) {
	                hasLoginError = true;
	                Exception exception = (Exception) exceptionObj;
	                loginErrorMessage = exception.getMessage();
	            }
	        }
	        System.out.println(hasLoginError+"登陆错误+"+loginErrorMessage);
		//转向（forward）前端页面
		System.out.println("登陆");
		return "login";
	}
	
	//登陆成功跳转页面
	@RequestMapping(value = "/index")
	public ModelAndView helloworld(ModelAndView mov) {
		UserModel userModel = userservice.findByloginName("admin");
		List<MenuModel> menus = userservice.getCurrentUserMenus();
		mov.addObject("userMenus",menus);
		mov.addObject("user",userModel);
		mov.setViewName("index");
		return mov;
	}
	
	
	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/login/captcha/generate")
	public void generateCaptcha(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("验证码controller");
		try {
			//生成验证码
			CaptchaUtil.generateCaptcha(request, response);
		} catch (Exception e) {
			logger.error(e.getMessage());}
	}
	
	/**
	 * 验证码验证
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login/captcha/check",method = RequestMethod.POST)
	@ResponseBody
	public ResponseData	checkCaptcha(Model model, HttpServletRequest request) {
		System.out.println("验证");
		ResponseData responseData = new ResponseData();
		String code = request .getParameter("captcha");
		
		System.out.println("输入的验证码"+code);
		System.out.println((String)request.getSession().getAttribute("login-captcha"));
		
		//比较验证码是否正确
		if (code.equalsIgnoreCase((String)request.getSession().getAttribute("login-captcha"))) {
			responseData.setStatus("0");
			
		} else {
			responseData.setStatus("-1");
		}
		
		//返回处理结果
		return responseData;
		
	}
	
}
