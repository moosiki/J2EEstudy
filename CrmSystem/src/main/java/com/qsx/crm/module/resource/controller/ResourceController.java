package com.qsx.crm.module.resource.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsx.crm.model.ResourceModel;
import com.qsx.crm.module.resource.service.ResourceService;
import com.qsx.crm.web.ResponseData;
import com.qsx.crm.web.controller.BaseController;

/**
 * 资源控制类
 * @author Mryang
 *
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController{
	
	@Autowired
	private	ResourceService rService;
	
	/**
	 * 进入资源列表页面
	 * @param model
	 * @param menuId 根据id查询进入
	 * @return
	 */
	@GetMapping(value = "/resource/{menuId}")
	public String resource(Model model, @PathVariable Long menuId) {
		ResourceModel rModel =  new ResourceModel();
		rModel.setId(menuId);
		model.addAttribute(rModel);	
		//转向前端页面
		return "/menu/menuResource";
	}
	
	/**
	 * 保存资源
	 * @param model
	 * @param resource
	 * @return
	 */
	@RequestMapping(value = "/resource/save")
	@ResponseBody
	public ResponseData resourceSave(Model model, @Valid @ModelAttribute("resource") ResourceModel resource) {
		ResponseData responseData = new ResponseData();
		try {
			
		} catch (Exception e) {
			//异常处理
			logger.error(e.getMessage());
			responseData.setError(e.getMessage());
		}
		//返回处理结果
		return responseData;
	}
	
	
	
}
