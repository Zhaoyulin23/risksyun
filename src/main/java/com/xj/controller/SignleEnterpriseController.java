package com.xj.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.PlaUser;
import com.xj.pojo.SignleEnterprise;
import com.xj.service.SignleEnterpriseService;

@Controller
public class SignleEnterpriseController {
	
	@Autowired
	private SignleEnterpriseService signleEnterpriseService;
	
	/**
	 * 
	 * 获取单个企业列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/signleEnterpriseList.do")
	public ModelAndView getSeList(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView = signleEnterpriseService.getSignleEnterpriseList(request, modelAndView);
		
		modelAndView.setViewName("view/signleEnterpriseManage");
		
		return modelAndView;
	}
	
	
	/**
	 * 获取单个企业详细
	 * @param request
	 * @param se_id
	 * @return
	 */
	@RequestMapping(value = "/signleEnterpriseDetail.do")
	public ModelAndView getSeDetail(HttpServletRequest request, @RequestParam int se_id){
		ModelAndView modelAndView = new ModelAndView();
		
		SignleEnterprise seEnterprise = new SignleEnterprise();
		
		seEnterprise = signleEnterpriseService.selectByPrimaryKey(se_id);
		
		modelAndView.addObject("seEnterprise", seEnterprise);
		
		modelAndView.setViewName("view/signleEnterpriseUpdate");
		
		return modelAndView;
	}
	
	/**
	 * 保存
	 * @param request
	 * @param signleEnterprise
	 * @return
	 */
	@RequestMapping(value = "saveSignleEnterprise.do", method = RequestMethod.POST)
	public ModelAndView saveSignleEnterprise(HttpServletRequest request, SignleEnterprise signleEnterprise){
		ModelAndView modelAndView = new ModelAndView();
		
		PlaUser plaUser = (PlaUser)request.getSession().getAttribute("userinfo");
		signleEnterprise.setAuthor(plaUser.getPlaUserId());
		if(signleEnterprise.getSeId() == null){
			signleEnterprise.setCreateTime(new Date());
			signleEnterpriseService.addSignleEnterprise(signleEnterprise);
		}else{
			signleEnterpriseService.updateSignleEnterprise(signleEnterprise);
		}
		
		modelAndView.setViewName("redirect:/signleEnterpriseDetail.do?se_id="+signleEnterprise.getSeId());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteSignleEnterprise.do")
	public ModelAndView saveSignleEnterprise(HttpServletRequest request,@RequestParam Integer se_id){
		ModelAndView modelAndView = new ModelAndView();
		
		signleEnterpriseService.deleteSingleEnterprise(se_id);
		
		modelAndView.setViewName("redirect:/signleEnterpriseList.do");
		
		return modelAndView;
	}
}
