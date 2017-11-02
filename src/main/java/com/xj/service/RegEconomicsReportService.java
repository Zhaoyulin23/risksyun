package com.xj.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.RegEconomicsReport;

public interface RegEconomicsReportService {
	
	public ModelAndView getRegEconomicsReportList(HttpServletRequest request, ModelAndView modelAndView);
	
	public RegEconomicsReport selectByPrimaryKey(int rer_id);
	
	public int addRegEconomicsReport(RegEconomicsReport regEconomicsReport);
	
	public int updateRegEconomicsReport(RegEconomicsReport regEconomicsReport);
	
	public int deleteRegEconomicsReport(Integer rer_id);
}
