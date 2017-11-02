package com.xj.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.IndustryStatEnterprises;

public interface IndustryStatEnterprisesService {
	
	public ModelAndView getIndustryStatEnterprisesList(HttpServletRequest request, ModelAndView modelAndView);
	
	public IndustryStatEnterprises selectByPrimaryKey(int iseId);
	
	public int addIndustryStatEnterprises(IndustryStatEnterprises industryStatEnterprises);
	
	public int updateIndustryStatEnterprises(IndustryStatEnterprises industryStatEnterprises);
	
	public int deleteIndustryStatEnterprises(Integer iseId);
}
