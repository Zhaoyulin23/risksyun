package com.xj.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.RegEconomicsEnterprises;

public interface RegEconomicsEnterprisesService {
	
	public ModelAndView getRegEconomicsEnterprisesList(HttpServletRequest request, ModelAndView modelAndView);
	
	public RegEconomicsEnterprises selectByPrimaryKey(String rge_id);
	
	public int addRegEconomicsEnterprises(RegEconomicsEnterprises regEconomicsEnterprises);
	
	public int updateRegEconomicsEnterprises(RegEconomicsEnterprises regEconomicsEnterprises);
	
	public int deleteRegEconomicsEnterprises(String rge_id);
}
