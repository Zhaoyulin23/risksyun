package com.xj.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.RegEconomicsMain;
import com.xj.service.RegEconomicsMainService;

@Controller
public class RegEconomicsMainController {
	
	@Autowired
	private RegEconomicsMainService regEconomicsMainService;
	
	/**
	 * 
	 * 获取区域经济列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/regEconomicsMainList.do")
	public ModelAndView getSeList(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView = regEconomicsMainService.getRegEconomicsMainList(request, modelAndView);
		
		modelAndView.setViewName("view/regEconomicsMainManage");
		
		return modelAndView;
	}
	
	
	/**
	 * 获取区域经济详细
	 * @param request
	 * @param rem_id
	 * @return
	 */
	@RequestMapping(value = "/regEconomicsMainDetail.do")
	public ModelAndView getSeDetail(HttpServletRequest request, @RequestParam int rem_id){
		ModelAndView modelAndView = new ModelAndView();
		
		RegEconomicsMain reMain = new RegEconomicsMain();
		
		reMain = regEconomicsMainService.selectByPrimaryKey(rem_id);
		
		modelAndView.addObject("reMain", reMain);
		
		modelAndView.setViewName("view/regEconomicsMainUpdate");
		
		return modelAndView;
	}
	
	/**
	 * 保存
	 * @param request
	 * @param regEconomicsMain
	 * @return
	 */
	@RequestMapping(value = "saveRegEconomicsMain.do", method = RequestMethod.POST)
	public ModelAndView saveRegEconomicsMain(HttpServletRequest request, RegEconomicsMain regEconomicsMain){
		ModelAndView modelAndView = new ModelAndView();
		
		
		if(regEconomicsMain.getRemId() == null){
			regEconomicsMain.setCreateTime(new Date());
			regEconomicsMainService.addRegEconomicsMain(regEconomicsMain);
		}else{
			regEconomicsMainService.updateRegEconomicsMain(regEconomicsMain);
		}
		
		modelAndView.setViewName("redirect:/regEconomicsMainDetail.do?rem_id="+regEconomicsMain.getRemId());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteRegEconomicsMain.do")
	public ModelAndView saveRegEconomicsMain(HttpServletRequest request,@RequestParam Integer rem_id){
		ModelAndView modelAndView = new ModelAndView();
		
		regEconomicsMainService.deleteRegEconomicsMain(rem_id);
		
		modelAndView.setViewName("redirect:/regEconomicsMainList.do");
		
		return modelAndView;
	}
}
