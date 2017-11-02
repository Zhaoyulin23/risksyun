package com.xj.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.IndustryStatEnterprises;
import com.xj.service.IndustryStatEnterprisesService;

//@Controller
public class IndustryStatEnterprisesController {
	
	@Autowired
	private IndustryStatEnterprisesService industryStatEnterprisesService;
	
	/**
	 * 
	 * 获取行业列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/industryStatEnterprisesList.do")
	public ModelAndView getSeList(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView = industryStatEnterprisesService.getIndustryStatEnterprisesList(request, modelAndView);
		
		modelAndView.setViewName("view/industryStatEnterprisesManage");
		
		return modelAndView;
	}
	
	
	/**
	 * 获取行业详细
	 * @param request
	 * @param iseId
	 * @return
	 */
	@RequestMapping(value = "/industryStatEnterprisesDetail.do")
	public ModelAndView getSeDetail(HttpServletRequest request, @RequestParam int iseId){
		ModelAndView modelAndView = new ModelAndView();
		
		IndustryStatEnterprises isEnterprise = new IndustryStatEnterprises();
		
		isEnterprise = industryStatEnterprisesService.selectByPrimaryKey(iseId);
		
		modelAndView.addObject("isEnterprise", isEnterprise);
		
		modelAndView.setViewName("view/industryStatEnterprisesUpdate");
		
		return modelAndView;
	}
	
	/**
	 * 保存
	 * @param request
	 * @param industryStatEnterprises
	 * @return
	 */
	@RequestMapping(value = "saveIndustryStatEnterprises.do", method = RequestMethod.POST)
	public ModelAndView saveIndustryStatEnterprises(HttpServletRequest request, IndustryStatEnterprises industryStatEnterprises){
		ModelAndView modelAndView = new ModelAndView();
		
		
		if(industryStatEnterprises.getIseId() == null){
			industryStatEnterprises.setCreateTime(new Date());
			industryStatEnterprisesService.addIndustryStatEnterprises(industryStatEnterprises);
		}else{
			industryStatEnterprisesService.updateIndustryStatEnterprises(industryStatEnterprises);
		}
		
		modelAndView.setViewName("redirect:/industryStatEnterprisesDetail.do?ise_id="+industryStatEnterprises.getIseId());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteIndustryStatEnterprises.do")
	public ModelAndView saveIndustryStatEnterprises(HttpServletRequest request,@RequestParam Integer iseId){
		ModelAndView modelAndView = new ModelAndView();
		
		industryStatEnterprisesService.deleteIndustryStatEnterprises(iseId);
		
		modelAndView.setViewName("redirect:/industryStatEnterprisesList.do");
		
		return modelAndView;
	}
}
