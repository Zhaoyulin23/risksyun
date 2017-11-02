package com.xj.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.Industry;

public interface IndustryService {

	public ModelAndView getIndustryList(HttpServletRequest request, ModelAndView modelAndView);
	
	public Industry selectByPrimaryKey(int id);
	
	public int addIndustry(Industry industry);
	
	public int updateIndustry(Industry industry);
	
	public int deleteIndustry(Integer id);
	
	public List<Industry> getSeIndustryCategory();
	
	public List<Industry> getSeIndustryClass(Integer industryCategory);
	
	public List<Industry> getSeIndustrySclass(Integer industryClass);
}
