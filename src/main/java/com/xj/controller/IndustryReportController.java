package com.xj.controller;

import java.util.Date;
//import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.IndustryReport;
import com.xj.service.IndustryReportService;

//@Controller
public class IndustryReportController {
	
	@Autowired
	private IndustryReportService industryReportService;
	
	/**
	 * 
	 * 获取行业报告列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/industryReportListdo")
	public ModelAndView getSeList(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView = industryReportService.getIndustryReportList(request, modelAndView);
		
		modelAndView.setViewName("view/industryReportManage");
		
		return modelAndView;
	}
	
	
	/**
	 * 获取行业详细
	 * @param request
	 * @param industryStatisticsId
	 * @return
	 */
	@RequestMapping(value = "/industryReportDetail.do")
	public ModelAndView getSeDetail(HttpServletRequest request, @RequestParam int industryStatisticsId){
		ModelAndView modelAndView = new ModelAndView();
		
		IndustryReport siReport = new IndustryReport();
		
		siReport = industryReportService.selectByPrimaryKey(industryStatisticsId);
		
		modelAndView.addObject("siReport", siReport);
		
		modelAndView.setViewName("view/industryReportUpdate");
		
		return modelAndView;
	}
	
	/**
	 * 保存
	 * @param request
	 * @param industryReport
	 * @return
	 */
	@RequestMapping(value = "saveIndustryReport.do", method = RequestMethod.POST)
	public ModelAndView saveIndustryReport(HttpServletRequest request, IndustryReport industryReport){
		ModelAndView modelAndView = new ModelAndView();
		
		
		if(industryReport.getIndustryStatisticsId() == null){
			industryReport.setCreateTime(new Date());
			industryReportService.addIndustryReport(industryReport);
		}else{
			industryReportService.updateIndustryReport(industryReport);
		}
		
		modelAndView.setViewName("redirect:/IndustryReportDetail.do?id="+industryReport.getIndustryStatisticsId());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteIndustryReport.do")
	public ModelAndView saveIndustryReport(HttpServletRequest request,@RequestParam Integer industryStatisticsId){
		ModelAndView modelAndView = new ModelAndView();
		
		industryReportService.deleteIndustryReport(industryStatisticsId);
		
		modelAndView.setViewName("redirect:/industryReportList.do");
		
		return modelAndView;
	}
}
