package com.xj.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.RegEconomicsEnterprises;
import com.xj.service.RegEconomicsEnterprisesService;

@Controller
public class RegEconomicsEnterprisesController {
	
	@Autowired
	private RegEconomicsEnterprisesService regEconomicsEnterprisesService;
	
	/**
	 * 
	 * 获取区域经济百强企业列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/regEconomicsEnterprisesList.do")
	public ModelAndView getSeList(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView = regEconomicsEnterprisesService.getRegEconomicsEnterprisesList(request, modelAndView);
		
		modelAndView.setViewName("view/RegEconomicsEnterprisesManage");
		
		return modelAndView;
	}
	
	
	/**
	 * 获取区域百强企业详细
	 * @param request
	 * @param rge_id
	 * @return
	 */
	@RequestMapping(value = "/regEconomicsEnterprisesDetail.do")
	public ModelAndView getSeDetail(HttpServletRequest request, @RequestParam String rge_id){
		ModelAndView modelAndView = new ModelAndView();
		
		RegEconomicsEnterprises reEnterprise = new RegEconomicsEnterprises();
		
		reEnterprise = regEconomicsEnterprisesService.selectByPrimaryKey(rge_id);
		
		modelAndView.addObject("reEnterprise", reEnterprise);
		
		modelAndView.setViewName("view/regEconomicsEnterprisesUpdate");
		
		return modelAndView;
	}
	
	/**
	 * 保存
	 * @param request
	 * @param regEconomicsEnterprises
	 * @return
	 */
	@RequestMapping(value = "saveRegEconomicsEnterprises.do", method = RequestMethod.POST)
	public ModelAndView saveRegEconomicsEnterprises(HttpServletRequest request, RegEconomicsEnterprises regEconomicsEnterprises){
		ModelAndView modelAndView = new ModelAndView();
		
		
		if(regEconomicsEnterprises.getRgeId() == null){
			regEconomicsEnterprises.setCreateTime(new Date());
			regEconomicsEnterprisesService.addRegEconomicsEnterprises(regEconomicsEnterprises);
		}else{
			regEconomicsEnterprisesService.updateRegEconomicsEnterprises(regEconomicsEnterprises);
		}
		
		modelAndView.setViewName("redirect:/regEconomicsEnterprisesDetail.do?rge_id="+regEconomicsEnterprises.getRgeId());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteRegEconomicsEnterprises.do")
	public ModelAndView saveSignleEnterprise(HttpServletRequest request,@RequestParam String rge_id){
		ModelAndView modelAndView = new ModelAndView();
		
		regEconomicsEnterprisesService.deleteRegEconomicsEnterprises(rge_id);
		
		modelAndView.setViewName("redirect:/regEconomicsEnterprisesList.do");
		
		return modelAndView;
	}
}
