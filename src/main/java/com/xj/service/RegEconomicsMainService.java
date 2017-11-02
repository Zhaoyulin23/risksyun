package com.xj.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.RegEconomicsMain;

public interface RegEconomicsMainService {
	
	public ModelAndView getRegEconomicsMainList(HttpServletRequest request, ModelAndView modelAndView);
	
	public RegEconomicsMain selectByPrimaryKey(int rem_id);
	
	public int addRegEconomicsMain(RegEconomicsMain regEconomicsMain);
	
	public int updateRegEconomicsMain(RegEconomicsMain regEconomicsMain);
	
	public int deleteRegEconomicsMain(Integer rem_id);
}
