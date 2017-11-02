package com.xj.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.RegEconomicsEnterprisesRank;
import com.xj.service.RegEconomicsEnterprisesRankService;

@Controller
public class RegEconomicsEnterprisesRankController {
	
	@Autowired
	private RegEconomicsEnterprisesRankService regEconomicsEnterprisesRankService;
	
	/**
	 * 
	 * 获取区域经济企业排名列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/regEconomicsEnterprisesRankList.do")
	public ModelAndView getSeList(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView = regEconomicsEnterprisesRankService.getRegEconomicsEnterprisesRankList(request, modelAndView);
		
		modelAndView.setViewName("view/regEconomicsEnterprisesRankManage");
		
		return modelAndView;
	}
	
	
	/**
	 * 获取区域经济企业详排名细
	 * @param request
	 * @param rer_id
	 * @return
	 */
	@RequestMapping(value = "/regEconomicsEnterprisesRankDetail.do")
	public ModelAndView getSeDetail(HttpServletRequest request, @RequestParam int rer_id){
		ModelAndView modelAndView = new ModelAndView();
		
		RegEconomicsEnterprisesRank rerEnterprise = new RegEconomicsEnterprisesRank();
		
		rerEnterprise = regEconomicsEnterprisesRankService.selectByPrimaryKey(rer_id);
		
		modelAndView.addObject("rerEnterprise", rerEnterprise);
		
		modelAndView.setViewName("view/regEconomicsEnterprisesRankUpdate");
		
		return modelAndView;
	}
	
	/**
	 * 保存
	 * @param request
	 * @param regEconomicsEnterprisesRank
	 * @return
	 */
	@RequestMapping(value = "saveRegEconomicsEnterprisesRank.do", method = RequestMethod.POST)
	public ModelAndView saveRegEconomicsEnterprisesRank(HttpServletRequest request, RegEconomicsEnterprisesRank regEconomicsEnterprisesRank){
		ModelAndView modelAndView = new ModelAndView();
		
		
		if(regEconomicsEnterprisesRank.getRerId() == null){
			regEconomicsEnterprisesRank.setCreateTime(new Date());
			regEconomicsEnterprisesRankService.addRegEconomicsEnterprisesRank(regEconomicsEnterprisesRank);
		}else{
			regEconomicsEnterprisesRankService.updateRegEconomicsEnterprisesRank(regEconomicsEnterprisesRank);
		}
		
		modelAndView.setViewName("redirect:/regEconomicsEnterprisesRankDetail.do?rer_id="+regEconomicsEnterprisesRank.getRerId());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteRegEconomicsEnterprisesRank.do")
	public ModelAndView saveRegEconomicsEnterprisesRank(HttpServletRequest request,@RequestParam Integer rer_id){
		ModelAndView modelAndView = new ModelAndView();
		
		regEconomicsEnterprisesRankService.deleteRegEconomicsEnterprisesRank(rer_id);
		
		modelAndView.setViewName("redirect:/regEconomicsEnterprisesRankList.do");
		
		return modelAndView;
	}
}
