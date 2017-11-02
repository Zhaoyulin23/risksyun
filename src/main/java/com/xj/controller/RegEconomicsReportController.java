package com.xj.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.RegEconomicsReport;
import com.xj.service.RegEconomicsReportService;

@Controller
public class RegEconomicsReportController {
	
	@Autowired
	private RegEconomicsReportService regEconomicsReportService;
	
	/**
	 * 
	 * 获取区域经济报告列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/regEconomicsReportList.do")
	public ModelAndView getSeList(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView = regEconomicsReportService.getRegEconomicsReportList(request, modelAndView);
		
		modelAndView.setViewName("view/regEconomicsReportManage");
		
		return modelAndView;
	}
	
	
	/**
	 * 获取报告详细
	 * @param request
	 * @param rer_id
	 * @return
	 */
	@RequestMapping(value = "/regEconomicsReportDetail.do")
	public ModelAndView getSeDetail(HttpServletRequest request, @RequestParam int rer_id){
		ModelAndView modelAndView = new ModelAndView();
		
		RegEconomicsReport reReport = new RegEconomicsReport();
		
		reReport = regEconomicsReportService.selectByPrimaryKey(rer_id);
		
		modelAndView.addObject("reReport", reReport);
		
		modelAndView.setViewName("view/regEconomicsReportUpdate");
		
		return modelAndView;
	}
	
	/**
	 * 保存
	 * @param request
	 * @param regEconomicsReport
	 * @return
	 */
	@RequestMapping(value = "saveRegEconomicsReport.do", method = RequestMethod.POST)
	public ModelAndView saveRegEconomicsReport(HttpServletRequest request, RegEconomicsReport regEconomicsReport){
		ModelAndView modelAndView = new ModelAndView();
		
		
		if(regEconomicsReport.getRerId() == null){
			regEconomicsReport.setCreateTime(new Date());
			regEconomicsReportService.addRegEconomicsReport(regEconomicsReport);
		}else{
			regEconomicsReportService.updateRegEconomicsReport(regEconomicsReport);
		}
		
		modelAndView.setViewName("redirect:/regEconomicsReportDetail.do?rer_id="+regEconomicsReport.getRerId());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteRegEconomicsReport.do")
	public ModelAndView saveRegEconomicsReport(HttpServletRequest request,@RequestParam Integer rer_id){
		ModelAndView modelAndView = new ModelAndView();
		
		regEconomicsReportService.deleteRegEconomicsReport(rer_id);
		
		modelAndView.setViewName("redirect:/regEconomicsReportList.do");
		
		return modelAndView;
	}
}
