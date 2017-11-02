package com.xj.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.IndustryStatEnterprisesRank;
import com.xj.service.IndustryStatEnterprisesRankService;

//@Controller
public class IndustryStatEnterprisesRankController {
	
	@Autowired
	private IndustryStatEnterprisesRankService industryStatEnterprisesRankService;
	
	/**
	 * 
	 * 获取企业排名列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/industryStatEnterprisesRankList.do")
	public ModelAndView getSeList(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView = industryStatEnterprisesRankService.getIndustryStatEnterprisesRankList(request, modelAndView);
		
		modelAndView.setViewName("view/industryStatEnterprisesRankManage");
		
		return modelAndView;
	}
	
	
	/**
	 * 获取企业排名详细
	 * @param request
	 * @param ier_id
	 * @return
	 */
	@RequestMapping(value = "/industryStatEnterprisesRankDetail.do")
	public ModelAndView getSeDetail(HttpServletRequest request, @RequestParam int ier_id){
		ModelAndView modelAndView = new ModelAndView();
		
		IndustryStatEnterprisesRank iseEnterprise = new IndustryStatEnterprisesRank();
		
		iseEnterprise = industryStatEnterprisesRankService.selectByPrimaryKey(ier_id);
		
		modelAndView.addObject("iseEnterprise", iseEnterprise);
		
		modelAndView.setViewName("view/industryStatEnterprisesRankUpdate");
		
		return modelAndView;
	}
	
	/**
	 * 保存
	 * @param request
	 * @param industryStatEnterprisesRank
	 * @return
	 */
	@RequestMapping(value = "saveIndustryStatEnterprisesRank.do", method = RequestMethod.POST)
	public ModelAndView saveIndustryStatEnterprisesRank(HttpServletRequest request, IndustryStatEnterprisesRank industryStatEnterprisesRank){
		ModelAndView modelAndView = new ModelAndView();
		
		
		if(industryStatEnterprisesRank.getIerId() == null){
			industryStatEnterprisesRank.setCreateTime(new Date());
			industryStatEnterprisesRankService.addIndustryStatEnterprisesRank(industryStatEnterprisesRank);
		}else{
			industryStatEnterprisesRankService.updateIndustryStatEnterprisesRank(industryStatEnterprisesRank);
		}
		
		modelAndView.setViewName("redirect:/industryStatEnterprisesRankDetail.do?ier_id="+industryStatEnterprisesRank.getIerId());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteIndustryStatEnterprisesRank.do")
	public ModelAndView saveIndustryStatEnterprisesRank(HttpServletRequest request,@RequestParam Integer ier_id){
		ModelAndView modelAndView = new ModelAndView();
		
		industryStatEnterprisesRankService.deleteIndustryStatEnterprisesRank(ier_id);
		
		modelAndView.setViewName("redirect:/industryStatEnterprisesRankList.do");
		
		return modelAndView;
	}
}
