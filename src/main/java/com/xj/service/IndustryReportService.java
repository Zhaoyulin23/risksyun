package com.xj.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.IndustryReport;

public interface IndustryReportService {

	public ModelAndView getIndustryReportList(HttpServletRequest request, ModelAndView modelAndView);
	
	public IndustryReport selectByPrimaryKey(int industryStatisticsId);
	
	public int addIndustryReport(IndustryReport industryReport);
	
	public int updateIndustryReport(IndustryReport industryReport);
	
	public int deleteIndustryReport(Integer industryStatisticsId);
}
